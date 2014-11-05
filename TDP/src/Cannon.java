import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Cannon extends GameEntity implements Collideable, Observer {

	private int angle = 0;
	private SpaceShip following;

	private final static int POWER_BAR_SIZE = 10;
	private final static int POWER_BAR_SPACE = 5;
	
	List<PowerBar> firstRing, secondRing, thirdRing;
		
	public Cannon(int x, int y) {
		super(x, y);
		following = null;
		firstRing = secondRing = thirdRing = new ArrayList<>(POWER_BAR_SIZE);
		
		int relativeAngle = 360 / POWER_BAR_SIZE;
		
		for(int i = 0; i < POWER_BAR_SIZE; i++){
			firstRing.add(new PowerBar(x+POWER_BAR_SPACE, y, relativeAngle * i));
			secondRing.add(new PowerBar(x+(POWER_BAR_SPACE*2), y, relativeAngle * i));
			thirdRing.add(new PowerBar(x+(POWER_BAR_SPACE*3), y, relativeAngle * i));
		}
			
	}
	
	@Override
	protected EntityState createInitialState() {
		return new CannonAliveState();
	}

	@Override
	protected DrawStrategy createInitialStrategy() {
		return new DrawVectors();
	}

	@Override
	public BoundCircle getBoundCircle() {
		return new BoundCircle(x, y, CollisionMediator.BND_RADIUS);
	}

	@Override
	public void collideWith(Collideable c) {
		state.collide(this, c);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof SpaceShip)
			this.following = (SpaceShip) arg1;
	}

	@Override
	public void evolveEntity() {
		if (this.following != null){
			int followingAngle = (this.x -following.getX())/(this.y - following.getY());
			if (followingAngle > angle)
				angle++;
			else if (followingAngle < angle)
				angle--;
			else {
				// Cannon aligned
				if (checkPowerBars()){
					firePlasmaBall();
				}
			}
		}
	}

	private void firePlasmaBall() {
		PlasmaBall ball = new PlasmaBall(x, y, angle);
		GameEnvironment.getInstance().addEntity(ball);
	}

	private boolean checkPowerBars() {
		/*	Metodo per controllare se c'e' spazio
		 * 	fra gli anelli e quindi sparare.
		 */
		return false;
	}
	
	@Override
	public String toString() {
		return "CANNON x:" + this.x + " y:" + this.y + " angle: " + this.angle;
	}
}
