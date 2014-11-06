package it.ncorti.tdp.core.entities;

import it.ncorti.tdp.graphics.DrawStrategy;
import it.ncorti.tdp.graphics.DrawVectors;

/**
 * Classe che rappresenta la barra di energia che protegge il cannone
 * 
 * @author nicola
 */
public class PowerBar extends GameEntity implements Collideable{

	/** Angolo di rotazione */
	private int angle;
	/** Coefficiente di rotazione ad ogni ciclo di esecuzione */
	private static final int ROTATION_ANGLE = 10;
	
	/**
	 * Costruttore di base che crea una nuova barra
	 * 
	 * @param x Coordinata x della barra
	 * @param y Coordinata y della barra
	 * @param angle Angolo di sparo
	 */
	public PowerBar(int x, int y, int angle) {
		super(x, y);
		this.angle = angle;
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.GameEntity#createInitialState()
	 */
	@Override
	protected EntityState createInitialState() {
		return new PowerBarNoHitState();
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.GameEntity#createInitialStrategy()
	 */
	@Override
	protected DrawStrategy createInitialStrategy() {
		return new DrawVectors();
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
		angle += ROTATION_ANGLE % 360;
	}
	
	/**
	 * Ritorna l'angolo di rotazione
	 * 
	 * @return L'angolo di rotazione della barra
	 */
	public int getAngle(){
		return this.angle;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "POWER BAR x:" + getX() + " y:" + getY() + " angle: " + this.angle;
	}
}
