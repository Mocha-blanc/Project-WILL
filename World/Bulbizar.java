
public class Bulbizar extends Starter{
	public static final int LIFE=39;
	public Bulbizar(Map m) {
		super(LIFE,m,"bulbizarre");
		
		do{
			x=(int)(Math.random()*m.getX());
			y=(int)(Math.random()*m.getY());

		}while(m.getTerrain(x,y)!=Map.LAWN);
		type=HERBE;
		value_xp=63;
	}
	public Bulbizar(int x, int y, Map m) {
		super(LIFE, m, "bulbizarre");
		this.x=x;
		this.y=y;
		type=HERBE;
		attack=1;
		value_xp=63;
	}
	public void move(){
		if (move==true){
			if ( direction == NORD) // nord
    	    	y = (y - 1) ;
        	if ( direction == EST)	// est
	        	x = (x + 1);
    	    if ( direction == SUD)	// sud
        	 	y = (y + 1) ;
        	if ( direction == WEST)// ouest
         		x = (x - 1) ;
    	    }
		eatObject();
   	}
}
