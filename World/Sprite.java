

import java.awt.Graphics2D;
import java.awt.Image;

import java.io.File;

import javax.imageio.ImageIO;

import javax.swing.JFrame;



public class Sprite {
	//Agent
	private Image goatSprite[][];
	private Image wolfSprite[][];
	//Terrain
	private Image sandSprite[];
	private Image deepwaterSprite;
	private Image waterSprite;
	private Image lawnSprite;
	//Object
	private Image grassSprite;
	//Effect
	private Image lightSprite[];
	//Tree
	private Image treeSprite;
	private Image coalSprite;
	private Image fireSprite;

	public Sprite(){
		goatSprite=new Image[4][5];
		wolfSprite=new Image[4][5];
		try{
			//GoatSprite
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

			//WolfSprite
			wolfSprite[Agent.NORD][0] = ImageIO.read(new File("wolf9.png"));
			wolfSprite[Agent.NORD][1] = ImageIO.read(new File("wolf10.png"));
			wolfSprite[Agent.NORD][2] = ImageIO.read(new File("wolf11.png"));
			wolfSprite[Agent.NORD][3] = ImageIO.read(new File("wolf12.png"));
			wolfSprite[Agent.NORD][4] = ImageIO.read(new File("wolf9.png"));

			wolfSprite[Agent.EST][0] = ImageIO.read(new File("wolf13.png"));
			wolfSprite[Agent.EST][1] = ImageIO.read(new File("wolf14.png"));
			wolfSprite[Agent.EST][2] = ImageIO.read(new File("wolf15.png"));
			wolfSprite[Agent.EST][3] = ImageIO.read(new File("wolf16.png"));
			wolfSprite[Agent.EST][4] = ImageIO.read(new File("wolf13.png"));

			wolfSprite[Agent.SUD][0] = ImageIO.read(new File("wolf1.png"));
			wolfSprite[Agent.SUD][1] = ImageIO.read(new File("wolf2.png"));
			wolfSprite[Agent.SUD][2] = ImageIO.read(new File("wolf3.png"));
			wolfSprite[Agent.SUD][3] = ImageIO.read(new File("wolf4.png"));
			wolfSprite[Agent.SUD][4] = ImageIO.read(new File("wolf1.png"));

			wolfSprite[Agent.WEST][0] = ImageIO.read(new File("wolf5.png"));
			wolfSprite[Agent.WEST][1] = ImageIO.read(new File("wolf6.png"));
			wolfSprite[Agent.WEST][2] = ImageIO.read(new File("wolf7.png"));
			wolfSprite[Agent.WEST][3] = ImageIO.read(new File("wolf8.png"));
			wolfSprite[Agent.WEST][4] = ImageIO.read(new File("wolf5.png"));

			//Terrain
			deepwaterSprite = ImageIO.read(new File("deepwater.png"));
			waterSprite = ImageIO.read(new File("water.png"));
			sandSprite = new Image[9];
			sandSprite[0] = ImageIO.read(new File("sand.png")); //milieu
			sandSprite[1] = ImageIO.read(new File("sand2.png")); //Haut - gauche 
			sandSprite[2] = ImageIO.read(new File("sand3.png")); // HAut
			sandSprite[3] = ImageIO.read(new File("sand4.png")); // Haut - droite
			sandSprite[4] = ImageIO.read(new File("sand5.png")); //droite 
			sandSprite[5] = ImageIO.read(new File("sand6.png")); //Bas - droite
			sandSprite[6] = ImageIO.read(new File("sand7.png")); //Bas
			sandSprite[7] = ImageIO.read(new File("sand8.png")); //Bas gauche
			sandSprite[8] = ImageIO.read(new File("sand9.png")); //gauche
			
			lawnSprite = ImageIO.read(new File("lawn.png"));

			//Object
			grassSprite = ImageIO.read(new File("grass.png"));
			fireSprite = ImageIO.read(new File("fire.png"));
			
			//Effect
			lightSprite=new Image[5];
			lightSprite[0] = ImageIO.read(new File("lightning1.png"));
			lightSprite[1] = ImageIO.read(new File("lightning2.png"));
			lightSprite[2] = ImageIO.read(new File("lightning3.png"));
			lightSprite[3] = ImageIO.read(new File("lightning4.png"));
			lightSprite[4] = ImageIO.read(new File("lightning5.png"));

			//Tree
			treeSprite = ImageIO.read(new File("tree.png"));
			coalSprite = ImageIO.read(new File("coaltree.png"));





		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	//Affichage pour les agents dans la class agent
	public void affichageAgent(int i,Graphics2D g2, JFrame frame,Agent a){
		if(a.getName().equals("goat")){
			if(a.moving(a.getDirection())==true){
				if(Agent.NORD==a.getDirection())
					g2.drawImage(goatSprite[a.getDirection()][i], World.spriteLength*a.getX(),World.spriteLength*a.getY()-(i*World.spriteLength)/4,World.spriteLength,World.spriteLength,frame);
				if(Agent.EST==a.getDirection())
					g2.drawImage(goatSprite[a.getDirection()][i], World.spriteLength*a.getX()+(i*World.spriteLength)/4,World.spriteLength*a.getY(),World.spriteLength,World.spriteLength,frame);
				if(Agent.SUD==a.getDirection())
					g2.drawImage(goatSprite[a.getDirection()][i], World.spriteLength*a.getX(),World.spriteLength*a.getY()+(i*World.spriteLength)/4,World.spriteLength,World.spriteLength,frame);
				if(Agent.WEST==a.getDirection())
					g2.drawImage(goatSprite[a.getDirection()][i], World.spriteLength*a.getX()-(i*World.spriteLength)/4,World.spriteLength*a.getY(),World.spriteLength,World.spriteLength,frame);
			}else {
				g2.drawImage(goatSprite[a.getDirection()][0], World.spriteLength*a.getX(),World.spriteLength*a.getY(),World.spriteLength,World.spriteLength,frame);
			}
		}

		if(a.getName().equals("wolf") ){
			if(a.moving(a.getDirection())==true){
				if(Agent.NORD==a.getDirection())
					g2.drawImage(wolfSprite[a.getDirection()][i], World.spriteLength*a.getX()+World.X*World.spriteLength,World.spriteLength*a.getY()+World.Y*World.spriteLength-(i*World.spriteLength)/4,World.spriteLength,World.spriteLength,frame);
				if(Agent.EST==a.getDirection())
					g2.drawImage(wolfSprite[a.getDirection()][i], World.spriteLength*a.getX()+World.X*World.spriteLength+(i*World.spriteLength)/4,World.spriteLength*a.getY()+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
				if(Agent.SUD==a.getDirection())
					g2.drawImage(wolfSprite[a.getDirection()][i], World.spriteLength*a.getX()+World.X*World.spriteLength,World.spriteLength*a.getY()+World.Y*World.spriteLength+(i*World.spriteLength)/4,World.spriteLength,World.spriteLength,frame);
				if(Agent.WEST==a.getDirection())
					g2.drawImage(wolfSprite[a.getDirection()][i], World.spriteLength*a.getX()+World.X*World.spriteLength-(i*World.spriteLength)/4,World.spriteLength*a.getY()+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
			}else {
				g2.drawImage(wolfSprite[a.getDirection()][0], World.spriteLength*a.getX()+World.X*World.spriteLength,World.spriteLength*a.getY()+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
			}
		}
	}
	//Afficahge pour les tableaux dans la class map
	public void affichageTerrain(Graphics2D g2, JFrame frame, int x,int y, int type[][]){
		if (Map.DEEPWATER==type[x][y])
			g2.drawImage(deepwaterSprite, World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
		if (Map.WATER==type[x][y])
			g2.drawImage(waterSprite, World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
		if (Map.SAND==type[x][y])
				g2.drawImage(sandSprite[0], World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
		if(Map.LAWN==type[x][y]) {
			g2.drawImage(lawnSprite, World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
		}
	}
	public void affichageObject(Graphics2D g2, JFrame frame, int x,int y, int type){
		if(Map.GRASS==type)
			g2.drawImage(grassSprite, World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
	}
	public void affichageEffect(Graphics2D g2, JFrame frame, int x,int y, int type, int i) {
		if(Map.LIGHTNING==type)
			g2.drawImage(lightSprite[i], World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
	}

	public void affichageTree(Graphics2D g2, JFrame frame, Tree t){
		if(t.isAlive()==true && t.getLife() >0){
			if(t.getLife()==1){
				g2.drawImage(coalSprite, World.spriteLength*t.getX()+World.X*World.spriteLength, World.spriteLength*t.getY()+World.Y*World.spriteLength, World.spriteLength, World.spriteLength, frame);
			}else{
				g2.drawImage(treeSprite, World.spriteLength*t.getX()+World.X*World.spriteLength, World.spriteLength*t.getY()+World.Y*World.spriteLength, World.spriteLength, World.spriteLength, frame);
			}
			if (t.isBurn()==true) //Arbre en feu
				g2.drawImage(fireSprite, World.spriteLength*t.getX()+World.X*World.spriteLength, World.spriteLength*t.getY()+World.Y*World.spriteLength, World.spriteLength, World.spriteLength, frame);
		}
	}
	public void affichageBordureSANDnord(Graphics2D g2, JFrame frame, int x,int y, int type[][]) {
		if (Map.SAND==type[x][y])
			if (type[x][y-1] < type[x][y])
				g2.drawImage(sandSprite[2], World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength-2,World.spriteLength,World.spriteLength,frame);
	}
	public void affichageBordureSANDest(Graphics2D g2, JFrame frame, int x,int y, int type[][]) {
		if (Map.SAND==type[x][y])
			if(type[x+1][y] < type[x][y] )
				g2.drawImage(sandSprite[4], 2+World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
	}
	public void affichageBordureSANDsud(Graphics2D g2, JFrame frame, int x,int y, int type[][]) {
		if (Map.SAND==type[x][y])
			if (type[x][y+1] < type[x][y])
				g2.drawImage(sandSprite[6], World.spriteLength*x+World.X*World.spriteLength,2+World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
	}
	public void affichageBordureSANDwest(Graphics2D g2, JFrame frame, int x,int y, int type[][]) {
		if (Map.SAND==type[x][y])
			if (type[x-1][y] < type[x][y] ) 
				g2.drawImage(sandSprite[8], World.spriteLength*x+World.X*World.spriteLength-2,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
	}
}