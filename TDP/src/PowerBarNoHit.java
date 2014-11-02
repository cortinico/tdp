import java.util.List;


public class PowerBarNoHit extends EntityState {

	@Override
	public boolean isDestroyed() { return false; }

	@Override
	public List<GraphicEntity> getEntity() {
		// Ritorna la grafica della power bar
		return null;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		if (c instanceof Missile)
			s.setState(new PowerBarOneHit());
	}
}
