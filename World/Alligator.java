
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Alligator extends Agent{
	private Image sprite;


	public Alligator(int life, Map m, String image){
		super(life,m);
		do{
			x=(int)(Math.random()*m.getX());
			y=(int)(Math.random()*m.getY());
		}while(m.getAffichage(x,y).getType()!=Terrain.WATER);
		life=life;
		try{
			sprite = ImageIO.read(new File(image));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
	}


	public void step(){
		
		direction=(int)(Math.random()*4);
		if (life<= 0){
			alive=false;
		}
        life=life-1;
	}



	public void move(){
		int x1=x;
		int y1=y;
		
		if ( direction == 0) // nord
        	y1 = ((y1 - 1) + m.getY())%m.getY();
        if ( direction == 1)	// est
        	x1 = ((x1 + 1) + m.getX())%m.getX();
        if ( direction == 2)	// sud
         	y1 = ((y1 + 1) + m.getY())%m.getY();
        if ( direction == 3)// ouest
         	x1 = ((x1 - 1) + m.getX())%m.getX() ;
		
        if (m.getAffichage(x1,y1).getType()==Terrain.WATER){
        	x=x1;
        	y=y1;
        	//w.majTab(x,y,10);
        }
        
	}


	//Accesseur 

	public Image getImage(){
		return sprite;
	}
}