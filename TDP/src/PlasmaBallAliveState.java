import java.util.List;


public class PlasmaBallAliveState extends EntityState {

	@Override
	public boolean isDestroyed() { return false; }

	@Override
	public List<GraphicEntity> getEntity() {
		/*	Ritorno la sprite della plasma ball
		 */
		return null;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		if (c instanceof PowerBar || c instanceof Mine || c instanceof Cannon){
			s.setState(new PlasmaBallDeadState());
		}
	}

}
