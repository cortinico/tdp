public class Cannon extends GameEntity {

	// Cannon orientation
	private int angle = 0;
	
	@Override
	protected EntityState createInitialState() {
		return new CannonAliveState();
	}

	@Override
	protected DrawStrategy createInitialStrategy() {
		return new DrawVectors();
	}
}
