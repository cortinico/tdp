package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.graphics.GraphicEntity;
import it.ncorti.tdp.graphics.GraphicVector;

import java.util.ArrayList;
import java.util.List;


public class SpaceShipAliveState extends EntityState {

	@Override
	public boolean isDestroyed() {
		return false;
	}

	public void collide(GameEntity e, Collideable c) {
		SpaceShip ship = (SpaceShip) e;
		if (c instanceof Mine){
			ship.setState(new EntityDeadState());
		} else if (c instanceof SpaceShip) {
			ship.reverseDirection();
		} else if (c instanceof PowerBar) {
			ship.stop();
		} else if (c instanceof PlasmaBall){
			ship.setState(new EntityDeadState());
		}
	}

	@Override
	public List<GraphicEntity> getEntity() {
		List<GraphicEntity> spaceShipAliveVect = new ArrayList<>();
		spaceShipAliveVect.add(new GraphicVector("spaceShipAlive - 1"));
		spaceShipAliveVect.add(new GraphicVector("spaceShipAlive - 2"));
		spaceShipAliveVect.add(new GraphicVector("spaceShipAlive - 3"));
		spaceShipAliveVect.add(new GraphicVector("spaceShipAlive - 4"));
		spaceShipAliveVect.add(new GraphicVector("spaceShipAlive - 5"));
		
		return spaceShipAliveVect;
	}

}
