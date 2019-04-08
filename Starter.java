import java.util.ArrayList;

public abstract class Starter extends Agent{
	
	protected int type;
	protected int lv;
	protected String sexe;
	protected int etat;
	protected int lifemax;
	protected boolean fighting;
	protected int attack;
	protected int exp_actuel;
	protected int exp_total;
	protected int value_xp;
	
	public Starter(int life, Map m, String name) {
		super(life, m, name);
		lifemax=life;
		lv=1;
		etat=1;
		exp_actuel=0;
		if(Math.random()<0.8) {
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
				}else if(type-a.get(i).getType()==2) {
					a.get(i).setDommage(2*attack);
				}else {
					a.get(i).setDommage(attack);
				}
		}
	}
	public void up() {
		while(exp_actuel>(int)(0.8*Math.pow(lv, 3))) {
			lv++;
			exp_actuel-=(int)(0.8*Math.pow(lv, 3));
		}
		System.out.println(lv);
	}
	public void setDommage(int v) {
		life-=v;
	}
	public void setExp(int v) {
		exp_actuel+=v;
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
	public abstract void step(ArrayList <Starter> a);
	
}
