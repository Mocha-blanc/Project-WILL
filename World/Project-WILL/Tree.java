import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tree extends Object{
	private Image sprite;
	private int etat;
	private int life;

	public Tree(int x,int y, String image){
		super(x,y);
		life=50;
		try{
			sprite = ImageIO.read(new File(image));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public void burn(){
		try{
			sprite = ImageIO.read(new File("fire.png"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public Image getImage(){
		return sprite;
	}
	public int getLife(){
		return life;
	}
}