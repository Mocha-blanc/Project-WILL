import java.util.ArrayList;

public class Bulbizar extends Starter{
	public static final int LIFE=39;
	public Bulbizar(Map m,String s) {
		super(LIFE,m,s);
		do{
			x=(int)(Math.random()*m.getX());
			y=(int)(Math.random()*m.getY());

		}while(m.getTerrain(x,y)!=Map.LAWN);
		type=EAU;
		attack=2;
		value_xp=63;
	}
	public Bulbizar(int x, int y, Map m) {
		super(LIFE, m, "bulbizar");
		this.x=x;
		this.y=y;
		attack=2;
	}
	public void step(ArrayList <Starter> a) {
		move=false;
		fighting=true;
		findEnnemy(a);
		up();
		int x1=x;
		int y1=y;

		if(fighting==false) {
			
			direction=(int)(Math.random()*4);
		}
		if ( direction == NORD) // nord
        	y1 = (y1 - 1) ;
        if ( direction == EST)	// est
        	x1 = (x1 + 1);
        if ( direction == SUD)	// sud
         	y1 = (y1 + 1);
        if ( direction == WEST)// ouest
         	x1 = (x1 - 1);
        
		if(fighting==true) {
			
			attack(x1,y1,a);
		
		}else {
			if ((m.getTerrain(x1,y1)==Map.SAND || m.getTerrain(x1,y1)==Map.LAWN ) && m.getTree(x1,y1).getLife()==0)
				move=true;
		}
		if (life<= 0){
			alive=false;
			giveExp(a);
		}
		
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
   	}
}
