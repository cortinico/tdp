public class PlasmaBall extends GameEntity implements Collideable {

	private int angle;
	private static final int PLASMA_BALL_SPEED = 40;
	
	public PlasmaBall(int x, int y, int angle) {
		super(x, y);
		this.angle = angle;
	}

	@Override
	protected EntityState createInitialState() {
		return new PlasmaBallAliveState();
	}

	@Override
	protected DrawStrategy createInitialStrategy() {
		return new DrawSprite();
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
	public void evolveEntity() {
		physicMove(angle, PLASMA_BALL_SPEED);
	}
}