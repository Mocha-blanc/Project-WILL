

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

	private int world[][];
	private int tableaucourant[][];
	private ArrayList<Agent> agent;
	private Map m;

	private int sizex;
	private int sizey;

	public World(int sizex,int sizey){ // initialisation du monde 
		this.sizex=sizex;
		this.sizey=sizey;

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


		for ( Agent a : agent ){ //affichage des agents 
			g2.drawImage(a.getImage(), spriteLength*a.getX(),spriteLength*a.getY(),spriteLength,spriteLength,frame);
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
	}

	public void step(){
		m.step();
		for (int i=0; i<agent.size();i++){
			agent.get(i).step();
			agent.get(i).move();
			if(agent.get(i).alive==false){
				agent.remove(agent.get(i));
			}
		}
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
	
	public static void main(String[] args) {
		World w = new World(25,25);
		double probabilite = 0.0;



		int delai=500;
		w.addAgent(new Alligator(1000000,w.getMap(),"alligator.png"));
		w.addAgent(new Humain(100000, w.getMap(),"human.png"));
		while (true){
			System.out.println("Pascal");
			try {
				Thread.sleep(delai);
			}catch (InterruptedException e) {}
			
			
			w.step();
			w.repaint();
		}
	}
}