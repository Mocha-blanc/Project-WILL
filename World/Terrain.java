
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

public abstract class Terrain {
	protected int x;
	protected int y;
	protected int type;

	protected Image sprite;

	public static int WATER=0; //Eau
	public static int TREE=1; //Arbre
	public static int SAND=2; //Sable


	public Terrain(int x,int y){
		this.x=x;
		this.y=y;
	}






	//Accesseur 
	public int getType(){
		return type;
	}

	//abstract
	public abstract void affichage(Graphics2D g2, JFrame frame);



}