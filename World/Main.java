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


public class Main{

	//Probabilite initialisation
	public final static double PGRASS=0.1; //Herbre
	public final static double PTREE=0.2; //Arbre

	//Probabilite de réaparition 
	public final static double BGRASS=0.1;  //Herbre
	public final static double BTREE=0.2; //Arbre



	public static void main(String[] args) {
		World w = new World(25,22);
		double probabilite = 0.0;



		int delai=500;
		w.addAgent(new Alligator(1000000,w.getMap(),"alligator.png"));
		while (true){
			System.out.println("Pascal");
			//if (probabilite>Math.random())
				//w.addAgent(new Humain(w,"alligator.png"));
				//w.addAgent(new Humain(100,w,"alligator.png"));
			try {
				Thread.sleep(delai);
			}catch (InterruptedException e) {}
			
			
			w.step();
			w.repaint();
		}
	}
}