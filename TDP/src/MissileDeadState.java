import java.util.List;


public class MissileDeadState extends EntityState {

	@Override
	public boolean isDestroyed() { return true; }

	@Override
	public List<GraphicEntity> getEntity() {
		/*	Ritorno la grafica dell'esplosione
		 * 	del missile
		 */
		return null;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		// Ignoro e rimuovo il missile, tanto e' esploso
	}

}
