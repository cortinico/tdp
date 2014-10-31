import java.util.Observer;

@SuppressWarnings("unused")
public class SpaceShip implements Drawable{

	public static final int LEFT = 1;
	public static final int RIGHT = 2;
	
	// Spaceship coordinates
	private int x;
	private int y;
	private int angle;
	
	private DelegatedObservable obs;
	
	public SpaceShip(int x, int y, int angle){
		this.x = x;
		this.y = y;
		this.angle = angle;
		this.obs = new DelegatedObservable();
	}
	
	public void propel(){
		/*
		 * Propel the spaceship on
		 */
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

	@Override
	public void draw(GraphicsEnvironment g) {
		// TODO Auto-generated method stub
		
	}
}
