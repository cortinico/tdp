import java.util.List;


public class SpaceShipDeadState extends EntityState {

	@Override
	public boolean isDestroyed() {
		return true;
	}

	@Override
	public List<GraphicEntity> getEntity() {
		/*	Ritorna la grafica dell'astronave
		 * 	che sta esplodendo.
		 */
		return null;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		// Ignora
	}
}
