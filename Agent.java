
public abstract class Agent {

	protected int x; //posx
	protected int y; //posy

	protected Map m;

	protected boolean move;
	protected boolean alive;
	protected int life;
	protected int direction;
	protected String name;

	protected int detection[][];
	protected int tab[][];
	//Pour les types de pokemon
	public static final int FEU=1;
	public static final int EAU=2;
	public static final int HERBE=3;
	//Direction
	public static final int NORD=0;
	public static final int EST=1;
	public static final int SUD=2;
	public static final int WEST=3;

	public Agent(int life, Map m,String name){
		this.life=life;
		this.m=m;
		this.name=name;
		move=false;
		alive=true;
//
//		detection=new int[m.getX()][m.getX()];
//		tab=new int[m.getX()][m.getX()];
	}
	

//	public static int solution(int x, int y,int i,int dir,int detect[][]){
//		if (detect[x][y-1]==i+1) { //NORD
//			dir=SUD;
//			return solution(x, y-1,i+1,dir,detect);
//		}else if(detect[x+1][y]==i+1){ //EST
//			dir=WEST;
//			return solution(x+1,y,i+1,dir,detect);
//		}else if(detect[x-1][y]==i+1){ //WEST
//			dir=EST;
//			return solution(x-1,y,i+1,dir,detect);
//		}else if(detect[x][y+1]==i+1){ //SUD
//			dir=WEST;
//			return solution(x,y+1,i+1,dir,detect);
//		}
//		return dir;
//	}
//	
//	//L'utilisation pour l'intelligence artificielle
//	public static int detection(int x, int y, String n, int i, ArrayList<Agent> a, Map m){
//		
//		if(i<=0 || m.getTree(x, y).getLife()>0 || m.getTerrain(x, y)!=Map.SAND){ //ligne ou on indique les obstacle
//			return -1;
//		}
//
//		
//		if(findAgent(x, y - 1,a)!=null && findAgent(x, y - 1, a).getName().equals(n)){
//			return Agent.NORD;
//		}
//
//		if(findAgent(x + 1, y,a)!=null && findAgent(x + 1, y, a).getName().equals(n)){
//			return Agent.EST;
//		}
//
//		if(findAgent(x, y + 1,a)!=null && findAgent(x, y + 1, a).getName().equals(n)){
//			return Agent.SUD;
//		}
//
//		if(findAgent(x - 1, y,a)!=null && findAgent(x - 1, y, a).getName().equals(n)){
//			return Agent.WEST;
//		}
//		//recursion
//		if(0<=detection(x, y - 1,n,i-1, a, m)){
//			return Agent.NORD;
//		}
//		if(0<=detection(x + 1, y,n ,i-1, a, m)){
//			return Agent.EST;
//		}
//		if(0<=detection(x, y + 1,n ,i-1, a, m)){
//			return Agent.SUD;
//		}
//		if(0<=detection(x - 1, y, n,i-1, a, m)){
//			return Agent.WEST;
//		}
//
//		return -1;
//	}
//
//	public static Agent findAgent(int x, int y, ArrayList<Agent> agent){
//		for (Agent a : agent){
//			if(a.getX()==x && a.getY()==y){
//				return a;
//			}
//		}
//		return null;
//	}
//	public boolean moving(int d){
//		int x1=x;
//		int y1=y;
//		
//		if ( d == NORD) // nord
//        	y1 = (y1 - 1) ;
//        if ( d == EST)	// est
//        	x1 = (x1 + 1);
//        if ( d == SUD)	// sud
//         	y1 = (y1 + 1);
//        if ( d == WEST)// ouest
//         	x1 = (x1 - 1);
//        if (m.getTerrain(x1,y1)==Map.SAND && m.getTree(x1,y1).getLife()==0)
//        	return true;
//        return false;
//	}

	//Set
	public void setAlive(boolean l){
		alive=l;
	}
	
	public void setDirection(int x){
		direction=x;
	}
	//Accesseur
	public String getName(){
		return name;
	}
	public boolean getMove(){
		return move;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getLife(){
		return life;
	}
	public Map getMap(){
		return m;
	}
	public int getDirection() {
		return direction;
	}
	public boolean isAlive() {
		return alive;
	}
	/*public World getWorld(){
		return w;
	}*/
	
	//public abstract void rayonDetection(String n, int i, ArrayList<Agent> a);
	
	
}