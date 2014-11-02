
public class Mine extends GameEntity {

	// TODO Da sistemare
	@SuppressWarnings("unused")
	private Follower followEngine;
	
	public Mine() {
		this.strategy = new DrawSprite();
		this.state = new MineAliveState();
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
