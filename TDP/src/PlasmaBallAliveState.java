import java.util.ArrayList;
import java.util.List;


public class PlasmaBallAliveState extends EntityState {

	private List<GraphicEntity> plasmaBallAliveSprites;

	public PlasmaBallAliveState() {
		plasmaBallAliveSprites = new ArrayList<>();
		plasmaBallAliveSprites.add(new GraphicSprite("plasmaBallAlive - 1"));
		plasmaBallAliveSprites.add(new GraphicSprite("plasmaBallAlive - 2"));
	}
	
	@Override
	public boolean isDestroyed() { return false; }

	@Override
	public List<GraphicEntity> getEntity() {

		return plasmaBallAliveSprites;
		
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		if (c instanceof PowerBar || c instanceof Mine || c instanceof Cannon){
			s.setState(new PlasmaBallDeadState());
		}
	}

}
