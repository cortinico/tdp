import java.util.ArrayList;
import java.util.List;


public class PowerBarOneHit extends EntityState {

	@Override
	public boolean isDestroyed() { return false; }

	@Override
	public List<GraphicEntity> getEntity() {
		List<GraphicEntity> powerBarOneHitVect = new ArrayList<>();
		powerBarOneHitVect.add(new GraphicVector("powerBarOneHit - 1"));
		powerBarOneHitVect.add(new GraphicVector("powerBarOneHit - 2"));
		powerBarOneHitVect.add(new GraphicVector("powerBarOneHit - 3"));
		
		return powerBarOneHitVect;
		
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		if (c instanceof Missile)
			s.setState(new PowerBarOneHit());
	}
}
