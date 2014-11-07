package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.graphics.GraphicEntity;
import it.ncorti.tdp.graphics.GraphicSprite;

import java.util.ArrayList;
import java.util.List;


/**
 * Stato che rappresenta una plasma ball che e' stata sparata e puo' entrare in collisione
 * 
 * @author Nicola Corti
 *
 */
public class PlasmaBallAliveState extends EntityState {

	/** Lista di sprite per animare la plasmaball */
	private List<GraphicEntity> plasmaBallAliveSprites;

	/**
	 * Costruttore di base che istanzia la lista delle sprite della plasmaball
	 */
	public PlasmaBallAliveState() {
		plasmaBallAliveSprites = new ArrayList<>();
		plasmaBallAliveSprites.add(new GraphicSprite("plasmaBallAlive - 1"));
		plasmaBallAliveSprites.add(new GraphicSprite("plasmaBallAlive - 2"));
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
		return plasmaBallAliveSprites;
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.EntityState#collide(it.ncorti.tdp.core.entities.GameEntity, it.ncorti.tdp.core.entities.Collideable)
	 */
	@Override
	public void collide(GameEntity s, Collideable c) {
		if (c instanceof PowerBar || c instanceof Mine || c instanceof Cannon){
			s.setState(new EntityDeadState());
		}
	}

}
