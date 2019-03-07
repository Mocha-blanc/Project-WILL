import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tree extends Terrain{
	private int etat;
	private int life;
	private Image sprite1;
	public Tree(int x,int y,String image, String image1){
		super(x,y);
		etat=1;
		
		type=Terrain.TREE;
		try{
			sprite = ImageIO.read(new File(image));
			sprite1 = ImageIO.read(new File(image1));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public void affichage(Graphics2D g2, JFrame frame){
		if(etat==1){
			g2.drawImage(sprite, 32*x, 32*y, 32, 32, frame);
		}else if (etat==2) { //Arbre en feu
			g2.drawImage(sprite, 32*x, 32*y, 32, 32, frame);
			g2.drawImage(sprite1, 32*x, 32*y, 32, 32, frame);
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

	public void step(){}
	public Image getImage(){
		return sprite;
	}
	public int getLife(){
		return life;
	}

}