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
	public final static double BTREE=0.01; //Arbre

	public final static double BFEU=0.01; //Feu
	public final static double PFEU=0.01;


	
	private int x;
	private int y;

    public static int WATER=0; //Eau
	public static int TREE=1; //Arbre
	public static int SAND=2; //Sable
	
	private Terrain affichage[][];
	private int tab[][];
	private int arbre[][];
	private Tree tree[][];
	private Tree tabTree[][];
	public Map(int x, int y){
		this.x=x;
		this.y=y;

		affichage = new Terrain[x][y];
		tab = new int[x][y];
		arbre=new int[x][y];
		tree=new Tree[x][y];
		tabTree=new Tree[x][y];
		for (int i=0; i<x ;i++)
			for (int j=0; j<y ; j++){
				affichage[i][j]= new Water(i,j);
				tree[i][j]=new Tree(i,j);
				tabTree[i][j]=tree[i][j];
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
				tree[i][j].affichage(g2,frame);
			}
	}

	public void step(){
		//Remove des arbres

		for (int i=0; i<x;i++){
			for(int j=0; j<y;j++){
				tree[i][j].step();	
			}
		}
		//Progation du feu
		for (int i=0; i<x ; i++)
			for (int j=0; j<y ; j++)
				if(affichage[i][j].getType()==Terrain.SAND )
				{
					if(BGRASS>Math.random()) 	
						((Sand)affichage[i][j]).step();
					if(tree[i][j].isAlive()==true && tree[i][j].isBurn()==false){//Prend feu a proximiter
						if (BFEU>Math.random()) {
							tabTree[i][j].burn();
						}else if(tree[i+1][j].isBurn()==true){
							tabTree[i][j].burn();
						}else if(tree[i-1][j].isBurn()==true ){
							tabTree[i][j].burn();
						}else if(tree[i][j+1].isBurn()==true){
							tabTree[i][j].burn();
						}else if(tree[i][j-1].isBurn()==true ){
							tabTree[i][j].burn();
						}else{
							tabTree[i][j]=tree[i][j];
						}
					}else if(tree[i][j].isAlive()==false){
						if(BTREE>Math.random()){
							tabTree[i][j].alive(); //L'arbre est initialiser
						}
					}else {
						tabTree[i][j]=tree[i][j];
					}
				}


		//MAJ de l'automate
		for (int i=0; i<x ; i++)
			for (int j=0; j<y ; j++){
				tree[i][j]= Tree.clonage(tabTree[i][j]);
				
			}



	}


	//Accesseur
	public Terrain getAffichage(int x,int y){
		return affichage[x][y];
	}
	public Tree getTree(int x,int y){
		return tree[x][y];
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}