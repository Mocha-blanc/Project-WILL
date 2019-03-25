

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
	public static final int spriteLength=25;	//Taille des case
	public static final int delai=10;	//Delai d'affichage


	private ArrayList<Agent> agent;
	private Map m;
	private Sprite image;

	private int sizex;
	private int sizey;
	private int iteration;

	public World(int sizex,int sizey){ // initialisation du monde 
		this.sizex=sizex;
		this.sizey=sizey;
		iteration=0;

		m=new Map(sizex,sizey);
		agent=new ArrayList<Agent>();
		image=new Sprite();



		frame = new JFrame("World of Sprite");
		frame.add(this);
		frame.setSize(spriteLength*sizex,spriteLength*sizey+22);
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
			image.affichageAgent((iteration%5), g2, frame,a);
		}
	}

	public void step(){
		m.step(agent); //MAJ de la map

		for (int i=0; i<agent.size();i++){ //MAJ des agents
			agent.get(i).step(agent);
			System.out.println("direction"+agent.get(i).getDirection());
			if(agent.get(i).alive==false){
				agent.remove(agent.get(i));
			}
		}

		for (int i=0;i<5;i++){ //Affichage de deplacement
			iteration=i;
			repaint();
			try {
				Thread.sleep(delai);
			} catch (InterruptedException e) {}
		}
		for (int i=0; i<agent.size();i++){ //MAJ des deplacements des agents 
			agent.get(i).move();
			wolfEat(agent.get(i));
		}
		
	}

	public void wolfEat(Agent a){
		if(a.getName().equals("wolf")){
			for (int y=0; y<agent.size();y++){
				if(agent.get(y).getName().equals("goat") && agent.get(y).getX()==a.getX() && agent.get(y).getY()==a.getY()){
					agent.get(y).setAlive(false);
				}
			}
		}
	}
	
	public void removeAgent(){ //Eneleve les agents de la liste si alive = false
		for (int i=0; i<agent.size();i++){
			if(agent.get(i).alive==false){
				agent.remove(agent.get(i));
			}
		}
	}

	public static boolean isAgent(int x,int y, ArrayList<Agent> agent){ //Fonction qui return vrai s'il n'a pas de agent sur cette position
		for (Agent a : agent ){
			if(a.getX()==x && a.getY()==y)
				return false;
		}
		return true;
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
		World w = new World(50,25);
		double probabilite = 0.0;

		//w.addAgent(new Alligator(1000000,w.getMap(),"alligator.png"));
		w.addAgent(new Goat(100000, w.getMap()));
		w.addAgent(new Goat(100000, w.getMap()));
		w.addAgent(new Goat(100000, w.getMap()));
		w.addAgent(new Goat(100000, w.getMap()));
		w.addAgent(new Goat(100000, w.getMap()));
		w.addAgent(new Goat(100000, w.getMap()));

		w.addAgent(new Goat(100000, w.getMap()));
		w.addAgent(new Goat(100000, w.getMap()));
		w.addAgent(new Goat(100000, w.getMap()));
		w.addAgent(new Goat(100000, w.getMap()));
		w.addAgent(new Goat(100000, w.getMap()));

	
	

		w.addAgent(new Wolf(100000, w.getMap()));
		w.addAgent(new Wolf(100000, w.getMap()));
		w.addAgent(new Wolf(100000, w.getMap()));
		w.addAgent(new Wolf(100000, w.getMap()));
		w.addAgent(new Wolf(100000, w.getMap()));
		w.addAgent(new Wolf(100000, w.getMap()));
		w.addAgent(new Wolf(100000, w.getMap()));
		w.addAgent(new Wolf(100000, w.getMap()));
		w.addAgent(new Wolf(100000, w.getMap()));
		w.addAgent(new Wolf(100000, w.getMap()));
		w.addAgent(new Wolf(100000, w.getMap()));


	
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