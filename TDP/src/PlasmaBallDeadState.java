import java.util.List;


public class PlasmaBallDeadState extends EntityState {

	@Override
	public boolean isDestroyed() { return true; }

	@Override
	public List<GraphicEntity> getEntity() {
		// Ritorno la sprite della plasma ball che sta esplodendo
		return null;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		// Ignora
	}

}
