

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

public class World extends JPanel{

	private JFrame frame;

	private Image waterSprite;
	private Image grassSprite;
	private Image treeSprite;
	private Humain homme;
	private int world[][];
	private int tableaucourant[][];
	private ArrayList<Agent> agent;

	private int sizex;
	private int sizey;

	public World(int sizex,int sizey){ // initialisation du monde 
		this.sizex=sizex;
		this.sizey=sizey;

		world=new int[this.sizex][this.sizey];
				//homme=new Humain((int)(Math.random()*sizex),(int)(Math.random()*sizey),sizex,sizey, "alligator.png");
		agent=new ArrayList<Agent>();
		try
		{
			waterSprite = ImageIO.read(new File("water.png"));	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(-1);
		}

		frame = new JFrame("World of Sprite");
		frame.add(this);
		frame.setSize(300,300);
		frame.setVisible(true);
	}

	public void addAgent(Agent a){
		agent.add(a);
	}


	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;

		for ( int i = 0 ; i < sizex ; i++ ) //affichage de l'arriere plan
			for ( int j = 0 ; j < sizey ; j++ )
			{				
				g2.drawImage(waterSprite,32*i,32*j,32,32, frame);					
			}

		for ( Agent a : agent ){ //affichage des agents
			g2.drawImage(a.getImage(), 32*a.getX(),32*a.getY(),32,32,frame);
			a.step();
			if (a.getLife()<= 0){
				agent.remove(a);
			}
		} 
		

	}
	public int getSizex(){
		return sizex;
	}

	public int getSizey(){
		return sizey;
	}

	public Humain getHumain(){
		return homme;
	}
	
}