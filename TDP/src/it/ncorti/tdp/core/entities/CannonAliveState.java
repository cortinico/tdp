package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.graphics.GraphicEntity;
import it.ncorti.tdp.graphics.GraphicVector;

import java.util.ArrayList;
import java.util.List;

/**
 * Stato che rappresenta il cannone nemico che e' vivo e pronto a sparare
 * 
 * @author Nicola Corti
 *
 */
public class CannonAliveState extends EntityState {

	/** Lista di vettori per disegnare un cannone */
	private List<GraphicEntity> cannonAliveVect;

	/**
	 *  Costruttore base del cannone
	 */
	public CannonAliveState() {
		cannonAliveVect = new ArrayList<>();
		cannonAliveVect.add(new GraphicVector("cannonAlive - 1"));
		cannonAliveVect.add(new GraphicVector("cannonAlive - 2"));
		cannonAliveVect.add(new GraphicVector("cannonAlive - 3"));
	}
	
	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.EntityState#isDestroyed()
	 */
	@Override
	public boolean isDestroyed() { return false; }

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.EntityState#getEntity()
	 */
	@Override
	public List<GraphicEntity> getGraphicEntities() {
		return cannonAliveVect;
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.EntityState#collide(it.ncorti.tdp.core.entities.GameEntity, it.ncorti.tdp.core.entities.Collideable)
	 */
	@Override
	public void collide(GameEntity s, Collideable c) {
		
		// Se mi ha colpito un missile, muoio
		if (c instanceof Missile){
			s.setState(new EntityDeadState());
		}
	}

}
