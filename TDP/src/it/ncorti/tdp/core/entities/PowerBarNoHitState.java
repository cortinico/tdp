package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.graphics.GraphicEntity;
import it.ncorti.tdp.graphics.GraphicVector;

import java.util.ArrayList;
import java.util.List;

/**
 * Stato che rappresenta la power bar che sta ruotando e non ha ancora subito nessun colpo
 * 
 * @author Nicola Corti
 *
 */
public class PowerBarNoHitState extends EntityState {

	/** Lista di vettori grafici per disegnare la barra */
	private List<GraphicEntity> powerBarNoHitVect;
	
	/**
	 * Costruttore di base per creare un nuovo stato per la barra senza colpi subiti
	 */
	public PowerBarNoHitState() {
		powerBarNoHitVect = new ArrayList<>();
		powerBarNoHitVect.add(new GraphicVector("powerBarNoHit - 1"));
		powerBarNoHitVect.add(new GraphicVector("powerBarNoHit - 2"));
		powerBarNoHitVect.add(new GraphicVector("powerBarNoHit - 3"));
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
		return powerBarNoHitVect;
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.EntityState#collide(it.ncorti.tdp.core.entities.GameEntity, it.ncorti.tdp.core.entities.Collideable)
	 */
	@Override
	public void collide(GameEntity s, Collideable c) {
		
		// Se collide con un missile, evolve
		if (c instanceof Missile)
			s.setState(new PowerBarOneHitState());
	}
}
