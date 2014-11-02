import java.util.List;


public class SpaceShipAliveState extends EntityState {

	@Override
	public boolean isDestroyed() {
		return false;
	}

	public void collide(GameEntity e, Collideable c) {
		SpaceShip ship = (SpaceShip) e;
		if (c instanceof Mine){
			ship.setState(new SpaceShipDeadState());
		} else if (c instanceof SpaceShip) {
			ship.reverseDirection();
		} else if (c instanceof PowerBar) {
			ship.stop();
		} else if (c instanceof PlasmaBall){
			ship.setState(new SpaceShipDeadState());
		}
	}

	@Override
	public List<GraphicEntity> getEntity() {
		/*	Ritorna la grafica dell'astronave
		 * 	da disegnare
		 */
		return null;
	}

}
