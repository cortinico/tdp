public class Cannon extends GameEntity {

	// Cannon orientation
	@SuppressWarnings("unused")
	private int angle = 0;
	
	public Cannon() {
		this.state = new CannonAliveState();
		this.strategy = new DrawVectors();
	}
}
