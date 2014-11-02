
public class Mine extends GameEntity {

	// TODO Da sistemare
	@SuppressWarnings("unused")
	private Follower followEngine;
	
	@Override
	protected EntityState createInitialState() {
		return new MineAliveState();
	}

	@Override
	protected DrawStrategy createInitialStrategy() {
		return new DrawSprite();
	}
	
//	@Override
//	public SpaceShip computeWhichFollow() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public void followTarget(SpaceShip s) {
//		// TODO Auto-generated method stub
//		
//	}

}
