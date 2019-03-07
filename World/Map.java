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

	//Probabilite de réaparition 
	public final static double BGRASS=0.1;  //Herbre
	public final static double BTREE=0.2; //Arbre

	public final static double BFEU=0.01; //Feu



	private int x;
	private int y;

    public static int WATER=0; //Eau
	public static int TREE=1; //Arbre
	public static int SAND=2; //Sable
	
	private Terrain affichage[][];
	private int arbre[][];
	private ArrayList<Tree> tree;
	public Map(int x, int y){
		this.x=x;
		this.y=y;

		affichage = new Terrain[x][y];
		arbre=new int[x][y];
		tree=new ArrayList<Tree>();
		for (int i=0; i<x ;i++)
			for (int j=0; j<y ; j++){
				affichage[i][j]= new Water(i,j);
				arbre[i][j]=0;
			}

		for (int i=3; i<x-3; i++)
			for (int j=3; j<y-3; j++){
				affichage[i][j]=new Sand(i,j);
			}
	}

	public void affichage(Graphics2D g2, JFrame frame){
		for (int i=0; i<x ; i++)
			for (int j=0; j<y ; j++){
				affichage[i][j].affichage(g2, frame);
			}
		for (Tree a : tree){
			a.affichage(g2, frame);
		}
	}

	public void step(){
		for (int i=0; i<tree.size();i++){
			tree.get(i).step();

			if(tree.get(i).isAlive()==false){
				arbre[a.get()][a.getY()]=0;
				tree.remove(tree.get(i));
			}
		}
		for (Tree a : tree){
			if(BFEU>Math.random())
				a.burn();
			if(a.isAlive()==false){

			}
		}
		for (int i=0; i<x ; i++)
			for (int j=0; j<y ; j++)
				if(affichage[i][j].getType()==Terrain.SAND ){
					if(BGRASS>Math.random())
						((Sand)affichage[i][j]).step();

					if(BTREE>Math.random() && arbre[i][j]==0)
						tree.add(new Tree(i,j));
						arbre[i][j]=1;
				}
		
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