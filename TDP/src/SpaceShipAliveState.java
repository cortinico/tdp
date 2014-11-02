import java.util.List;


public class SpaceShipAliveState extends EntityState {

	@Override
	public boolean isGameOver() {
		return false;
	}

	public void collide(GameEntity e, Collideable c) {
		SpaceShip ship = (SpaceShip) e;
		if (c instanceof Mine){
			ship.setState(new SpaceShipDeadState(c));
		} else if (c instanceof SpaceShip) {
			ship.reverseDirection();
		} else if (c instanceof PowerBar) {
			ship.stop();
		} else if (c instanceof PlasmaBall){
			ship.setState(new SpaceShipDeadState(c));
		}
	}

	@Override
	public List<GraphicEntity> getEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
