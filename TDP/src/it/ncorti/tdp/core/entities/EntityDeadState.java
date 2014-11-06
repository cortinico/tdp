package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.graphics.GraphicEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Stato che rappresenta una entita' che e' entrata in collisione ed e' da considerarsi morta
 * 
 * @author nicola
 *
 */
public class EntityDeadState extends EntityState {

	public EntityDeadState() { }
	
	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.EntityState#isDestroyed()
	 */
	@Override
	public boolean isDestroyed() {
		return true;
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.EntityState#getEntity()
	 */
	@Override
	public List<GraphicEntity> getEntity() {

		// Ritorno una lista di primitive vuota
		return new ArrayList<GraphicEntity>();
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.EntityState#collide(it.ncorti.tdp.core.entities.GameEntity, it.ncorti.tdp.core.entities.Collideable)
	 */
	@Override
	public void collide(GameEntity s, Collideable c) {
		// Ignora, l'entita non esiste piu'
	}

}
