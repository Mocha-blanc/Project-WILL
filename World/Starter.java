import java.util.ArrayList;

public abstract class Starter extends Agent{
	public final static int LVEVOLUTION2=5; //NIVEAU lequel le pokemon evolue au stade moyen
	public final static int LVEVOLUTION3=7; //NIVEAU lequel le pokemon evolue au stade final
	protected int type;
	protected int lv;
	protected String sexe;
	protected int etat;
	protected int lifemax;
	protected boolean fighting;
	protected int attack;
	protected int exp_actuel;
	protected int value_xp;
	protected int reproduire;

	
	public Starter(int life, Map m, String name) {
		super(life, m, name);
		lifemax=life;
		attack=1;
		lv=1;
		etat=1;
		exp_actuel=0;
		reproduire=10;
		if(Math.random()<0.5) {
			sexe="male";
		}else {
			sexe="femelle";
		}
	}
	public void findEnnemy(ArrayList <Starter> a) {
		if(Gestion_agent.getStarter(x,y-1, a)!=null && Gestion_agent.getStarter(x,y-1, a).getType()!=type) {
			direction=NORD;
		
		}else if(Gestion_agent.getStarter(x+1,y, a)!=null && Gestion_agent.getStarter(x+1,y, a).getType()!=type) {
			direction=EST;
		
		}else if(Gestion_agent.getStarter(x,y+1, a)!=null && Gestion_agent.getStarter(x,y+1, a).getType()!=type) {
			direction=SUD;
		
		}else if(Gestion_agent.getStarter(x-1,y, a)!=null && Gestion_agent.getStarter(x-1,y, a).getType()!=type) {
			direction=WEST;
	
		}else {
			fighting=false;
		}
	}
	public void giveExp(ArrayList <Starter> a) {
		if(Gestion_agent.getStarter(x,y-1, a)!=null && Gestion_agent.getStarter(x,y-1, a).getType()!=type) {
			Gestion_agent.getStarter(x,y-1, a).setExp(value_xp*lv);
		
		}
		if(Gestion_agent.getStarter(x+1,y, a)!=null && Gestion_agent.getStarter(x+1,y, a).getType()!=type) {
			Gestion_agent.getStarter(x+1,y, a).setExp(value_xp*lv);
		
		}
		if(Gestion_agent.getStarter(x,y+1, a)!=null && Gestion_agent.getStarter(x,y+1, a).getType()!=type) {
			Gestion_agent.getStarter(x,y+1, a).setExp(value_xp*lv);
		
		}
		if(Gestion_agent.getStarter(x-1,y, a)!=null && Gestion_agent.getStarter(x-1,y, a).getType()!=type) {
			Gestion_agent.getStarter(x-1,y, a).setExp(value_xp*lv);
	
		}
	}
	public void attack(int x, int y, ArrayList <Starter> a) {
		for(int i=0; i<a.size();i++) {
			if(a.get(i).getX()==x && a.get(i).getY()==y)
				if(type==FEU && a.get(i).getType()==HERBE) {
					a.get(i).setDommage(2*attack);
				}else if((type-a.get(i).getType())==1) {
					a.get(i).setDommage(2*attack);
				}else {
					a.get(i).setDommage(attack);
				}
		}
	}
	public void step(ArrayList <Starter> a) {
		move=false;
		fighting=true;
		findEnnemy(a);
		up();
		int x1=x;
		int y1=y;
		reproduire++;
		if(fighting==false) {
			direction=(int)(Math.random()*4);
		}
		if ( direction == NORD) // nord
        	y1 = (y1 - 1) ;
        if ( direction == EST)	// est
        	x1 = (x1 + 1);
        if ( direction == SUD)	// sud
         	y1 = (y1 + 1);
        if ( direction == WEST)// ouest
         	x1 = (x1 - 1);
        
		if(fighting==true) {
			
			attack(x1,y1,a);
		
		}else {
			if ((m.getTerrain(x1,y1)==Map.SAND || m.getTerrain(x1,y1)==Map.LAWN ) && m.getTree(x1,y1).getLife()==0)
				move=true;
		}
		if (life<= 0){
			alive=false;
			giveExp(a);
		}
		
	}
	public void evolution() {
		attack++;
		lifemax+=10;
		life=lifemax;
		etat++;
		if(type==FEU) {
			if(etat==2) {
				name="reptincel";
			}else if(etat==3) {
				name="dracaufeu";
			}
		}else if(type==EAU) {
			if(etat==2) {
				name="carabaffe";
			}else if(etat==3) {
				name="tortank";
			}
		}else if( type == HERBE) {
			if(etat==2) {
				name="herbizarre";
			}else if(etat==3) {
				name="florizarre";
			}
		}
	}
	public void up() {
		while(exp_actuel>(int)(0.8*Math.pow(lv, 3))) {
			lv++;
			exp_actuel-=(int)(0.8*Math.pow(lv, 3));
		}
		if(lv>=LVEVOLUTION2 && etat == 1) {
			evolution();
		}
		if(lv>=LVEVOLUTION3 && etat == 2) {
			evolution();
			
		}
	}
	public void eatObject(){
		if(m.getObject(x,y)==Map.GRASS){
			m.setObject(x,y,Map.VIDE);
			if(life<lifemax)
				life=(life+5);
			while(life>lifemax) {
				life--;
			}
		}
	}
	public void setDommage(int v) {
		life-=v;
	}
	public void setExp(int v) {
		exp_actuel+=v;
	}
	public void reproduire() {
		reproduire=0;
	}
	public int getReproduire() {
		return reproduire;
	}
	public int getLv() {
		return lv;
	}
	public int getLifemax() {
		return lifemax;
	}
	public String getSexe() {
		return sexe;
	}
	public int getEtat() {
		return etat;
	}
	public int getType() {
		return type;
	}
	public abstract void move();
	//public abstract void step(ArrayList <Starter> a);
	
}
