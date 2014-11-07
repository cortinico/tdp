package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.graphics.GraphicEntity;
import it.ncorti.tdp.graphics.GraphicSprite;

import java.util.ArrayList;
import java.util.List;

/**
 * Stato che rappresenta una mina che e' viva e sta inseguendo una navicella
 * 
 * @author Nicola Corti
 *
 */
public class MineAliveState extends EntityState {

	/** Lista di sprite per animare la mina */
	private List<GraphicEntity> mineAliveSprites;

	/**
	 * Costruttore di base che istanzia la lista delle sprite della mina viva
	 */
	public MineAliveState() {
		mineAliveSprites = new ArrayList<>();
		mineAliveSprites.add(new GraphicSprite("mineAlive - 1"));
		mineAliveSprites.add(new GraphicSprite("mineAlive - 2"));
	}
	
	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.EntityState#isDestroyed()
	 */
	@Override
	public boolean isDestroyed() {
		return false;
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.EntityState#getEntity()
	 */
	@Override
	public List<GraphicEntity> getEntity() {		
		return mineAliveSprites;
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.EntityState#collide(it.ncorti.tdp.core.entities.GameEntity, it.ncorti.tdp.core.entities.Collideable)
	 */
	@Override
	public void collide(GameEntity s, Collideable c) {
		
		// Se collido con Astronave o Missile allora evolvo lo stato
		if (c instanceof SpaceShip || c instanceof Missile){
			s.setState(new EntityDeadState());
		}
	}

}
