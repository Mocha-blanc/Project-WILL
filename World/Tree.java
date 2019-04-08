

public class Tree {
	public final static int LIFE=10;
	
	private int x,y;

	private boolean burn;
	private boolean alive;
	private int life;


	public Tree(int x,int y){
		this.x=x;
		this.y=y;
		burn=false;
		alive=false;
		life=0;

	}
	public Tree(Tree t){
		this.x=t.x;
		this.y=t.y;
		this.burn=t.burn;
		this.alive=t.alive;
		this.life=t.life;
	}

	public void step(){
		if(life <= 0){
			burn=false;
			alive=false;
		
		}
		if(burn==true){
			life--;
		}
	}
	public void reset(){
		burn=false;
		alive=false;
		life=0;
	}

	public void burn(){
		burn=true;
	}
	public void rain() {
		burn=false;
	}
	public void alive(){
		life=LIFE;
		alive=true;
		burn=false;
	}
	//Set
	public void setAlive(boolean a){
		alive=a;
	}
	public void setBurn(boolean b){
		burn=b;
	}
	public void setLife(int l){
		life=l;
	}
	//Accesseur 

	public boolean isAlive(){
		return alive;
	}
	public boolean isBurn(){
		return burn;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getLife(){
		return life;
	}

}