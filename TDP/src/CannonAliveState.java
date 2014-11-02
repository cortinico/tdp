import java.util.List;


public class CannonAliveState extends EntityState {

	@Override
	public boolean isDestroyed() { return false; }

	@Override
	public List<GraphicEntity> getEntity() {
		/*	Inserisci grafica del cannone
		 * 	da disegnare.
		 */
		return null;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		if (c instanceof Missile){
			s.setState(new CannonDeadState());
		}
	}

}
