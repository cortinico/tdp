public class PlasmaBall extends GameEntity {

	public PlasmaBall() {
		this.strategy = new DrawSprite();
		this.state = new PlasmaBallAliveState();
	}
}
