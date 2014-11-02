
public class Missile extends GameEntity {

	@Override
	protected EntityState createInitialState() {
		return new MissileAliveState();
	}

	@Override
	protected DrawStrategy createInitialStrategy() {
		return new DrawVectors();
	}
	
}
