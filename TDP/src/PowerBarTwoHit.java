import java.util.List;


public class PowerBarTwoHit extends EntityState {

	@Override
	public boolean isDestroyed() { return false; }

	@Override
	public List<GraphicEntity> getEntity() { 
		return null;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		// TODO Ignora...non esiste
	}
}
