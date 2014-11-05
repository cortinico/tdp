import java.util.ArrayList;
import java.util.List;


public class MissileAliveState extends EntityState {

	private List<GraphicEntity> missileAliveSprites;

	public MissileAliveState() {
		missileAliveSprites = new ArrayList<>();
		missileAliveSprites.add(new GraphicSprite("missileAlive - 1"));
		missileAliveSprites.add(new GraphicSprite("missileAlive - 2"));
	}
	
	@Override
	public boolean isDestroyed() { return false; }

	@Override
	public List<GraphicEntity> getEntity() {
		return missileAliveSprites;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		if (c instanceof PowerBar || c instanceof Mine || c instanceof Cannon){
			s.setState(new MissileDeadState());
		}
	}

}
