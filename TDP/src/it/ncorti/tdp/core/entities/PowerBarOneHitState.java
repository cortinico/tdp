package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.graphics.GraphicEntity;
import it.ncorti.tdp.graphics.GraphicVector;

import java.util.ArrayList;
import java.util.List;


public class PowerBarOneHitState extends EntityState {

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
			s.setState(new PowerBarOneHitState());
	}
}
