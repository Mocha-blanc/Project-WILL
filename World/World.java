

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;


@SuppressWarnings({"serial"})
public class World extends JPanel implements MouseWheelListener, KeyListener{

	private JFrame frame;
	
	//Valeur mofiable :
	
	public static int spriteLength=20;	//Taille des case
	
	//Nombre d'agent
	public static final int NBPROIE=0; 
	public static final int NBPREDATEUR=10;
	
	public static int delai=50;	//Delai d'affichage
	public static int X=0;
	public static int Y=0;
	public static boolean RUN=true;
	
	

	
	//A ne pas modifier
	private ArrayList<Agent> agent;
	private Map m;
	private Sprite image;

	private int sizex;
	private int sizey;
	private int iteration;
	public boolean run;

	public World(int sizex,int sizey){ // initialisation du monde 
		this.sizex=sizex;
		this.sizey=sizey;
		iteration=0;
		run=true;

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
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		m.affichage(g2,frame, iteration);
		

		for ( Agent a : agent ){ //affichage des agents 
			image.affichageAgent((iteration%5), g2, frame,a);
		}
	}
	
	//Fonction fournie par import java.awt.event.* ,MouseWheelListener,KeyListener
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {

        //Zoom in
        if(e.getWheelRotation()<0 ){//scroll vers le bas 
        	spriteLength+=1; 
           
        }
        //Zoom out
        if(e.getWheelRotation()>0 && (frame.getWidth()<spriteLength*(sizex-1) || frame.getHeight()<spriteLength*sizey-1)){ //scroll vers le haut
        	if((X*-1)*spriteLength+frame.getWidth()<spriteLength*sizex && (Y*-1)*spriteLength+frame.getHeight()<spriteLength*sizey) {
        		spriteLength-=1;
        	}else {
              	if(X<0) 
              		X++;
              	if(Y<0)
              		Y++;
        	}
     
        }
    }

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			delai+=5;
			System.out.println("Delai + 5");
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && delai>5) {
			delai-=5;
			System.out.println("Delai - 5");
		}
		if (e.getKeyCode() == KeyEvent.VK_Q && X<0)
			X++;
		if (e.getKeyCode() == KeyEvent.VK_D && (X*-1)*spriteLength+frame.getWidth()<spriteLength*(sizex-1)) 
			X--;
		if (e.getKeyCode() == KeyEvent.VK_Z && Y<0)
			Y++;
		if (e.getKeyCode() == KeyEvent.VK_S && (Y*-1)*spriteLength+frame.getHeight()<spriteLength*(sizey-1)+22)
			Y--;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void step(){
		m.step(agent); //MAJ de la map

		for (int i=0; i<agent.size();i++){ //MAJ des agents
			agent.get(i).step(agent);
		}
		removeAgent();

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
	
	public void setRun(boolean b) {
		run=b;
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
	
	public boolean getRun() {
		return run;
	}
	
	public static void main(String[] args) {
		World w = new World(100,100);
		w.addKeyListener(w);
		w.addMouseWheelListener(w);
	    w.setFocusable(true);
		for (int i=0; i<NBPROIE; i++)
			w.addAgent(new Goat(100000, w.getMap()));

		for (int i=0; i<NBPREDATEUR; i++)
			w.addAgent(new Wolf(10000000, w.getMap()));
		int i=0;
		while (true){
			//System.out.println("iteration = "+i+" Delai = "+delai);
			if(RUN==true) {
				System.out.println(RUN);
				w.step();
				i++;
			}
		}
	}



}