import java.util.Observable;
import java.util.Observer;

public class Cannon extends GameEntity implements Collideable, Observer {

	// Cannon orientation
	private int angle = 0;
	private SpaceShip following;
		
	public Cannon(int x, int y) {
		super(x, y);
		following = null;
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
			else
				angle--;
		}
	}
}
