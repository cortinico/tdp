
public class Missile extends GameEntity implements Collideable {

	private int angle;
	private static final int MISSILE_SPEED = 20;
	
	public Missile(int x, int y, int angle) {
		super(x, y);
		this.angle = angle;
	}

	@Override
	protected EntityState createInitialState() {
		return new MissileAliveState();
	}

	@Override
	protected DrawStrategy createInitialStrategy() {
		return new DrawSprite();
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
		physicMove(angle, MISSILE_SPEED);
	}
	
	@Override
	public String toString() {
		return "MISSILE x:" + this.x + " y:" + this.y + " angle: " + this.angle;
	}
	
}
