package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.graphics.GraphicEntity;
import it.ncorti.tdp.graphics.GraphicVector;

import java.util.ArrayList;
import java.util.List;


public class CannonDeadState extends EntityState {

	@Override
	public boolean isDestroyed() { return true;	}

	@Override
	public List<GraphicEntity> getEntity() {
		/*	Inserire grafica del cannone 
		 *  che sta esplodendo.
		 */
		
		List<GraphicEntity> cannonDeadVect = new ArrayList<>();
		cannonDeadVect.add(new GraphicVector("cannonDead - 1"));
		cannonDeadVect.add(new GraphicVector("cannonDead - 2"));		
		return cannonDeadVect;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		// Ignora, gioco terminato.
	}

}
