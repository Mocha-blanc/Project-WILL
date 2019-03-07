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

public class Map{
	private int x;
	private int y;

	int tableau[][];
	Terrain affichage[][];
	public Map(int x, int y){
		this.x=x;
		this.y=y;
		affichage = new Terrain[x][y];
		for (int i=0; i<x ;i++)
			for (int j=0; j<y ; j++)
				affichage[i][j]= new Water(i,j,"water.png");

		for (int i=3; i<x-3; i++)
			for (int j=3; j<y-3; j++)
				affichage[i][j]=new Sand(i,j,"sand.png","grass.png");


	}

	public void affichage(Graphics2D g2, JFrame frame){
		for (int i=0; i<x ; i++)
			for (int j=0; j<y ; j++)
				affichage[i][j].affichage(g2, frame);
	}
	public void step(){
		for (int i=0; i<x ; i++)
			for (int j=0; j<y ; j++)
				if(affichage[i][j].getType()==Terrain.SAND )
					if(Main.BGRASS>Math.random())
						affichage[i][j].step();
	}

	//Accesseur
	public Terrain getAffichage(int x,int y){
		return affichage[x][y];
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}