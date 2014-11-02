import java.util.Observer;

public class SpaceShip extends GameEntity {

	public static final int LEFT = 1;
	public static final int RIGHT = 2;
	
	public static final int MAX_SPEED = 10;

	private int speed;
	@SuppressWarnings("unused")
	private int angle;
	
	private DelegatedObservable obs;
		
	public SpaceShip(int x, int y, int angle){
		this.x = x;
		this.y = y;
		this.angle = angle;
		this.speed = 0;
		this.obs = new DelegatedObservable();
		this.strategy = new DrawVectors();
		this.state = new SpaceShipAliveState();
	}
	
	public void propel(){
		this.speed++;
		if (this.speed > MAX_SPEED) this.speed = MAX_SPEED;
		
		obs.setChanged();
		obs.notifyObservers(this);
	}
	
	public void rotate(int direction){
		if (direction == LEFT){
			// turn left
		} else if (direction == RIGHT) {
			// turn right
		}
		
		obs.setChanged();
		obs.notifyObservers(this);
	}
	
	public void addObserver(Observer o){
		obs.addObserver(o);
	}
	
	public void deleteObserver(Observer o){
		obs.deleteObserver(o);
	}
	
	public void reverseDirection() {
		this.angle += 180 % 360;
	}
	
	public void stop(){
		this.speed = 0;
	}
}