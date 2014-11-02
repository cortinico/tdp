import java.util.List;


public class PowerBarTwoHit extends EntityState {

	@Override
	public boolean isDestroyed() { return false; }

	@Override
	public List<GraphicEntity> getEntity() {
		/*	Ritorna la grafica dell'esplosione
		 * 	della barra energetica 
		 */
		return null;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		// Ignora
	}
}
