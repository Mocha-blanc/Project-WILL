

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
	public Water(int x, int y){
		super(x,y);
		type=Map.WATER;
		try{
			sprite = ImageIO.read(new File("water.png"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public void affichage(Graphics2D g2, JFrame frame){
		g2.drawImage(sprite, World.spriteLength*x, World.spriteLength*y, World.spriteLength, World.spriteLength, frame);
	}

	
}