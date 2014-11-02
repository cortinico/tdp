import java.util.List;


public class CannonDeadState extends EntityState {

	@Override
	public boolean isDestroyed() { return true;	}

	@Override
	public List<GraphicEntity> getEntity() {
		/*	Inserire grafica del cannone 
		 *  che sta esplodendo.
		 */
		return null;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		// Ignora, gioco terminato.
	}

}
