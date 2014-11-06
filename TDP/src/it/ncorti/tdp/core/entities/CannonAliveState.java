package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.graphics.GraphicEntity;
import it.ncorti.tdp.graphics.GraphicVector;

import java.util.ArrayList;
import java.util.List;


public class CannonAliveState extends EntityState {

	@Override
	public boolean isDestroyed() { return false; }

	@Override
	public List<GraphicEntity> getEntity() {
		/*	Inserisci grafica del cannone
		 * 	da disegnare.
		 */
		
		List<GraphicEntity> cannonAliveVect = new ArrayList<>();
		cannonAliveVect.add(new GraphicVector("cannonAlive - 1"));
		cannonAliveVect.add(new GraphicVector("cannonAlive - 2"));
		cannonAliveVect.add(new GraphicVector("cannonAlive - 3"));
		
		return cannonAliveVect;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		if (c instanceof Missile){
			s.setState(new EntityDeadState());
		}
	}

}
