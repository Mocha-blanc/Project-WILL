
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

public class Alligator extends Agent{


	public Alligator(int life, Map m){
		super(life,m,"alligator");
		do{
			x=(int)(Math.random()*m.getX());
			y=(int)(Math.random()*m.getY());
		}while(m.getTerrain(x,y)!=Map.WATER);
		life=life;
	}

	public void step(ArrayList<Agent> a){
		
		direction=(int)(Math.random()*4);
		int x1=x;
		int y1=y;
		
		if ( direction == NORD) // nord
        	y1 = (y1 - 1) ;
        if ( direction == EST)	// est
        	x1 = (x1 + 1);
        if ( direction == SUD)	// sud
         	y1 = (y1 + 1) ;
        if ( direction == WEST)// ouest
         	x1 = (x1 - 1) ;


        if (m.getTerrain(x1,y1)==Map.WATER){
        	move=true;
        }else{
        	move=false;
        }

		if (life<= 0){
			alive=false;
		}
        life=life-1;
	}


	public void move(){
		if (move==true){
			if ( direction == NORD) // nord
    	    	y = (y - 1) ;
        	if ( direction == EST)	// est
	        	x = (x + 1);
    	    if ( direction == SUD)	// sud
        	 	y = (y + 1) ;
        	if ( direction == WEST)// ouest
         		x = (x - 1) ;
         }
    }

	public void rayonDetection(String n, int i, ArrayList<Agent> a){
		int iteration=1;
		do{
			direction=detection(x,y,n, i, a);
		}while(direction==-1 || iteration<=i);
	}

	//Accesseur 

	public int getDirection(){
		return direction;
	}
}