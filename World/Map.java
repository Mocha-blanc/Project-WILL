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

	//Probabilite de réaparition qui sont dans les step
	public final static double BGRASS=0.1;  //Herbre
	public final static double BTREE=0.01; //Arbre

	public final static double BFEU=0.01; //Feu
	public final static double PFEU=0.01;



	private int x;
	private int y;

	public static final int VIDE=0;
	//Terrain 
    public static final int WATER=1; //Eau
    public static final int SAND=2; //Sable
	//Object
	public static final int GRASS=1; //Herbe
	
	//Tableau d'affichage 
	private int terrain[][];
	private Tree tree[][];
	private int object[][];

	private Tree tabTree[][];
	private Sprite image;
	public Map(int x, int y){
		this.x=x;
		this.y=y;
		image = new Sprite();

		//affichage = new Terrain[x][y];

		terrain=new int[x][y];
		object=new int [x][y];
		tree=new Tree[x][y];

		tabTree=new Tree[x][y];
		for (int i=0; i<x ;i++)
			for (int j=0; j<y ; j++){
				//affichage[i][j]= new Water(i,j);
				terrain[i][j]=WATER;
				tree[i][j]=new Tree(i,j);
				tabTree[i][j]=tree[i][j];
				object[i][j]=VIDE;
			}
		for (int i=3; i<x-3; i++)
			for (int j=3; j<y-3; j++){
				terrain[i][j]=SAND;
			}
	}

	public void affichage(Graphics2D g2, JFrame frame){
		for (int i=0; i<x ; i++)
			for (int j=0; j<y ; j++){
				image.affichageTerrain(g2,frame,i,j,terrain[i][j]);
				image.affichageObject(g2,frame,i,j,object[i][j]);
				tree[i][j].affichage(g2,frame);
			}
	}

	public void step(){
		stepObject();
		stepTree();
	}
	public void stepObject(){
		for (int i=0; i<x ; i++)
			for (int j=0; j<y ; j++)
				if(terrain[i][j]==SAND)
				{
					if(BGRASS>Math.random()) 	
						object[i][j]=GRASS;
				}
	}
	public void stepTree(){
		//Step de chaque arbre
		for (int i=0; i<x;i++){
			for(int j=0; j<y;j++){
				tree[i][j].step();	
			}
		}
		//Progation du feu
		for (int i=0; i<x ; i++)
			for (int j=0; j<y ; j++)
				if(terrain[i][j]==SAND)
				{

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

	public void setObject(int x,int y, int v){
		object[x][y]=v;
	}
	//Get
	public int getTerrain(int x,int y){
		return terrain[x][y];
	}
	public int getObject(int x, int y){
		return object[x][y];
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