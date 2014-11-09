package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.graphics.GraphicEntity;
import it.ncorti.tdp.graphics.GraphicSprite;

import java.util.ArrayList;
import java.util.List;

/**
 * Stato che rappresenta un missile che e' vivo e puo' entrare in collisione con altre
 * entita'
 * 
 * @author Nicola Corti
 *
 */
public class MissileAliveState extends EntityState {

	/** Lista di sprite per animare il missile */
	private List<GraphicEntity> missileAliveSprites;

	/**
	 * Costruttore di base che istanzia la lista delle sprite del missile vivo
	 */
	public MissileAliveState() {
		missileAliveSprites = new ArrayList<>();
		missileAliveSprites.add(new GraphicSprite("missileAlive - 1"));
		missileAliveSprites.add(new GraphicSprite("missileAlive - 2"));
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
		return missileAliveSprites;
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.EntityState#collide(it.ncorti.tdp.core.entities.GameEntity, it.ncorti.tdp.core.entities.Collideable)
	 */
	@Override
	public void collide(GameEntity s, Collideable c) {
		
		// Evolvo se colpisco barre di energia, mine o cannoni
		if (c instanceof PowerBar || c instanceof Mine || c instanceof Cannon){
			s.setState(new EntityDeadState());
		}
	}

}
