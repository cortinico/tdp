import java.util.List;


public class SpaceShipDeadState extends EntityState {

	@SuppressWarnings("unused")
	private Collideable collision;
	
	public SpaceShipDeadState(Collideable c) {
		this.collision = c;
	}
	
	@Override
	public boolean isDestroyed() {
		return true;
	}

	@Override
	public List<GraphicEntity> getEntity() {
		// TODO Explosion vector
		return null;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		// TODO Ignora
	}
}
