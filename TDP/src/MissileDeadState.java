import java.util.List;


public class MissileDeadState extends EntityState {

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<GraphicEntity> getEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		// TODO Auto-generated method stub

	}

}
