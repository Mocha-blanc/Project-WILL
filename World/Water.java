

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


public class Water extends Terrain{
	public Water(int x, int y,String image){
		super(x,y);
		type=Terrain.WATER;
		try{
			sprite = ImageIO.read(new File(image));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public void affichage(Graphics2D g2, JFrame frame){
		g2.drawImage(sprite, 32*x, 32*y, 32, 32, frame);
	}

	
}