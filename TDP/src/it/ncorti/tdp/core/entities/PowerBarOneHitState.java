package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.graphics.GraphicEntity;
import it.ncorti.tdp.graphics.GraphicVector;

import java.util.ArrayList;
import java.util.List;


/**
 * Stato che rappresenta la power bar che sta ruotando e ha ancora subito un colpo
 * 
 * @author nicola
 *
 */
public class PowerBarOneHitState extends EntityState {

	/** Lista di vettori grafici per disegnare la barra */
	private List<GraphicEntity> powerBarOneHitVect;

	/**
	 * Costruttore di base per creare un nuovo stato per la barra con un colpo subito
	 */
	public PowerBarOneHitState() {
		powerBarOneHitVect = new ArrayList<>();
		powerBarOneHitVect.add(new GraphicVector("powerBarOneHit - 1"));
		powerBarOneHitVect.add(new GraphicVector("powerBarOneHit - 2"));
		powerBarOneHitVect.add(new GraphicVector("powerBarOneHit - 3"));
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
	public List<GraphicEntity> getEntity() {
		
		return powerBarOneHitVect;
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.EntityState#collide(it.ncorti.tdp.core.entities.GameEntity, it.ncorti.tdp.core.entities.Collideable)
	 */
	@Override
	public void collide(GameEntity s, Collideable c) {
		
		// Se vengo colpito nuovamente muoio
		if (c instanceof Missile)
			s.setState(new EntityDeadState());
	}
}
