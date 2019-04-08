
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
	}
	
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
	
}