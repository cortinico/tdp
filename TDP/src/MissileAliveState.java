import java.util.List;


public class MissileAliveState extends EntityState {

	@Override
	public boolean isDestroyed() { return false; }

	@Override
	public List<GraphicEntity> getEntity() {
		/*	Ritorna la grafica del missile
		 * 	sparato da disegnare
		 */
		return null;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		if (c instanceof PowerBar || c instanceof Mine || c instanceof Cannon){
			s.setState(new MissileDeadState());
		}
	}

}
