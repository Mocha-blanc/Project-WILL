

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

public class Sprite {
	private Image goatSprite[][];

	public Sprite(){
		goatSprite=new Image[4][5];
		try{
			goatSprite[Agent.NORD][0] = ImageIO.read(new File("goat9.png"));
			goatSprite[Agent.NORD][1] = ImageIO.read(new File("goat10.png"));
			goatSprite[Agent.NORD][2] = ImageIO.read(new File("goat11.png"));
			goatSprite[Agent.NORD][3] = ImageIO.read(new File("goat12.png"));
			goatSprite[Agent.NORD][4] = ImageIO.read(new File("goat9.png"));

			goatSprite[Agent.EST][0] = ImageIO.read(new File("goat5.png"));
			goatSprite[Agent.EST][1] = ImageIO.read(new File("goat6.png"));
			goatSprite[Agent.EST][2] = ImageIO.read(new File("goat7.png"));
			goatSprite[Agent.EST][3] = ImageIO.read(new File("goat8.png"));
			goatSprite[Agent.EST][4] = ImageIO.read(new File("goat5.png"));


			goatSprite[Agent.SUD][0] = ImageIO.read(new File("goat1.png"));
			goatSprite[Agent.SUD][1] = ImageIO.read(new File("goat2.png"));
			goatSprite[Agent.SUD][2] = ImageIO.read(new File("goat3.png"));
			goatSprite[Agent.SUD][3] = ImageIO.read(new File("goat4.png"));
			goatSprite[Agent.SUD][4] = ImageIO.read(new File("goat1.png"));

			goatSprite[Agent.WEST][0] = ImageIO.read(new File("goat13.png"));
			goatSprite[Agent.WEST][1] = ImageIO.read(new File("goat14.png"));
			goatSprite[Agent.WEST][2] = ImageIO.read(new File("goat15.png"));
			goatSprite[Agent.WEST][3] = ImageIO.read(new File("goat16.png"));
			goatSprite[Agent.WEST][4] = ImageIO.read(new File("goat13.png"));


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	public void affichage(String s,int i,int direction,Graphics2D g2, JFrame frame,Agent a){
		if(s.equals("goat")){
			if(a.isMove()==true){
				if(Agent.NORD==direction)
					g2.drawImage(goatSprite[direction][i], World.spriteLength*a.getX(),World.spriteLength*a.getY()-(i*World.spriteLength)/4,World.spriteLength,World.spriteLength,frame);
				if(Agent.EST==direction)
					g2.drawImage(goatSprite[direction][i], World.spriteLength*a.getX()+(i*World.spriteLength)/4,World.spriteLength*a.getY(),World.spriteLength,World.spriteLength,frame);
				if(Agent.SUD==direction)
					g2.drawImage(goatSprite[direction][i], World.spriteLength*a.getX(),World.spriteLength*a.getY()+(i*World.spriteLength)/4,World.spriteLength,World.spriteLength,frame);
				if(Agent.WEST==direction)
					g2.drawImage(goatSprite[direction][i], World.spriteLength*a.getX()-(i*World.spriteLength)/4,World.spriteLength*a.getY(),World.spriteLength,World.spriteLength,frame);
			}else {
				g2.drawImage(goatSprite[direction][0], World.spriteLength*a.getX(),World.spriteLength*a.getY(),World.spriteLength,World.spriteLength,frame);
			}
		}
		
	}

}