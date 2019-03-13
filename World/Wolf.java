

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Wolf extends Agent{
	public Wolf(int life, Map m){
		super(life,m,"wolf");
		do{
			x=(int)(Math.random()*m.getX());
			y=(int)(Math.random()*m.getY());
		}while(m.getTerrain(x,y)==Map.WATER);
		life=life;
	}
	public void step(){
		
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


        if (m.getTerrain(x1,y1)==Map.SAND && m.getTree(x1,y1).getLife()==0){
        	move=true;
        }else{
        	move=false;
        }

		if (life<= 0){
			alive=false;
		}
        life=life-1;
	}
	public void eat(){
		if(m.getObject(x,y)==Map.GRASS){
			m.setObject(x,y,Map.VIDE);
		}					
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
         eat();
    }
    public int getDirection(){
		return direction;
	}
}