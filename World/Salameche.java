
public class Salameche extends Starter{
	public static final int LIFE=39;
	public Salameche(Map m) {
		super(LIFE,m, "salameche");
		do{
			x=(int)(Math.random()*m.getX());
			y=(int)(Math.random()*m.getY());

		}while(m.getTerrain(x,y)!=Map.SAND && m.getTerrain(x,y)!=Map.LAWN);
		type=FEU;
		attack=1;
		value_xp=62;
	}
	public Salameche(int x, int y, Map m) {
		super(LIFE, m, "salameche");
		this.x=x;
		this.y=y;
		type=FEU;
		attack=1;
		value_xp=62;
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
