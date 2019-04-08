import java.util.ArrayList;

public class Egg extends Agent{
	public final static int TIME=10;
	private int type;
	public Egg(int type, Map m, int x, int y) {
		super(TIME, m, "egg");
		this.type=type;
		this.x=x;
		this.y=y;
	}
	public void step(ArrayList<Starter> a) {
		life--;
		if (life<=0) {
			alive=false;
			if(type==Starter.FEU) {
				a.add(new Salameche(x,y, m));
			}else if(type==Starter.EAU){
				
			}else if(type==Starter.HERBE) {
				
			}
		}
	}
	public int getType() {
		return type;
	}
}
