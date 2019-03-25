

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

public class Wolf extends Agent{

	public static final int DETECTION=5;

	public Wolf(int life, Map m){
		super(life,m,"wolf");
		do{
			x=(int)(Math.random()*m.getX());
			y=(int)(Math.random()*m.getY());
		}while(m.getTerrain(x,y)==Map.WATER);
		life=life;
	}

	public void step(ArrayList<Agent> a){
		direction=-1;
		rayonDetection("goat", DETECTION, a);
		if(direction == -1){
			direction=(int)(Math.random()*4);
		}
		//System.out.println("direction"+ direction);
		int x1=x;
		int y1=y;
		
		if ( direction == NORD) // nord
        	y1 = (y1 - 1) ;
        if ( direction == EST)	// est
        	x1 = (x1 + 1);
        if ( direction == SUD)	// sud
         	y1 = (y1 + 1);
        if ( direction == WEST)// ouest
         	x1 = (x1 - 1);

        move=false;
        if (m.getTerrain(x1,y1)==Map.SAND && m.getTree(x1,y1).getLife()==0)
        	move=true;
        
		if (life<= 0){
			alive=false;
		}
        life=life-1;
	}
	//Deplacement intelligent n=nom de l'agent ciblé, i=iteration maximum detectable, ne pas mettre trop d'iteration car fonction tres gourmand, provaque des comutations sur mac si delai trop court  
	public void rayonDetection(String n, int i, ArrayList<Agent> a){
		int iteration=1;
		do{
			direction=detection(x,y,n, iteration, a, m);
			iteration++;
		}while(direction==-1 && iteration<=i);
	}
	/*public void eat(){
		if(m.getObject(x,y)==Map.GRASS){
			m.setObject(x,y,Map.VIDE);
		}					
	}*/
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
        //eat();
    }
    public int getDirection(){
		return direction;
	}
}