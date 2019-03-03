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


public class Sand extends Terrain{
	private boolean grass;


	private Image sprite1;
	private Image sprite2;
	public Sand(int x, int y,String image,String image1){
		super(x,y);
		if(Main.PGRASS>Math.random()){
			grass=true;
		}else{
			grass=false;

		}
		type=Terrain.SAND;
		try{
			sprite = ImageIO.read(new File(image));
			sprite1 = ImageIO.read(new File(image1));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
	}


	public void affichage(Graphics2D g2, JFrame frame){
		g2.drawImage(sprite, 32*x, 32*y, 32, 32, frame);
		if (grass==true) {
			g2.drawImage(sprite1, 32*x, 32*y, 32, 32, frame);
		
		}
	}

	
}