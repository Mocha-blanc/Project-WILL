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

	protected ArrayList<Object> p = new ArrayList<Object>();
	public Object(int x,int y){
		this.x=x;
		this.y=y;
	}


	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

	public abstract Image getImage();
}