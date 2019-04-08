
public class Cloud extends Agent{
	public static int SIZE=20;//La taille Maximum du nuage
	
	private int time;
	private boolean lightning;
	private boolean rain;
	public Cloud(int life, Map m) {
		super(life,m,"cloud");
		do{
			x=(int)(Math.random()*m.getX());
			y=(int)(Math.random()*m.getY());
		}while(m.getTerrain(x,y)!=Map.WATER); //Apparait dans l'eau
		time=1;
		lightning=false;
	}
	public void step(){ 
		
		direction=(int)(Math.random()*4);
		lightning=false;
		rain=false;
		
		int x1=x;
		int y1=y;
		
		if ( direction == NORD) // nord
        	y1 = (y1 - 1) ;
        if ( direction == EST)	// est
        	x1 = (x1 + 1);
        if ( direction == SUD)	// sud
         	y1 = (y1 + 1);
        if ( direction == WEST)// ouest
         	x1 = (x1 - 1);

        move=false;
        
        if (m.getTerrain(x1,y1)==Map.WATER) {
        	move=true;
        	if(SIZE>=time)
        		time++;
        }   
        if (time>=SIZE) { //Le nuage sort de l'eau quand il a atteint sa taille maximale
        	move=true;
        	if(Map.BLIGHTNING>Math.random()) {
            	move=false;
            	lightning=true;
            	m.setEffect(x, y, Map.LIGHTNING);
            }else if(Map.BRAIN>Math.random()) {
            	move=false;
            	rain=true;
            	m.setEffect(x, y, Map.RAIN);
            }
        }
        
		if (life<= 0){
			alive=false;
		}
        life=life-1;
	}
	
	public void move(){
		if (move==true){
			if (direction == NORD) // nord
    	    	y = ((y - 1+m.getY()) % m.getY()) ;
        	if ( direction == EST)	// est
	        	x = ((x + 1+m.getX()) % m.getX());
    	    if ( direction == SUD)	// sud
        	 	y = ((y + 1+m.getY()) % m.getY()) ;
        	if ( direction == WEST)// ouest
         		x = ((x - 1+m.getX()) % m.getX()) ;
    	    }
   	}
	
	
	public int getTime() {
		return time;
	}
	public boolean getLightning() {
		return lightning;
	}
	public boolean getRain() {
		return rain;
	}
	public boolean getMove() {
		return move;
	}
}
