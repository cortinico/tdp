public class PlasmaBall extends GameEntity {

	@Override
	protected EntityState createInitialState() {
		return new PlasmaBallAliveState();
	}

	@Override
	protected DrawStrategy createInitialStrategy() {
		return new DrawSprite();
	}
}
