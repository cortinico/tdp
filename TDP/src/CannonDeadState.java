import java.util.List;


public class CannonDeadState extends EntityState {

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<GraphicEntity> getEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		// TODO Ignora

	}

}
