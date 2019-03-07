import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
public abstract class Object{
	protected int x;
	protected int y;
	protected int type;
	protected World w;
	protected Image sprite;


	public static int WATER=0; //Eau
	public static int TREE=1; //Arbre





	public Object(int x,int y,World w){
		this.x=x;
		this.y=y;
		this.w=w;
	}
	public Object(World w){
		x=(int)(Math.random()*w.getSizex());
		y=(int)(Math.random()*w.getSizex());
		this.w=w;
	}


	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getType(){
		return type;
	}

	public abstract Image getImage();
}