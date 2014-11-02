public class PowerBar extends GameEntity implements Collideable{

	public PowerBar() {
		this.strategy = new DrawVectors();
		this.state = new PowerBarNoHit();
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
