import java.util.ArrayList;

public class Gestion_agent {
	public final static double REPRODUCTIONSTARTER=0.5;
	public static final int TIMEREPRODUCTION=50;
	private ArrayList<Cloud> cloud;
	private ArrayList<Starter> starter;
	private ArrayList<Egg> egg;
	
	public Gestion_agent() {
		cloud=new ArrayList<Cloud>();
		starter=new ArrayList<Starter>();
		egg=new ArrayList<Egg>();
	}
	
	public void addcloud(Cloud a){	
		cloud.add(a);
	}
	public void addStater(Starter a) {
		starter.add(a);
	}
	public void addEgg(Egg a) {
		egg.add(a);
	}
	
	public void stepcloud(Map m){
		if(Math.random()<World.BCLOUD)
			cloud.add(new Cloud(500,m));

		for (int i=0; i<cloud.size();i++){ //MAJ des agents
			cloud.get(i).step();
		}
		removeCloud();
	}
	public void stepStarter(Map m) {
		for(int i=0; i<starter.size(); i++) {
			starter.get(i).step(starter);
		}
		removeStarter();
	}
	public void stepEgg(Map m) {
		for(int i=0;i<egg.size();i++)
			egg.get(i).step(starter);
		removeEgg();
		
	}
	public void moveAllcloud() {
		for (int i=0; i<cloud.size();i++){ //MAJ des deplacements des agents 
			cloud.get(i).move();
		}
	}
	public void moveAllstarter() {
		for (int i=0; i<starter.size();i++)
			starter.get(i).move();
	}
	public void removeCloud(){ //Enleve les agents de la liste si alive = false
		for (int i=0; i<cloud.size();i++){
			if(cloud.get(i).isAlive()==false){
				cloud.remove(cloud.get(i));
			}
			
		}
	}
	public void removeStarter(){ //Enleve les agents de la liste si alive = false
		for (int i=0; i<starter.size();i++){
			if(starter.get(i).isAlive()==false){
				starter.remove(starter.get(i));
			}	
		}
	}
	public void removeEgg() {
		for(int i=0; i<egg.size();i++)
			if(egg.get(i).isAlive()==false) {
				egg.remove(egg.get(i));
			}
	}
	public void reproduction(Map m) {
		for (int i=0; i<starter.size();i++ ) {
			if(starter.get(i).getSexe().equals("femelle") && starter.get(i).getReproduire()>TIMEREPRODUCTION){
				for (int i1=0; i1<starter.size();i1++) {
					if(starter.get(i).getX()==starter.get(i1).getX() && starter.get(i).getY()==starter.get(i1).getY()) {
						if(starter.get(i1).getSexe().equals("male") && starter.get(i).getType() == starter.get(i1).getType()) {
							if(REPRODUCTIONSTARTER>Math.random()) {
								egg.add(new Egg(starter.get(i1).getType(),m,starter.get(i).getX(),starter.get(i).getY()));
								starter.get(i).reproduire();
							}
						}
					}
				}
			}
		}
	}
	
	public static boolean isStarter(int x,int y, ArrayList<Starter> agent){ //Fonction qui retourne faux s'il n'a pas d'agent sur cette position
		for (int i=0; i<agent.size();i++ ){
			if(agent.get(i).getX()==x && agent.get(i).getY()==y)
				return true;
		}
		return false;
	}
	public static Starter getStarter(int x,int y, ArrayList<Starter> agent) {
		for (int i=0; i<agent.size();i++ ){
			if(agent.get(i).getX()==x && agent.get(i).getY()==y)
				return agent.get(i);
		}
		return null;
	}
	public ArrayList<Cloud> getCloud(){
		return cloud;
	}
	public ArrayList<Starter> getStarter(){
		return starter;
	}
	public ArrayList<Egg> getEgg(){
		return egg;
	}
}
