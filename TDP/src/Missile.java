
public class Missile extends GameEntity {

	public Missile() {
		this.strategy = new DrawVectors();
		this.state = new MissileAliveState();
	}
	
}
