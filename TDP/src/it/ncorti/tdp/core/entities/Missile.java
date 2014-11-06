package it.ncorti.tdp.core.entities;

import it.ncorti.tdp.graphics.DrawSprite;
import it.ncorti.tdp.graphics.DrawStrategy;

/**
 * Classe che rappresenta un missile lanciato dalla navicella per permettere
 * di uccidere un'altra entita'
 * 
 * @author nicola
 */
public class Missile extends GameEntity implements Collideable {

	
	/** Angolo attuale di direzione */
	private int angle;
	
	/** Costante che rappresenta la velocita' di default delle mine */
	private static final int MISSILE_SPEED = 20;
	
	/**
	 * Costruttore di base che crea un nuovo missile
	 * 
	 * @param x Coordinata x del missile
	 * @param y Coordinata y del missile
	 * @param angle Angolo di sparo
	 */
	public Missile(int x, int y, int angle) {
		super(x, y);
		this.angle = angle;
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.GameEntity#createInitialState()
	 */
	@Override
	protected EntityState createInitialState() {
		return new MissileAliveState();
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
		return new BoundCircle(getX(), getY(), CollisionMediator.BND_RADIUS);
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
		// Faccio procedere il missile per la propria velocita'
		physicMove(angle, MISSILE_SPEED);
	}
	
	@Override
	public String toString() {
		return "MISSILE x:" + getX() + " y:" + getY() + " angle: " + this.angle;
	}
	
}