


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
		//w.majTab(x,y,10);
	}
	/*public Agent(int life, World w){
		int x1,y1;
		
		x1=(int)(Math.random()*w.getSizex());
		y1=(int)(Math.random()*w.getSizex());
		
		x=x1;
		y=y1;
		this.life=life;
		this.w=w;
		alive=true;
		//w.majTab(x,y,10);
	}*/
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