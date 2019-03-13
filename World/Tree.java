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
	public final static int LIFE=10;

	private int x,y;

	private boolean burn;
	private boolean alive;
	private int life;
	private Image sprite;
	private Image spriteCoal;
	private Image spriteFire;


	public Tree(int x,int y){
		this.x=x;
		this.y=y;
		burn=false;
		alive=false;
		life=0;

		try{
			sprite = ImageIO.read(new File("tree.png"));
			spriteCoal = ImageIO.read(new File("coaltree.png"));
			spriteFire = ImageIO.read(new File("fire.png"));

		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
	}
	public static Tree clonage(Tree t){
		Tree clone = new Tree(t.getX(),t.getY());
		clone.setLife(t.getLife());
		clone.setAlive(t.isAlive());
		clone.setBurn(t.isBurn());
		return clone;

	}
	public void affichage(Graphics2D g2, JFrame frame){
		if(alive==true && life >0){
			if(life==1){
				g2.drawImage(spriteCoal, World.spriteLength*x, World.spriteLength*y, World.spriteLength, World.spriteLength, frame);
			}else{
				g2.drawImage(sprite, World.spriteLength*x, World.spriteLength*y, World.spriteLength, World.spriteLength, frame);
			}
			if (burn==true) //Arbre en feu
				g2.drawImage(spriteFire, World.spriteLength*x, World.spriteLength*y, World.spriteLength, World.spriteLength, frame);
		}
	}

	public void step(){
		if(life<=0){
			alive=false;
			burn=false;
		}
		if(burn==true){
			life--;
		}
	}

	public void burn(){
		burn=true;
	}
	public void alive(){
		life=LIFE;
		alive=true;
	}
	//Set
	public void setAlive(boolean a){
		alive=a;
	}
	public void setBurn(boolean b){
		burn=b;
	}
	public void setLife(int l){
		life=l;
	}
	//Accesseur 

	public boolean isAlive(){
		return alive;
	}
	public boolean isBurn(){
		return burn;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public Image getImage(){
		return sprite;
	}
	public int getLife(){
		return life;
	}

}