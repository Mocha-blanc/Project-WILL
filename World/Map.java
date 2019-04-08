import java.util.ArrayList;

public class Map{
	
	//Probabilite de réaparition qui sont dans les step:
	public final static double BGRASS=0.001;  //Probabilite d'apparition d'Herbre
	public final static double BTREE=0.0001; //Probabilite d'apparition d'Arbre

	public final static double BFIRE=1.5; //Probabilite de contamination Feu de foret  

	public final static double BLIGHTNING=0.01; //Probabilite d'apparition de foudre
	public final static double BRAIN=0.01;//Probabilite d'apparition de pluie
	
	public final static double BLAND=0.25;//Probabilite qui permet de creer une ile au centre 
	//Valeur pour le bruit de perlin :
	public final static int RANDOMPNOISE=(int)(Math.random()*256); //Valeur permet de générer aleatoirement le bruit de perlin (vous pouvez mettre d'autre valeur que 256)
	public final static int RESOLUTION=20; //Resolution du bruit de perlin qui permet de changer l'altitue de la generation du terrain (Essayez de le modifier entre (10-80)
	//Variable pour les tableaux
	public static final int VIDE=0;
	//Terrain 
	public static final int DEEPWATER=0; //Eau profonde
    public static final int WATER=1; //Eau	
    public static final int SAND=2; //Sable
    public static final int LAWN=3; //Pelouse
    public static final int VOLCANO=4; //Volcan
    public static final int LAVA=10; //Lave (Hauteur de la lave)
	//Object
	public static final int GRASS=1; //Herbe
	//Effet
	public static final int LIGHTNING=1;	//Foudre
	public static final int RAIN=2;  //Pluie
	
	
	
	private int x;
	private int y;
	//Tableau temporaire 
	private int lava[][];
	//Tableau d'affichage 
	private int terrain[][];//Arriere plan qui est rarement modifier
	
	private Tree tree[][];//Feu de foret 
	private Tree tabTree[][];

	private int object[][];//Affichage d'objet sur le terrain

	private int effect[][];//Affichage qui apparait pendant un court iteration

	
	//Construteur 
	public Map(int x, int y){
		this.x=x;
		this.y=y;

		terrain=new int[x][y];
		object=new int [x][y];
		effect=new int[x][y];
		tree=new Tree[x][y];

		tabTree=new Tree[x][y];
		
		lava=new int[x][y];
		for (int i=0; i<x ;i++)
			for (int j=0; j<y ; j++){
				terrain[i][j]=VIDE;
				tree[i][j]=new Tree(i,j);
				tabTree[i][j]=tree[i][j];
				object[i][j]=VIDE;
				effect[i][j]=VIDE;
				lava[i][j]=VIDE;
			}
		int tabV[][]= new int[x][y];
		
		//Utilisation de bruit de perlin
		for (int i=1; i<x-1 ;i++) {
			for (int j=1; j<y-1 ; j++){
				terrain[i][j]=(int)((Map.Get2DPerlinNoiseValue(i, j,RESOLUTION)+1)*0.5*7)%7; //generation de bruit de perlin
				tabV[i][j]=0;
			}
		}
		
		//Initialisation des plaques de VOLCANO jusqu'a LAVA
		for(int cpt=1; cpt<=LAVA-VOLCANO;cpt++) {
			for (int i=1; i<x-1 ;i++) {
				for (int j=1; j<y-1 ; j++) {
					if(terrain[i][j]==VOLCANO+cpt-1 && terrain[i-1][j-1]>=VOLCANO+cpt-1 && terrain[i][j-1]>=VOLCANO+cpt-1 && terrain[i+1][j-1]>=VOLCANO+cpt-1 && terrain[i-1][j]>=VOLCANO+cpt-1 && terrain[i+1][j]>=VOLCANO+cpt-1 && terrain[i-1][j+1]>=VOLCANO+cpt-1 && terrain[i][j+1]>=VOLCANO+cpt-1 && terrain[i+1][j+1]>=VOLCANO+cpt-1) {
						tabV[i][j]+=1;
					}
				}
			}
			for (int i=1; i<x-1 ;i++)
				for (int j=1; j<y-1 ; j++) {
					terrain[i][j]+=tabV[i][j];
					tabV[i][j]=0;
					if(terrain[i][j]==LAVA)
						lava[i][j]=1;
				}
		}
		
	}
		


	public void step(ArrayList<Starter> agent){
		
		stepObject(agent); 
		stepTree(agent);
		stepEffect();

	}

	public void stepObject(ArrayList<Starter> agent){ 
		for (int i=0; i<x ; i++)
			for (int j=0; j<y ; j++)
				if(terrain[i][j]==LAWN)
				{
					if(BGRASS>Math.random()){
						if(Gestion_agent.isStarter(i,j,agent)==false)
							object[i][j]=GRASS;
					}
				}
	}
	


