

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Humain extends Agent{
	public Humain(int life, Map m){
		super(life,m);
		do{
			x=(int)(Math.random()*m.getX());
			y=(int)(Math.random()*m.getY());
		}while(m.getAffichage(x,y).getType()==Terrain.WATER);
		life=life;
		
	}
	/*public void affichage(Graphics2D g2, JFrame frame, int i){
		if(direction==NORD){
			if(i%5==0 || move==false){
				g2.drawImage(a.getImage(), spriteLength*a.getX(),spriteLength*a.getY(),spriteLength,spriteLength,frame);
			}else if(i%5==1){
				g2.drawImage(a.getImage(), spriteLength*a.getX(),spriteLength*a.getY(),spriteLength,spriteLength,frame);
			}else if(i%5==2){
			}else if(i%5==3){
			}
		}else if(direction==EST ){
			if(i%5==0 || move==false){
			}else if(i%5==1){
			}else if(i%5==2){
			}else if(i%5==3){
			}
		}else if(direction==SUD){
			if(i%5==0 || move==false){
			}else if(i%5==1){
			}else if(i%5==2){
			}else if(i%5==3){
			}
		}else{
			if(i%5==0 || move==false){
			}else if(i%5==1){
			}else if(i%5==2){
			}else if(i%5==3){
			}
		}*/
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


        if (m.getAffichage(x1,y1).getType()==Terrain.SAND && m.getTree(x1,y1).getLife()==0){
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

	public int getLife(){
		return life;
	}

	public int getDirection(){
		return direction;
	}




}