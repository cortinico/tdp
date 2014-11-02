import java.util.List;


public class PlasmaBallSilentState extends EntityState {

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
		if (c instanceof PowerBar || c instanceof Mine || c instanceof Cannon){
			s.setState(new PlasmaBallDeadState());
		}

	}

}