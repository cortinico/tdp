public class PowerBar extends GameEntity implements Collideable{

	@Override
	protected EntityState createInitialState() {
		return new PowerBarNoHit();
	}

	@Override
	protected DrawStrategy createInitialStrategy() {
		return new DrawVectors();
	}
	
	@Override
	public BoundCircle getBoundCircle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void collideWith(Collideable c) {
		state.collide(this, c);
	}
}
