

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

@SuppressWarnings({"serial"})
public class World extends JPanel{

	private JFrame frame;

	public static int spriteLength=24;
	private Image waterSprite;
	private Image grassSprite;
	private Image treeSprite;

	private int world[][];
	private int tableaucourant[][];
	private ArrayList<Agent> agent;
	private Map m;

	private int sizex;
	private int sizey;
	private int iteration;

	public World(int sizex,int sizey){ // initialisation du monde 
		this.sizex=sizex;
		this.sizey=sizey;
		iteration=0;
		world=new int[this.sizex][this.sizey];
		tableaucourant=new int [this.sizex][this.sizey];
		
		m=new Map(sizex,sizey);
		agent=new ArrayList<Agent>();
		


		frame = new JFrame("World of Sprite");
		frame.add(this);
		frame.setSize(spriteLength*sizex,spriteLength*sizey);
		frame.setVisible(true);
	}

	public void addAgent(Agent a){
		
		agent.add(a);
	}


	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		m.affichage(g2,frame);
		//m.step();


		for ( Agent a : agent ){ //affichage des agents
			//tableaucourant[a.getX()][a.getY()]=10;//numero 10 pour les agents 
			g2.drawImage(a.getImage(), spriteLength*a.getX(),spriteLength*a.getY(),spriteLength,spriteLength,frame);
		}


		for ( int i = 0 ; i < sizex ; i++ ) //Mise a jour des tableaux
			for ( int j = 0 ; j < sizey ; j++ )				
				world[i][j]=tableaucourant[i][j];
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
	}

	public void step(){
		if(i%5==0)
			for (int i=0; i<agent.size();i++){
				agent.get(i).step();
				agent.get(i).move();
				if(agent.get(i).alive==false){
					agent.remove(agent.get(i));
				}
			}
			m.step();
		i++;
	}

	public void majTab(int x, int y, int valeur){
		tableaucourant[x][y]=valeur;
	}
	//Accesseur 
	public Map getMap(){
		return m;
	}
	public ArrayList<Agent> getAgent(){
		return agent;
	}
	public int getSizex(){
		return sizex;
	}

	public int getSizey(){
		return sizey;
	}
	public int getTableaucourant(int x, int y){
		return tableaucourant[x][y];
	}
	
	
}
