


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

	protected int wx;// dimention du monde posx
	protected int wy;// dimention du monde posy

	
	protected boolean alive;

	public static final int NORD = 0;
	public static final int EST = 1;
	public static final int SUD = 2;
	public static final int OUEST = 3;

	public Agent(int x, int y, int wx,int wy){
		this.x=x;
		this.y=y;
		this.wx=wx;
		this.wy=wy;
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

	public abstract int getLife();
	public abstract void step();
	public abstract Image getImage();
	
}