import java.util.ArrayList;
import java.util.List;


public class PowerBarNoHit extends EntityState {

	@Override
	public boolean isDestroyed() { return false; }

	@Override
	public List<GraphicEntity> getEntity() {
		List<GraphicEntity> powerBarNoHitVect = new ArrayList<>();
		powerBarNoHitVect.add(new GraphicVector("powerBarNoHit - 1"));
		powerBarNoHitVect.add(new GraphicVector("powerBarNoHit - 2"));
		powerBarNoHitVect.add(new GraphicVector("powerBarNoHit - 3"));
		
		return powerBarNoHitVect;
		
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		if (c instanceof Missile)
			s.setState(new PowerBarOneHit());
	}
}
