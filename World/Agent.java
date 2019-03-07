


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Agent {

	protected int x; //posx
	protected int y; //posy

	protected Map m;

	
	protected boolean alive;
	protected int life;
	protected int direction;

	public Agent(int life, Map m){
		this.life=life;
		this.m=m;
		alive=true;
		
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
	public abstract void move();
	public abstract void step();
	public abstract Image getImage();
	
}