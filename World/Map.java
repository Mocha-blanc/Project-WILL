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
	public final static double BGRASS=0.1;  //Probabilite d'apparition d'Herbre
	public final static double BTREE=0.01; //Probabilite d'apparition d'Arbre

	public final static double BFIRE=0.5; //Probabilite de contamination Feu de foret  

	public final static double BLIGHTNING=0.1; //Probabilite d'apparition de foudre Foudre, pas complet pour l'affichage


	private int x;
	private int y;

	public static final int VIDE=0;
	//Terrain 
    public static final int WATER=1; //Eau
    public static final int SAND=2; //Sable
	//Object
	public static final int GRASS=1; //Herbe
	//Effet
	public static final int LIGHTNING=1;	//Foudre
	
	//Tableau d'affichage 
	private int terrain[][];//Arriere plan qui est rarement modifier

	private Tree tree[][];//Feu de foret 
	private Tree tabTree[][];

	private int object[][];//Affichage d'objet sur le terrain

	private int effect[][];//Affichage qui apparait pendant un court iteration

	private Sprite image;
	public Map(int x, int y){
		this.x=x;
		this.y=y;
		image = new Sprite();


		terrain=new int[x][y];
		object=new int [x][y];
		effect=new int[x][y];
		tree=new Tree[x][y];

		tabTree=new Tree[x][y];
		for (int i=0; i<x ;i++)
			for (int j=0; j<y ; j++){
				terrain[i][j]=WATER;
				tree[i][j]=new Tree(i,j);
				tabTree[i][j]=tree[i][j];
				object[i][j]=VIDE;
				effect[i][j]=VIDE;
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
				image.affichageTree(g2,frame,tree[i][j]);
			}
	}

	public void step(ArrayList<Agent> agent){

		stepObject(agent);
		stepEffect();
		stepTree(agent);
	}

	public void stepObject(ArrayList<Agent> agent){
		for (int i=0; i<x ; i++)
			for (int j=0; j<y ; j++)
				if(terrain[i][j]==SAND)
				{
					if(BGRASS>Math.random()){
						if(World.isAgent(i,j,agent))
							object[i][j]=GRASS;
					}
				}
	}

	public void stepTree(ArrayList<Agent> agent){
		//Step de chaque arbre
		for (int i=0; i<x;i++){
			for(int j=0; j<y;j++){
				tree[i][j].step();
				
			}
		}
		//Progation du feu
		for (int i=0; i<x ; i++){
			for (int j=0; j<y ; j++){
				if(terrain[i][j]==SAND)
				{

					if(tree[i][j].isAlive()==true && tree[i][j].isBurn()==false){//Prend feu a proximiter
						if (BFIRE>Math.random()) {
							tabTree[i][j].burn();
						}else if(tree[i+1][j].isBurn()==true && BFIRE>Math.random()){
							tabTree[i][j].burn();
						}else if(tree[i-1][j].isBurn()==true && BFIRE>Math.random()){
							tabTree[i][j].burn();
						}else if(tree[i][j+1].isBurn()==true && BFIRE>Math.random()){
							tabTree[i][j].burn();
						}else if(tree[i][j-1].isBurn()==true && BFIRE>Math.random()){
							tabTree[i][j].burn();
						}else{
							tabTree[i][j]=tree[i][j];
						}
					}else if(tree[i][j].isAlive()==false && tree[i][j].isBurn()==false){
						if(BTREE>Math.random()){
							if(World.isAgent(i,j,agent)==true)
								tabTree[i][j].alive(); //L'arbre est initialiser
						}
					}else {
						tabTree[i][j]=tree[i][j];
					}
				}
			}
		}


		//MAJ de l'automate
		for (int i=0; i<x ; i++){
			for (int j=0; j<y ; j++){
				tree[i][j]= new Tree(tabTree[i][j]);
				
			}
		}
	}
	public void stepEffect(){
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				effect[i][j]=VIDE;
				if(BLIGHTNING>Math.random())
					effect[i][j]=LIGHTNING;
			}
		}
	}


	//Set
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