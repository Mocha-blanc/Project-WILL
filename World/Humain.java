

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
	private Image sprite;
	private int life;
	private int direction;
	public Humain(int x,int y, int wx,int wy,String image){
		super(x,y,wx,wy);
		life=10;
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
		
        if ( direction == 0) // nord	
        	y = (y - 1+wy)%wy ;
        if ( direction == 1)	// est
        	x = (x + 1+wx)%wx ;
        if ( direction == 2)	// sud
         	y = (y + 1+wy)%wy ;
        if ( direction == 3)// ouest
         	x = (x - 1+wx)%wx ;
        life=life-1;
	}

	public int getLife(){
		return life;
	}
	public Image getImage(){
		return sprite;
	}



}