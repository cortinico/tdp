import java.util.List;


public class MineAliveState extends EntityState {

	@Override
	public boolean isDestroyed() {
		return false;
	}

	@Override
	public List<GraphicEntity> getEntity() {
		/*	Inserisci sprites della mina
		 * 	da disegnare
		 */
		return null;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		if (c instanceof SpaceShip || c instanceof Missile){
			s.setState(new MineDeadState());
		}
	}

}