	public void stepTree(ArrayList<Starter> agent){
		//Step de chaque arbre
		for (int i=0; i<x;i++){
			for(int j=0; j<y;j++){
				tree[i][j].step();
				
			}
		}
		//Progation du feu
		for (int i=0; i<x ; i++){
			for (int j=0; j<y ; j++){
				if(terrain[i][j]==LAWN)
				{
					if(tree[i][j].isAlive()==true && tree[i][j].isBurn()==false){//Prend feu a proximiter
						if (effect[i][j]==LIGHTNING) {
							tabTree[i][j].burn();
						}else if(tree[i+1][j].isBurn()==true && BFIRE>Math.random()){
							tabTree[i][j].burn();
						}else if(tree[i-1][j].isBurn()==true && BFIRE>Math.random()){
							tabTree[i][j].burn();
						}else if(tree[i][j+1].isBurn()==true && BFIRE>Math.random()){
							tabTree[i][j].burn();
						}else if(tree[i][j-1].isBurn()==true && BFIRE>Math.random()){
							tabTree[i][j].burn();
						}else{
							tabTree[i][j]=tree[i][j];
						}
					}else if(tree[i][j].isAlive()==true && tree[i][j].isBurn()==true) {
						if (effect[i][j]==RAIN) {
							tabTree[i][j].rain();
						}else{
							tabTree[i][j]=tree[i][j];
						}
					}else if(tree[i][j].isAlive()==false && tree[i][j].isBurn()==false){
						if(BTREE>Math.random()){
							if(Gestion_agent.isStarter(i,j,agent)==false)
								tabTree[i][j].alive(); //L'arbre est initialiser
						}
					}else {
						tabTree[i][j]=tree[i][j];
					}
				}
			}
		}


		//MAJ de l'automate
		for (int i=0; i<x ; i++){
			for (int j=0; j<y ; j++){
				tree[i][j]= new Tree(tabTree[i][j]);
			
			}
		}
	}
	//Tableau d'effet 
	public void stepEffect(){
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				effect[i][j]=VIDE;
			}
		}
	}
	
	//Bruit de perlin (fonction trouver sur internet)
	public static double Get2DPerlinNoiseValue(double x, double y, double res)
	{
	    double tempX,tempY;
	    int x0,y0,ii,jj,gi0,gi1,gi2,gi3;
	    double unit = 1.0/Math.sqrt(2);
	    double tmp,s,t,u,v,Cx,Cy,Li1,Li2;
	    double gradient2[][] = {{unit,unit},{-unit,unit},{unit,-unit},{-unit,-unit},{1,0},{-1,0},{0,1},{0,-1}};

	    int perm[] =
	       {151,160,137,91,90,15,131,13,201,95,96,53,194,233,7,225,140,36,103,30,69,
	        142,8,99,37,240,21,10,23,190,6,148,247,120,234,75,0,26,197,62,94,252,219,
	        203,117,35,11,32,57,177,33,88,237,149,56,87,174,20,125,136,171,168,68,175,
	        74,165,71,134,139,48,27,166,77,146,158,231,83,111,229,122,60,211,133,230,220,
	        105,92,41,55,46,245,40,244,102,143,54,65,25,63,161,1,216,80,73,209,76,132,
	        187,208,89,18,169,200,196,135,130,116,188,159,86,164,100,109,198,173,186,3,
	        64,52,217,226,250,124,123,5,202,38,147,118,126,255,82,85,212,207,206,59,227,
	        47,16,58,17,182,189,28,42,223,183,170,213,119,248,152,2,44,154,163,70,221,
	        153,101,155,167,43,172,9,129,22,39,253,19,98,108,110,79,113,224,232,178,185,
	        112,104,218,246,97,228,251,34,242,193,238,210,144,12,191,179,162,241,81,51,145,
	        235,249,14,239,107,49,192,214,31,181,199,106,157,184,84,204,176,115,121,50,45,
	        127,4,150,254,138,236,205,93,222,114,67,29,24,72,243,141,128,195,78,66,215,61,
	        156,180};

	    //Prendre les coordonnées aléatoirement dans le bruit de perlin 
	    x+=RANDOMPNOISE;
	    y+=RANDOMPNOISE;
	    
	    //Adapter pour la résolution
	    x /= res;
	    y /= res;

	    //On récupère les positions de la grille associée à (x,y)
	    x0 = (int)(x);
	    y0 = (int)(y);

	    //Masquage
	    ii = x0 % 255;
	    jj = y0 % 255;

	    //Pour récupérer les vecteurs
	    gi0 = perm[(ii + perm[jj])%256] % 8;
	    gi1 = perm[(ii + 1 + perm[jj])%256] % 8;
	    gi2 = perm[(ii + perm[jj + 1])%256] % 8;
	    gi3 = perm[(ii + 1 + perm[jj + 1])%256] % 8;

	    //on récupère les vecteurs et on pondère
	    tempX = x-x0;
	    tempY = y-y0;
	    s = gradient2[gi0][0]*tempX + gradient2[gi0][1]*tempY;

	    tempX = x-(x0+1);
	    tempY = y-y0;
	    t = gradient2[gi1][0]*tempX + gradient2[gi1][1]*tempY;

	    tempX = x-x0;
	    tempY = y-(y0+1);
	    u = gradient2[gi2][0]*tempX + gradient2[gi2][1]*tempY;

	    tempX = x-(x0+1);
	    tempY = y-(y0+1);
	    v = gradient2[gi3][0]*tempX + gradient2[gi3][1]*tempY;


	    //Lissage
	    tmp = x-x0;
	    Cx = 3 * tmp * tmp - 2 * tmp * tmp * tmp;

	    Li1 = s + Cx*(t-s);
	    Li2 = u + Cx*(v-u);

	    tmp = y - y0;
	    Cy = 3 * tmp * tmp - 2 * tmp * tmp * tmp;

	    return Li1 + Cy*(Li2-Li1);
	}

	//Set
	public void setObject(int x,int y, int v){
		object[x][y]=v;
	}
	public void setEffect(int x, int y, int v) {
		effect[x][y]=v;
	}
	//Get
	public int getTerrain(int x,int y){
		return terrain[(x+this.x)%this.x][(y+this.y)%this.y];
	}
	public int[][] getTerrain() {
		return terrain;
	}
	public int getObject(int x, int y){
		return object[x][y];
	}
	public int getEffect(int x, int y) {
		return effect[x][y];
	}
	public Tree getTree(int x,int y){
		return tree[x][y];
	}
	public int[][] getLava() {
		return lava;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}