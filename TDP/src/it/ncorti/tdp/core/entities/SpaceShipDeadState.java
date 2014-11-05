package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.graphics.GraphicEntity;
import it.ncorti.tdp.graphics.GraphicVector;

import java.util.ArrayList;
import java.util.List;


public class SpaceShipDeadState extends EntityState {

	@Override
	public boolean isDestroyed() {
		return true;
	}

	@Override
	public List<GraphicEntity> getEntity() {
		List<GraphicEntity> spaceShipDeadVect = new ArrayList<>();
		spaceShipDeadVect.add(new GraphicVector("spaceShipDead - 1"));
		spaceShipDeadVect.add(new GraphicVector("spaceShipDead - 2"));
		spaceShipDeadVect.add(new GraphicVector("spaceShipDead - 3"));
		spaceShipDeadVect.add(new GraphicVector("spaceShipDead - 4"));
		spaceShipDeadVect.add(new GraphicVector("spaceShipDead - 5"));
		
		return spaceShipDeadVect;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		// Ignora
	}
}
