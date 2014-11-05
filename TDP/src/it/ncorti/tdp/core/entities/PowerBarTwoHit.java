package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.graphics.GraphicEntity;
import it.ncorti.tdp.graphics.GraphicVector;

import java.util.ArrayList;
import java.util.List;


public class PowerBarTwoHit extends EntityState {

	@Override
	public boolean isDestroyed() { return false; }

	@Override
	public List<GraphicEntity> getEntity() {
		List<GraphicEntity> powerBarTwoHitVect = new ArrayList<>();
		powerBarTwoHitVect.add(new GraphicVector("powerBarTwoHit - 1"));
		powerBarTwoHitVect.add(new GraphicVector("powerBarTwoHit - 2"));
		powerBarTwoHitVect.add(new GraphicVector("powerBarTwoHit - 3"));
		
		return powerBarTwoHitVect;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		// Ignora
	}
}
