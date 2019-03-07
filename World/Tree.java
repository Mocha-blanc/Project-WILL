import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tree {
	private int x,y;
	private int type;
	private boolean burn;
	private boolean alive;
	private int life;
	private Image sprite;
	private Image spriteFire;

	public Tree(int x,int y){
		this.x=x;
		this.y=y;

		burn=false;
		alive=true;

		type=Map.TREE;

		try{
			sprite = ImageIO.read(new File("tree.png"));
			spriteFire = ImageIO.read(new File("fire.png"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public void affichage(Graphics2D g2, JFrame frame){
		g2.drawImage(sprite, World.spriteLength*x, World.spriteLength*y, World.spriteLength, World.spriteLength, frame);
		if (burn) //Arbre en feu
			g2.drawImage(spriteFire, World.spriteLength*x, World.spriteLength*y, World.spriteLength, World.spriteLength, frame);
	}

	public void step(){
		if(life<=0)
			alive=false;
		if(burn==true)
			life--;
	}
	//Accesseur 
	public boolean isAlive(){
		return alive;
	}
	public boolean getTrue(){
		return tree=true;
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public boolean burn(){
		return burn=true;
	}
	public boolean getTree(){
		return tree;
	}
	public void step(){}
	public Image getImage(){
		return sprite;
	}
	public int getLife(){
		return life;
	}

}