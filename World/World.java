

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings({"serial"})
public class World extends JPanel implements MouseWheelListener, KeyListener{

	private JFrame frame;
	
	//Valeur modifiable :
	
	public static int spriteLength=20;	//Taille des case
	
	//Nombre d'agent
	public static final int SALAMECHE=20;
	public static final int CARAPUCE=20;
	public static final int BULBIZARRE=20;
	public static final double BCLOUD=0.01; //Probabilité d'apparition des nuages a chaque iteration
	
	public static int delai=40;	//Delai d'affichage
	public static int X=0;
	public static int Y=0;
	

	//A ne pas modifier
	private Gestion_agent agent;
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


		m=new Map(sizex,sizey);
		agent=new Gestion_agent();
		image=new Sprite();

		frame = new JFrame("World of Sprite");
		frame.add(this);
		frame.setSize(spriteLength*sizex,spriteLength*sizey+22);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



	public void paint(Graphics g)
	{
		super.paintComponent(g);//Paindre du blanc sur les cases en dehors du tableau Terrain(utile pour le zoom out et zoom in pour pas que ca fasse trop degueulasse)
		Graphics2D g2 = (Graphics2D)g;
		
		g.setColor(Color.green);
		g.fillRect(20, 20, 50, 20);
//		m.affichage(g2,frame, iteration);
		//1. Affichage du terrain
		for (int i=0; i<m.getX() ; i++)
			for (int j=0; j<m.getY() ; j++){
				image.affichageTerrain(g2,frame,i,j,m.getTerrain());	
			
			}
		//2. Afficahge des borudures, laves et des objects
		for (int i=0; i<m.getX() ; i++)
			for (int j=0; j<m.getY() ; j++){ 	
				image.affichageLava(g2,frame,i,j,m.getLava());
				image.affichageBordurenord(g2,frame,i,j,m.getTerrain());
				image.affichageBordureest(g2,frame,i,j,m.getTerrain());
				image.affichageBorduresud(g2,frame,i,j,m.getTerrain());
				image.affichageBordurewest(g2,frame,i,j,m.getTerrain());
				image.affichageObject(g2,frame,i,j,m.getObject(i,j));
			}
		for (int i=0;i<agent.getEgg().size();i++) {
			image.affichageEgg(g2, frame, agent.getEgg().get(i));
		}
		for (int i=0;i<agent.getStarter().size();i++ ) {
			image.affichageStarter((iteration%5), g2, frame,agent.getStarter().get(i));
			image.affichageLife(g2,agent.getStarter().get(i), iteration);
		}
		//3. Affichage des arbre
		for (int i=0; i<m.getX() ; i++)									
			for (int j=0; j<m.getY() ; j++)
				image.affichageTree(g2,frame,m.getTree(i,j));
		//4. Affichage de l ombre du nuage 
		for (int i=0; i<agent.getCloud().size();i++  ){ 
			image.affichageShadowcloud((iteration%5), g2, frame,agent.getCloud().get(i));
			
		}
		//5. Affichage des effects entre l'ombre et le nuage 
		for (int i=0; i<m.getX() ; i++)
			for (int j=0; j<m.getY() ; j++)
				image.affichageEffect(g2,frame,i,j,m.getEffect(i,j), iteration%5);
		//6. Afficahge du nuage (Vers la fin car c'est l'image qui cache tous les autres)
		for (int i=0; i<agent.getCloud().size();i++ ){
			image.affichageCloud((iteration%5), g2, frame,agent.getCloud().get(i));
			
		}

		
	}
	
	public void step(){
		m.step(agent.getStarter()); //MAJ de la map

		agent.stepcloud(m);
		agent.stepStarter(m);
		agent.stepEgg(m);
		
		agent.reproduction(m);//Pondre des oeufs
		for (int i=0;i<5;i++){ //Affichage de deplacement
			iteration=i;
			repaint();
			try {
				Thread.sleep(delai);
			} catch (InterruptedException e) {}
		}
		agent.moveAllcloud();
		agent.moveAllstarter();
	}

	
	//Fonction fournie par import java.awt.event.* avec les implements MouseWheelListener,KeyListener
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) { // Utilise pour ZOOM in et ZOOM out

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
	public void keyPressed(KeyEvent e) { // Utiliser pour le deplacement de l'ecran
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




	//Accesseur 
	public Map getMap(){
		return m;
	}
	public Gestion_agent getGestion_agent() {
		return agent;
	}
	public int getSizex(){
		return sizex;
	}

	public int getSizey(){
		return sizey;
	}
	
	public static void main(String[] args) {
		World w = new World(100,100);
		w.addKeyListener(w);
		w.addMouseWheelListener(w);
	    w.setFocusable(true);
	    for(int cpt=0; cpt<SALAMECHE; cpt++) {
	    	w.getGestion_agent().addStater(new Salameche(w.getMap()));	    	
	    	w.getGestion_agent().addStater(new Carapuce(w.getMap()));
	    	w.getGestion_agent().addStater(new Bulbizar(w.getMap()));
	    }
		int i=0;
		while (true){
			System.out.println("Iteration = "+i);
			w.step();
			i++;
		}
	}



}