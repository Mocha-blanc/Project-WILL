

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

	//Valeur mofiable
	public static final int spriteLength=24;	//Taille des case
	public static final int delai=100;	//Delai d'affichage

	private ArrayList<Agent> agent;
	private Map m;
	private Sprite image;

	private int sizex;
	private int sizey;
	private int iteration;

	public World(int sizex,int sizey){ // initialisation du monde 
		this.sizex=sizex;
		this.sizey=sizey;
		iteration=4;

		m=new Map(sizex,sizey);
		agent=new ArrayList<Agent>();
		image=new Sprite();



		frame = new JFrame("World of Sprite");
		frame.add(this);
		frame.setSize(spriteLength*sizex,spriteLength*sizey);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addAgent(Agent a){	
		agent.add(a);
	}


	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		m.affichage(g2,frame);


		for ( Agent a : agent ){ //affichage des agents 
			image.affichage("goat",(iteration%5), a.getDirection(),g2, frame,a);
		}
		iteration++;
	}

	public void step(){
		m.step();

		for (int i=0; i<agent.size();i++){
			agent.get(i).step();
			removeAgent();
		}

		for (int i=0;i<5;i++){
			repaint();
			try {
				Thread.sleep(delai);
			} catch (InterruptedException e) {}
		}
		for (int i=0; i<agent.size();i++){
			agent.get(i).move();
		}
		
	}

	public void removeAgent(){
		for (int i=0; i<agent.size();i++){
			if(agent.get(i).alive==false){
				agent.remove(agent.get(i));
			}
		}
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
	
	public static void main(String[] args) {
		World w = new World(25,25);
		double probabilite = 0.0;

		//w.addAgent(new Alligator(1000000,w.getMap(),"alligator.png"));
		w.addAgent(new Humain(100000, w.getMap()));
		w.addAgent(new Humain(100000, w.getMap()));
		w.addAgent(new Humain(100000, w.getMap()));
		w.addAgent(new Humain(100000, w.getMap()));
		w.addAgent(new Humain(100000, w.getMap()));
		w.addAgent(new Humain(100000, w.getMap()));
		w.addAgent(new Humain(100000, w.getMap()));
		w.addAgent(new Humain(100000, w.getMap()));
		w.addAgent(new Humain(100000, w.getMap()));
		w.addAgent(new Humain(100000, w.getMap()));
		w.addAgent(new Humain(100000, w.getMap()));
		w.addAgent(new Humain(100000, w.getMap()));
		int i=0;
		String s="lol";
		while (true){
			System.out.println(i);
			w.step();
			i++;
			System.out.println(s.equals("lol"));
		}
	}
}