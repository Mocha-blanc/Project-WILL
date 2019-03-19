


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;

public abstract class Agent {

	protected int x; //posx
	protected int y; //posy

	protected Map m;

	protected boolean move;
	protected boolean alive;
	protected int life;
	protected int direction;
	protected String name;

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
	//L'utilisation pour l'intelligence artificielle
	public static int detection(int x, int y, String n, int i, ArrayList<Agent> a){
		int x1=x;
		int y1=y;
		if(i<=0){
			return -1;
		}
		if(findAgent(x1, y1 - 1,a)!=null && findAgent(x1, y1 - 1, a).getName().equals(n)){
			return Agent.NORD;
		}

		if(findAgent(x1 + 1, y1,a)!=null && findAgent(x1 + 1, y1, a).getName().equals(n)){
			return Agent.EST;
		}

		if(findAgent(x1, y1 + 1,a)!=null && findAgent(x1, y1 + 1, a).getName().equals(n)){
			return Agent.SUD;
		}

		if(findAgent(x1 - 1, y1,a)!=null && findAgent(x1 - 1, y1, a).getName().equals(n)){
			return Agent.WEST;
		}


		if(0<=detection(x1, y1 - 1,n,i-1,a)){
			return Agent.NORD;
		}
		if(0<=detection(x1 + 1, y1,n ,i-1,a)){
			return Agent.EST;
		}
		if(0<=detection(x1, y1 + 1,n ,i-1,a)){
			return Agent.SUD;
		}
		if(0<=detection(x1 - 1, y1, n,i-1, a)){
			return Agent.WEST;
		}

		return -1;
	}

	public static Agent findAgent(int x, int y, ArrayList<Agent> agent){
		for (Agent a : agent){
			if(a.getX()==x && a.getY()==y){
				return a;
			}
		}
		return null;
	}

	//Set
	public void setAlive(boolean l){
		alive=l;
	}
	//Accesseur
	public String getName(){
		return name;
	}
	public boolean isMove(){
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
	/*public World getWorld(){
		return w;
	}*/
	public abstract void rayonDetection(String n, int i, ArrayList<Agent> a);
	public abstract void move();
	public abstract void step(ArrayList<Agent> a);
	public abstract int getDirection();

	
}