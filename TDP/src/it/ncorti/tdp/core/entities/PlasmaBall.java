package it.ncorti.tdp.core.entities;

import it.ncorti.tdp.graphics.DrawSprite;
import it.ncorti.tdp.graphics.DrawStrategy;

/**
 * Classe che rappresenta una sfera di plasma sparata dal cannone per uccidere un'astronave
 * 
 * @author nicola
 *
 */
public class PlasmaBall extends GameEntity implements Collideable {

	/** Angolo di lancio */
	private int angle;
	
	/** Velocita' di default della plasma ball */
	private static final int PLASMA_BALL_SPEED = 40;
	
	/**
	 * Costruttore di base che crea una nuova plasmaball
	 * 
	 * @param x Coordinata x della plasmaball
	 * @param y Coordinata y della plasmaball
	 * @param angle Angolo di sparo
	 */
	public PlasmaBall(int x, int y, int angle) {
		super(x, y);
		this.angle = angle;
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.GameEntity#createInitialState()
	 */
	@Override
	protected EntityState createInitialState() {
		return new PlasmaBallAliveState();
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.GameEntity#createInitialStrategy()
	 */
	@Override
	protected DrawStrategy createInitialStrategy() {
		return new DrawSprite();
	}
	
	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.Collideable#getBoundCircle()
	 */
	@Override
	public BoundCircle getBoundCircle() {
		return new BoundCircle(x, y, CollisionMediator.BND_RADIUS);
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.Collideable#collideWith(it.ncorti.tdp.core.entities.Collideable)
	 */
	@Override
	public void collideWith(Collideable c) {
		state.collide(this, c);
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.GameEntity#evolveEntity()
	 */
	@Override
	public void evolveEntity() {
		physicMove(angle, PLASMA_BALL_SPEED);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PLASMA x:" + getX() + " y:" + getY() + " angle: " + this.angle;
	}
}
