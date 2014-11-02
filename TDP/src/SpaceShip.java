import java.util.Observer;

public class SpaceShip extends GameEntity implements Collideable {

	public static final int SPACESHIP_LEFT = 1;
	public static final int SPACESHIP_RIGHT = 2;
	
	public static final int MAX_SPEED = 10;

	private int speed;
	private int angle;
	
	private DelegatedObservable obs;
		
	public SpaceShip(int x, int y, int angle){
		super(x, y);
		this.angle = angle;
		this.speed = 0;
		this.obs = new DelegatedObservable();
	}
	
	@Override
	protected EntityState createInitialState() {
		return new SpaceShipAliveState();
	}

	@Override
	protected DrawStrategy createInitialStrategy() {
		return new DrawVectors();
	}
	
	public void propel(){
		this.speed++;
		if (this.speed > MAX_SPEED) this.speed = MAX_SPEED;
		
		obs.setChanged();
		obs.notifyObservers(this);
	}
	
	public void rotate(int direction){
		if (direction == SPACESHIP_LEFT){
			// turn left
		} else if (direction == SPACESHIP_RIGHT) {
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
	
	public Missile shot(){
		return null;
	}
	
	@Override
	public BoundCircle getBoundCircle() {
		return new BoundCircle(getX(), y, CollisionMediator.BND_RADIUS);
	}

	@Override
	public void collideWith(Collideable c) {
		state.collide(this, c);
	}

	@Override
	public void evolveEntity() {
		physicMove(angle, speed);
		speed--;
	}
}