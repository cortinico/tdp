import java.util.List;


public class MineAliveState extends EntityState {

	@Override
	public boolean isGameOver() {
		return false;
	}

	@Override
	public List<GraphicEntity> getEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		if (c instanceof SpaceShip || c instanceof Missile){
			s.setState(new MineDeadState());
		}

	}

}
