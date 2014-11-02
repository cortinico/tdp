import java.util.ArrayList;
import java.util.List;


public class MineDeadState extends EntityState {

	@Override
	public boolean isDestroyed() {
		return true;
	}

	@Override
	public List<GraphicEntity> getEntity() {
		/*	Ritorno la grafica della bomba che sta
		 * 	esplodendo
		 */
		return new ArrayList<GraphicEntity>();
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		// Ignora, la mina non esiste piu'
	}

}
