

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import java.io.File;

import javax.imageio.ImageIO;

import javax.swing.JFrame;



public class Sprite {
	//Agent
	private Image salamecheSprite[][];
	private Image reptincelSprite[][];
	private Image dracaufeuSprite[][];
	
	private Image carapuceSprite[][];
	
	private Image eggSprite;
	
	private Image cloudSprite;
	private Image shadowcloudSprite;
	//Terrain
	private Image sandSprite[];
	private Image deepwaterSprite;
	private Image waterSprite;
	private Image lawnSprite[];
	private Image volcanoSprite[];
	private Image lavaSprite;
	//Object
	private Image grassSprite;
	//Effect
	private Image lightSprite[];
	private Image rainSprite[];
	//Tree
	private Image treeSprite;
	private Image coalSprite;
	private Image fireSprite;

	public Sprite(){
		salamecheSprite=new Image[4][3];
		reptincelSprite=new Image[4][3];
		dracaufeuSprite=new Image[4][3];
		
		carapuceSprite=new Image[4][3];
		try{
			//Oeuf
			eggSprite = ImageIO.read(new File("oeuf.png"));
			//CloudSprite
			cloudSprite = ImageIO.read(new File("cloud.png"));
			shadowcloudSprite = ImageIO.read(new File("cloud1.png"));
			//Salameche
			salamecheSprite[Agent.NORD][0]= ImageIO.read(new File("salamechenorth3.png"));
			salamecheSprite[Agent.NORD][1]= ImageIO.read(new File("salamechenorth2.png"));
			salamecheSprite[Agent.NORD][2]= ImageIO.read(new File("salamechenorth1.png"));
			
			salamecheSprite[Agent.EST][0]= ImageIO.read(new File("salamecheeast3.png"));
			salamecheSprite[Agent.EST][1]= ImageIO.read(new File("salamecheeast2.png"));
			salamecheSprite[Agent.EST][2]= ImageIO.read(new File("salamecheeast1.png"));
			
			salamecheSprite[Agent.SUD][0]= ImageIO.read(new File("salamechesouth3.png"));
			salamecheSprite[Agent.SUD][1]= ImageIO.read(new File("salamechesouth2.png"));
			salamecheSprite[Agent.SUD][2]= ImageIO.read(new File("salamechesouth1.png"));
			
			salamecheSprite[Agent.WEST][0]= ImageIO.read(new File("salamechewest3.png"));
			salamecheSprite[Agent.WEST][1]= ImageIO.read(new File("salamechewest2.png"));
			salamecheSprite[Agent.WEST][2]= ImageIO.read(new File("salamechewest1.png"));
			//Reptincel
			reptincelSprite[Agent.NORD][0]= ImageIO.read(new File("reptincelnorth3.png"));
			reptincelSprite[Agent.NORD][1]= ImageIO.read(new File("reptincelnorth2.png"));
			reptincelSprite[Agent.NORD][2]= ImageIO.read(new File("reptincelnorth1.png"));
			
			reptincelSprite[Agent.EST][0]= ImageIO.read(new File("reptinceleast3.png"));
			reptincelSprite[Agent.EST][1]= ImageIO.read(new File("reptinceleast2.png"));
			reptincelSprite[Agent.EST][2]= ImageIO.read(new File("reptinceleast1.png"));
			
			reptincelSprite[Agent.SUD][0]= ImageIO.read(new File("reptincelsouth3.png"));
			reptincelSprite[Agent.SUD][1]= ImageIO.read(new File("reptincelsouth2.png"));
			reptincelSprite[Agent.SUD][2]= ImageIO.read(new File("reptincelsouth1.png"));
			
			reptincelSprite[Agent.WEST][0]= ImageIO.read(new File("reptincelwest3.png"));
			reptincelSprite[Agent.WEST][1]= ImageIO.read(new File("reptincelwest2.png"));
			reptincelSprite[Agent.WEST][2]= ImageIO.read(new File("reptincelwest1.png"));
			//dracaufeu
			dracaufeuSprite[Agent.NORD][0]= ImageIO.read(new File("dracaufeunorth3.png"));
			dracaufeuSprite[Agent.NORD][1]= ImageIO.read(new File("dracaufeunorth2.png"));
			dracaufeuSprite[Agent.NORD][2]= ImageIO.read(new File("dracaufeunorth1.png"));
			
			dracaufeuSprite[Agent.EST][0]= ImageIO.read(new File("dracaufeueast3.png"));
			dracaufeuSprite[Agent.EST][1]= ImageIO.read(new File("dracaufeueast2.png"));
			dracaufeuSprite[Agent.EST][2]= ImageIO.read(new File("dracaufeueast1.png"));
			
			dracaufeuSprite[Agent.SUD][0]= ImageIO.read(new File("dracaufeusouth3.png"));
			dracaufeuSprite[Agent.SUD][1]= ImageIO.read(new File("dracaufeusouth2.png"));
			dracaufeuSprite[Agent.SUD][2]= ImageIO.read(new File("dracaufeusouth1.png"));
			
			dracaufeuSprite[Agent.WEST][0]= ImageIO.read(new File("dracaufeuwest3.png"));
			dracaufeuSprite[Agent.WEST][1]= ImageIO.read(new File("dracaufeuwest2.png"));
			dracaufeuSprite[Agent.WEST][2]= ImageIO.read(new File("dracaufeuwest1.png"));
			
			//Carapuce
			carapuceSprite[Agent.NORD][0]= ImageIO.read(new File("carapucenorth3.png"));
			carapuceSprite[Agent.NORD][1]= ImageIO.read(new File("carapucenorth2.png"));
			carapuceSprite[Agent.NORD][2]= ImageIO.read(new File("carapucenorth1.png"));
			
			carapuceSprite[Agent.EST][0]= ImageIO.read(new File("carapuceeast3.png"));
			carapuceSprite[Agent.EST][1]= ImageIO.read(new File("carapuceeast2.png"));
			carapuceSprite[Agent.EST][2]= ImageIO.read(new File("carapuceeast1.png"));
			
			carapuceSprite[Agent.SUD][0]= ImageIO.read(new File("carapucesouth3.png"));
			carapuceSprite[Agent.SUD][1]= ImageIO.read(new File("carapucesouth2.png"));
			carapuceSprite[Agent.SUD][2]= ImageIO.read(new File("carapucesouth1.png"));
			
			carapuceSprite[Agent.WEST][0]= ImageIO.read(new File("carapucewest3.png"));
			carapuceSprite[Agent.WEST][1]= ImageIO.read(new File("carapucewest2.png"));
			carapuceSprite[Agent.WEST][2]= ImageIO.read(new File("carapucewest1.png"));
			//Terrain
			deepwaterSprite = ImageIO.read(new File("deepwater.png"));
			waterSprite = ImageIO.read(new File("water.png"));
			
			sandSprite = new Image[9];
			sandSprite[0] = ImageIO.read(new File("sand.png")); //milieu
			sandSprite[1] = ImageIO.read(new File("sandN.png")); // HAut		
			sandSprite[2] = ImageIO.read(new File("sandE.png")); //droite 	
			sandSprite[3] = ImageIO.read(new File("sandS.png")); //Bas
			sandSprite[4] = ImageIO.read(new File("sandWE.png")); //gauche
			
			lawnSprite = new Image[5];
			lawnSprite[0] = ImageIO.read(new File("lawnM.png"));
			lawnSprite[1] = ImageIO.read(new File("lawnN.png"));
			lawnSprite[2] = ImageIO.read(new File("lawnE.png"));
			lawnSprite[3] = ImageIO.read(new File("lawnS.png"));
			lawnSprite[4] = ImageIO.read(new File("lawnWE.png"));
			
			volcanoSprite = new Image[5];
			
			volcanoSprite[0] = ImageIO.read(new File("volcanoM.png")); //milieu
			volcanoSprite[1] = ImageIO.read(new File("volcanoN.png")); // HAut		
			volcanoSprite[2] = ImageIO.read(new File("volcanoE.png")); //droite 	
			volcanoSprite[3] = ImageIO.read(new File("volcanoS.png")); //Bas
			volcanoSprite[4] = ImageIO.read(new File("volcanoWE.png")); //gauche
			
			lavaSprite = ImageIO.read(new File("lava.png"));
			

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
			
			rainSprite=new Image[5];
			rainSprite[0] = ImageIO.read(new File("rain1.png"));
			rainSprite[1] = ImageIO.read(new File("rain2.png"));
			rainSprite[2] = ImageIO.read(new File("rain3.png"));
			rainSprite[3] = ImageIO.read(new File("rain4.png"));
			rainSprite[4] = ImageIO.read(new File("rain1.png"));

			//Tree
			treeSprite = ImageIO.read(new File("tree.png"));
			coalSprite = ImageIO.read(new File("coaltree.png"));





		}
		catch(Exception e)
		{
		}	
	}
	//Affichage pour les agents dans la class agent
	public void affichageStarter(int i,Graphics2D g2, JFrame frame,Starter a){
//		if(a.getName().equals("salameche")){
//			if(a.getMove()==true){
//				if(Agent.NORD==a.getDirection())
//					g2.drawImage(goatSprite[a.getDirection()][i], World.spriteLength*a.getX(),World.spriteLength*a.getY()-(i*World.spriteLength)/4,World.spriteLength+50,50+World.spriteLength,frame);
//				if(Agent.EST==a.getDirection())
//					g2.drawImage(goatSprite[a.getDirection()][i], World.spriteLength*a.getX()+(i*World.spriteLength)/4,World.spriteLength*a.getY(),World.spriteLength+50,World.spriteLength+50,frame);
//				if(Agent.SUD==a.getDirection())
//					g2.drawImage(goatSprite[a.getDirection()][i], World.spriteLength*a.getX(),World.spriteLength*a.getY()+(i*World.spriteLength)/4,World.spriteLength+50,World.spriteLength+50,frame);
//				if(Agent.WEST==a.getDirection())
//					g2.drawImage(goatSprite[a.getDirection()][i], World.spriteLength*a.getX()-(i*World.spriteLength)/4,World.spriteLength*a.getY(),World.spriteLength+50,World.spriteLength+50,frame);
//			}else {
//				g2.drawImage(goatSprite[a.getDirection()][0], World.spriteLength*a.getX(),World.spriteLength*a.getY(),World.spriteLength,World.spriteLength,frame);
//			}
//		}

		if(a.getName().equals("salameche") ){
			if(a.getMove()==true){
				if(Agent.NORD==a.getDirection())
					g2.drawImage(salamecheSprite[a.getDirection()][i%2], World.spriteLength*a.getX()+World.X*World.spriteLength-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
				if(Agent.EST==a.getDirection())
					g2.drawImage(salamecheSprite[a.getDirection()][i%2], World.spriteLength*a.getX()+World.X*World.spriteLength+(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
				if(Agent.SUD==a.getDirection())
					g2.drawImage(salamecheSprite[a.getDirection()][i%2], World.spriteLength*a.getX()+World.X*World.spriteLength-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength+(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
				if(Agent.WEST==a.getDirection())
					g2.drawImage(salamecheSprite[a.getDirection()][i%2], World.spriteLength*a.getX()+World.X*World.spriteLength-(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
			}else {
				g2.drawImage(salamecheSprite[a.getDirection()][2], World.spriteLength*a.getX()+World.X*World.spriteLength-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
			}
		}else if (a.getName().equals("reptincel")) {
			if(a.getMove()==true){
				if(Agent.NORD==a.getDirection())
					g2.drawImage(reptincelSprite[a.getDirection()][i%2], World.spriteLength*a.getX()+World.X*World.spriteLength-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
				if(Agent.EST==a.getDirection())
					g2.drawImage(reptincelSprite[a.getDirection()][i%2], World.spriteLength*a.getX()+World.X*World.spriteLength+(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
				if(Agent.SUD==a.getDirection())
					g2.drawImage(reptincelSprite[a.getDirection()][i%2], World.spriteLength*a.getX()+World.X*World.spriteLength-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength+(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
				if(Agent.WEST==a.getDirection())
					g2.drawImage(reptincelSprite[a.getDirection()][i%2], World.spriteLength*a.getX()+World.X*World.spriteLength-(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
			}else {
				g2.drawImage(reptincelSprite[a.getDirection()][2], World.spriteLength*a.getX()+World.X*World.spriteLength-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
			}
		}else if(a.getName().equals("dracaufeu")){
			if(a.getMove()==true){
				if(Agent.NORD==a.getDirection())
					g2.drawImage(dracaufeuSprite[a.getDirection()][i%2], World.spriteLength*a.getX()+World.X*World.spriteLength-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
				if(Agent.EST==a.getDirection())
					g2.drawImage(dracaufeuSprite[a.getDirection()][i%2], World.spriteLength*a.getX()+World.X*World.spriteLength+(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
				if(Agent.SUD==a.getDirection())
					g2.drawImage(dracaufeuSprite[a.getDirection()][i%2], World.spriteLength*a.getX()+World.X*World.spriteLength-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength+(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
				if(Agent.WEST==a.getDirection())
					g2.drawImage(dracaufeuSprite[a.getDirection()][i%2], World.spriteLength*a.getX()+World.X*World.spriteLength-(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
			}else {
				g2.drawImage(dracaufeuSprite[a.getDirection()][2], World.spriteLength*a.getX()+World.X*World.spriteLength-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
			}
		}
//		if(a.getName().equals("cloud") ){
//			//if(a.moving(a.getDirection())==true){
//				if(Agent.NORD==a.getDirection())
//					g2.drawImage(cloudSprite, World.spriteLength*a.getX()+World.X*World.spriteLength-a.getTime()/2,World.spriteLength*a.getY()+World.Y*World.spriteLength-(i*World.spriteLength)/4-a.getTime()/2,World.spriteLength+a.getTime(),World.spriteLength+a.getTime(),frame);
//				if(Agent.EST==a.getDirection())
//					g2.drawImage(cloudSprite, World.spriteLength*a.getX()+World.X*World.spriteLength+(i*World.spriteLength)/4-a.getTime()/2,World.spriteLength*a.getY()+World.Y*World.spriteLength-a.getTime()/2,World.spriteLength+a.getTime(),World.spriteLength+a.getTime(),frame);
//				if(Agent.SUD==a.getDirection())
//					g2.drawImage(cloudSprite, World.spriteLength*a.getX()+World.X*World.spriteLength-a.getTime()/2,World.spriteLength*a.getY()+World.Y*World.spriteLength+(i*World.spriteLength)/4-a.getTime()/2,World.spriteLength+a.getTime(),World.spriteLength+a.getTime(),frame);
//				if(Agent.WEST==a.getDirection())
//					g2.drawImage(cloudSprite, World.spriteLength*a.getX()+World.X*World.spriteLength-(i*World.spriteLength)/4-a.getTime()/2,World.spriteLength*a.getY()+World.Y*World.spriteLength-a.getTime()/2,World.spriteLength+a.getTime(),World.spriteLength+a.getTime(),frame);
//			}else {
//				g2.drawImage(cloudSprite, World.spriteLength*a.getX()+World.X*World.spriteLength-a.getTime()/2,World.spriteLength*a.getY()+World.Y*World.spriteLength-a.getTime()/2,World.spriteLength+a.getTime(),World.spriteLength+a.getTime(),frame);
//			}
//		}
		if(a.getName().equals("carapuce") ){
			if(a.getMove()==true){
				if(Agent.NORD==a.getDirection())
					g2.drawImage(carapuceSprite[a.getDirection()][i%2], World.spriteLength*a.getX()+World.X*World.spriteLength-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
				if(Agent.EST==a.getDirection())
					g2.drawImage(carapuceSprite[a.getDirection()][i%2], World.spriteLength*a.getX()+World.X*World.spriteLength+(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
				if(Agent.SUD==a.getDirection())
					g2.drawImage(carapuceSprite[a.getDirection()][i%2], World.spriteLength*a.getX()+World.X*World.spriteLength-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength+(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
				if(Agent.WEST==a.getDirection())
					g2.drawImage(carapuceSprite[a.getDirection()][i%2], World.spriteLength*a.getX()+World.X*World.spriteLength-(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
			}else {
				g2.drawImage(carapuceSprite[a.getDirection()][2], World.spriteLength*a.getX()+World.X*World.spriteLength-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
			}
		}
	}
	public void affichageLife(Graphics2D g2, Starter a, int i) {
		if(a.getMove()==true){
			if(Agent.NORD==a.getDirection()) {
				g2.setColor(Color.red);
				g2.fillRect(World.spriteLength*a.getX()+World.X*World.spriteLength-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,(World.spriteLength/5)*World.spriteLength/20);
				g2.setColor(Color.green);
				g2.fillRect(World.spriteLength*a.getX()+World.X*World.spriteLength-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-(i*World.spriteLength)/4-10*World.spriteLength/20,(World.spriteLength+20*World.spriteLength/20)*a.getLife()/a.getLifemax(),(World.spriteLength/5)*World.spriteLength/20);
			}else if(Agent.EST==a.getDirection()) {
				g2.setColor(Color.red);
				g2.fillRect( World.spriteLength*a.getX()+World.X*World.spriteLength+(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,(World.spriteLength/5)*World.spriteLength/20);
				g2.setColor(Color.green);
				g2.fillRect( World.spriteLength*a.getX()+World.X*World.spriteLength+(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-10*World.spriteLength/20,(World.spriteLength+20*World.spriteLength/20)*a.getLife()/a.getLifemax(),(World.spriteLength/5)*World.spriteLength/20);
			}else if(Agent.SUD==a.getDirection()) {
				g2.setColor(Color.red);
				g2.fillRect( World.spriteLength*a.getX()+World.X*World.spriteLength-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength+(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,(World.spriteLength/5)*World.spriteLength/20);
				g2.setColor(Color.green);
				g2.fillRect( World.spriteLength*a.getX()+World.X*World.spriteLength-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength+(i*World.spriteLength)/4-10*World.spriteLength/20,(World.spriteLength+20*World.spriteLength/20)*a.getLife()/a.getLifemax(),(World.spriteLength/5)*World.spriteLength/20);
			}else if(Agent.WEST==a.getDirection()) {
				g2.setColor(Color.red);
				g2.fillRect( World.spriteLength*a.getX()+World.X*World.spriteLength-(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,(World.spriteLength/5)*World.spriteLength/20);
				g2.setColor(Color.green);
				g2.fillRect( World.spriteLength*a.getX()+World.X*World.spriteLength-(i*World.spriteLength)/4-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-10*World.spriteLength/20,(World.spriteLength+20*World.spriteLength/20)*a.getLife()/a.getLifemax(),(World.spriteLength/5)*World.spriteLength/20);
			}
				
		}else {
			g2.setColor(Color.red);
			g2.fillRect( World.spriteLength*a.getX()+World.X*World.spriteLength-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,(World.spriteLength/5)*World.spriteLength/20);
			g2.setColor(Color.green);
			g2.fillRect( World.spriteLength*a.getX()+World.X*World.spriteLength-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-10*World.spriteLength/20,(World.spriteLength+20*World.spriteLength/20)*a.getLife()/a.getLifemax(),(World.spriteLength/5)*World.spriteLength/20);
		}
	}
	//Affichage Ombre du nuage 
	public void affichageShadowcloud(int i,Graphics2D g2, JFrame frame,Cloud a) {
		if(a.getMove()==true){
			if(Agent.NORD==a.getDirection())
				g2.drawImage(shadowcloudSprite, World.spriteLength*a.getX()+World.X*World.spriteLength-(a.getTime()/2)*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-(i*World.spriteLength)/4-(a.getTime()/2)*World.spriteLength/20,World.spriteLength+(a.getTime())*World.spriteLength/20,World.spriteLength+a.getTime()*World.spriteLength/20,frame);
			if(Agent.EST==a.getDirection())
				g2.drawImage(shadowcloudSprite, World.spriteLength*a.getX()+World.X*World.spriteLength+(i*World.spriteLength)/4-(a.getTime()/2)*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-(a.getTime()/2)*World.spriteLength/20,World.spriteLength+(a.getTime())*World.spriteLength/20,World.spriteLength+a.getTime()*World.spriteLength/20,frame);
			if(Agent.SUD==a.getDirection())
				g2.drawImage(shadowcloudSprite, World.spriteLength*a.getX()+World.X*World.spriteLength-(a.getTime()/2)*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength+(i*World.spriteLength)/4-(a.getTime()/2)*World.spriteLength/20,World.spriteLength+(a.getTime())*World.spriteLength/20,World.spriteLength+(a.getTime())*World.spriteLength/20,frame);
			if(Agent.WEST==a.getDirection())
				g2.drawImage(shadowcloudSprite, World.spriteLength*a.getX()+World.X*World.spriteLength-(i*World.spriteLength)/4-(a.getTime()/2)*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-(a.getTime()/2)*World.spriteLength/20,World.spriteLength+(a.getTime())*World.spriteLength/20,World.spriteLength+(a.getTime())*World.spriteLength/20,frame);
		}else {
			g2.drawImage(shadowcloudSprite, World.spriteLength*a.getX()+World.X*World.spriteLength-(a.getTime()/2)*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-(a.getTime()/2)*World.spriteLength/20,World.spriteLength+(a.getTime())*World.spriteLength/20,World.spriteLength+(a.getTime())*World.spriteLength/20,frame);
		}
	}
	
	public void affichageCloud(int i,Graphics2D g2, JFrame frame,Cloud a) {
		if(a.getMove()==true){
			if(Agent.NORD==a.getDirection())
				g2.drawImage(cloudSprite, World.spriteLength*a.getX()+World.X*World.spriteLength-(a.getTime()/2)*World.spriteLength/20,World.spriteLength*((a.getY()-2+a.getMap().getY())%a.getMap().getY())+World.Y*World.spriteLength-(i*World.spriteLength)/4-(a.getTime()/2)*World.spriteLength/20,World.spriteLength+a.getTime()*World.spriteLength/20,World.spriteLength+a.getTime()*World.spriteLength/20,frame);
			if(Agent.EST==a.getDirection())
				g2.drawImage(cloudSprite, World.spriteLength*a.getX()+World.X*World.spriteLength+(i*World.spriteLength)/4-(a.getTime()/2)*World.spriteLength/20,World.spriteLength*((a.getY()-2+a.getMap().getY())%a.getMap().getY())+World.Y*World.spriteLength-(a.getTime()/2)*World.spriteLength/20,World.spriteLength+a.getTime()*World.spriteLength/20,World.spriteLength+a.getTime()*World.spriteLength/20,frame);
			if(Agent.SUD==a.getDirection())
				g2.drawImage(cloudSprite, World.spriteLength*a.getX()+World.X*World.spriteLength-(a.getTime()/2)*World.spriteLength/20,World.spriteLength*((a.getY()-2+a.getMap().getY())%a.getMap().getY())+World.Y*World.spriteLength+(i*World.spriteLength)/4-(a.getTime()/2)*World.spriteLength/20,World.spriteLength+a.getTime()*World.spriteLength/20,World.spriteLength+a.getTime()*World.spriteLength/20,frame);
			if(Agent.WEST==a.getDirection())
				g2.drawImage(cloudSprite, World.spriteLength*a.getX()+World.X*World.spriteLength-(i*World.spriteLength)/4-(a.getTime()/2)*World.spriteLength/20,World.spriteLength*((a.getY()-2+a.getMap().getY())%a.getMap().getY())+World.Y*World.spriteLength-(a.getTime()/2)*World.spriteLength/20,World.spriteLength+a.getTime()*World.spriteLength/20,World.spriteLength+a.getTime()*World.spriteLength/20,frame);
		}else {
			g2.drawImage(cloudSprite, World.spriteLength*a.getX()+World.X*World.spriteLength-(a.getTime()/2)*World.spriteLength/20,World.spriteLength*((a.getY()-2+a.getMap().getY())%a.getMap().getY())+World.Y*World.spriteLength-(a.getTime()/2)*World.spriteLength/20,World.spriteLength+a.getTime()*World.spriteLength/20,World.spriteLength+a.getTime()*World.spriteLength/20,frame);
		}
	}
	public void affichageEgg(Graphics2D g2, JFrame frame, Egg a) {
		g2.drawImage(eggSprite, World.spriteLength*a.getX()+World.X*World.spriteLength-10*World.spriteLength/20,World.spriteLength*a.getY()+World.Y*World.spriteLength-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
	}
	//Afficahge pour les tableaux dans la class map
	public void affichageTerrain(Graphics2D g2, JFrame frame, int x,int y, int type[][]){
		if (Map.DEEPWATER==type[x][y])
			g2.drawImage(deepwaterSprite, World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
		if (Map.WATER==type[x][y])
			g2.drawImage(waterSprite, World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
		if (Map.SAND==type[x][y])
				g2.drawImage(sandSprite[0], World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
		if(Map.LAWN==type[x][y])
			g2.drawImage(lawnSprite[0], World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
		if(Map.VOLCANO<=type[x][y] && type[x][y]<Map.LAVA) 
			g2.drawImage(volcanoSprite[0], World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
//		if(Map.LAVA==type[x][y])
//			g2.drawImage(lavaSprite, World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
	}
	
	public void affichageLava(Graphics2D g2, JFrame frame, int x,int y, int type[][]){
		if(1==type[x][y])
			g2.drawImage(lavaSprite, World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
	
	}
	
	//Fonction affiche les objets 
	public void affichageObject(Graphics2D g2, JFrame frame, int x,int y, int type){
		if(Map.GRASS==type)
			g2.drawImage(grassSprite, World.spriteLength*x+World.X*World.spriteLength-10*World.spriteLength/20,World.spriteLength*y+World.Y*World.spriteLength-10*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,World.spriteLength+20*World.spriteLength/20,frame);
	}
	
	//Fonction qui affiche les effect (Eclaire ou pluie)
	public void affichageEffect(Graphics2D g2, JFrame frame, int x,int y, int type, int i) {
		if(Map.LIGHTNING==type)
			g2.drawImage(lightSprite[i], World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*(y-1)+World.Y*World.spriteLength,World.spriteLength,World.spriteLength+10*World.spriteLength/20,frame);
		if(Map.RAIN==type)
			g2.drawImage(rainSprite[i%4], World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*(y-1)+World.Y*World.spriteLength,World.spriteLength,World.spriteLength+10*World.spriteLength/20,frame);
		
	}
	
	//Fonction qui affiche le feu de foret
	public void affichageTree(Graphics2D g2, JFrame frame, Tree t){
		if(t.isAlive()==true && t.getLife() >0){
			if(t.getLife()==1){
				g2.drawImage(coalSprite, World.spriteLength*t.getX()+World.X*World.spriteLength-15*World.spriteLength/20, World.spriteLength*t.getY()+World.Y*World.spriteLength-30*World.spriteLength/20, World.spriteLength+30*World.spriteLength/20, World.spriteLength+30*World.spriteLength/20, frame);
			}else{
				g2.drawImage(treeSprite, World.spriteLength*t.getX()+World.X*World.spriteLength-15*World.spriteLength/20, World.spriteLength*t.getY()+World.Y*World.spriteLength-30*World.spriteLength/20, World.spriteLength+30*World.spriteLength/20, World.spriteLength+30*World.spriteLength/20, frame);
			}
			if (t.isBurn()==true) //Arbre en feu
				g2.drawImage(fireSprite, World.spriteLength*t.getX()+World.X*World.spriteLength, World.spriteLength*t.getY()+World.Y*World.spriteLength, World.spriteLength, World.spriteLength, frame);
		}
	}
	
	//Fonction pour afficher les bordure du terrain 
	public void affichageBordurenord(Graphics2D g2, JFrame frame, int x,int y, int type[][]) {
		if (Map.SAND==type[x][y])
			if (type[x][y-1] < type[x][y])
				g2.drawImage(sandSprite[1], World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength-2*World.spriteLength/20,World.spriteLength,World.spriteLength,frame);
		if (Map.LAWN==type[x][y])
			if (type[x][y-1] < type[x][y])
				g2.drawImage(lawnSprite[1], World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength-4*World.spriteLength/20,World.spriteLength,World.spriteLength,frame);
					
		if (Map.VOLCANO<=type[x][y])
			if (type[x][y-1] < type[x][y])
				g2.drawImage(volcanoSprite[1], World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength-2*World.spriteLength/20,World.spriteLength,World.spriteLength,frame);
	}
	public void affichageBordureest(Graphics2D g2, JFrame frame, int x,int y, int type[][]) {
		if (Map.SAND==type[x][y])
			if(type[x+1][y] < type[x][y] )
				g2.drawImage(sandSprite[2], 2*World.spriteLength/20+World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
		if (Map.LAWN==type[x][y])
			if (type[x+1][y] < type[x][y])
				g2.drawImage(lawnSprite[2], 4*World.spriteLength/20+World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
			
		if (Map.VOLCANO<=type[x][y])
			if (type[x+1][y] < type[x][y])
				g2.drawImage(volcanoSprite[2], 2*World.spriteLength/20+World.spriteLength*x+World.X*World.spriteLength,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
	
	}
	public void affichageBorduresud(Graphics2D g2, JFrame frame, int x,int y, int type[][]) {
		if (Map.SAND==type[x][y])
			if (type[x][y+1] < type[x][y])
				g2.drawImage(sandSprite[3], World.spriteLength*x+World.X*World.spriteLength,2*World.spriteLength/20+World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
		if (Map.LAWN==type[x][y])
			if (type[x][y+1] < type[x][y])
				g2.drawImage(lawnSprite[3], World.spriteLength*x+World.X*World.spriteLength,4*World.spriteLength/20+World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
			
		if (Map.VOLCANO<=type[x][y])
			if (type[x][y+1] < type[x][y])
				g2.drawImage(volcanoSprite[3], World.spriteLength*x+World.X*World.spriteLength,2*World.spriteLength/20+World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
	
	}
	public void affichageBordurewest(Graphics2D g2, JFrame frame, int x,int y, int type[][]) {
		if (Map.SAND==type[x][y])
			if (type[x-1][y] < type[x][y] ) 
				g2.drawImage(sandSprite[4], World.spriteLength*x+World.X*World.spriteLength-2*World.spriteLength/20,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
		if (Map.LAWN==type[x][y])
			if (type[x-1][y] < type[x][y] )
				g2.drawImage(lawnSprite[4], World.spriteLength*x+World.X*World.spriteLength-4*World.spriteLength/20,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
			
		if (Map.VOLCANO<=type[x][y])
			if (type[x-1][y] < type[x][y])
				g2.drawImage(volcanoSprite[4], World.spriteLength*x+World.X*World.spriteLength-2*World.spriteLength/20,World.spriteLength*y+World.Y*World.spriteLength,World.spriteLength,World.spriteLength,frame);
	
	}
}