package it.ncorti.tdp.core.entities;

import it.ncorti.tdp.graphics.DrawSprite;
import it.ncorti.tdp.graphics.DrawStrategy;
import it.ncorti.tdp.user.Log;

import java.util.Observable;
import java.util.Observer;

/**
 * Classe che rappresenta una mina lanciata dal cannone e che insegue le navicelle spaziali
 * 
 * @author nicola
 */
public class Mine extends GameEntity implements Collideable, Observer {

	/** TAG per le stampe di debug */
	private static final String TAG = "MMMMM Mine";

	/** Angolo attuale di direzione */
	private int angle = 0;

	/** Ultima navicella che si sta seguendo */
	private SpaceShip following = null;

	/** Costante che rappresenta la velocita' di default delle mine */
	private static final int MINE_SPEED = 5;

	/**
	 * Costruttore di base che crea una nuova mina
	 * 
	 * @param x Coordinata della mina x
	 * @param y Coordinata della mina y
	 */
	public Mine(int x, int y) {
		super(x, y);
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.GameEntity#createInitialState() */
	@Override
	protected EntityState createInitialState() {
		return new MineAliveState();
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.GameEntity#createInitialStrategy() */
	@Override
	protected DrawStrategy createInitialStrategy() {
		return new DrawSprite();
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.Collideable#getBoundCircle() */
	@Override
	public BoundCircle getBoundCircle() {
		return new BoundCircle(getX(), getY(), CollisionMediator.BND_RADIUS);
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.Collideable#collideWith(it.ncorti.tdp.core.entities.Collideable) */
	@Override
	public void collideWith(Collideable c) {
		this.state.collide(this, c);
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object) */
	@Override
	public void update(Observable arg0, Object arg1) {

		// Aggiorno il riferimento a chi sto seguendo con l'ultima navicella che mi ha notificato
		if (arg1 instanceof SpaceShip) {
			this.following = (SpaceShip) arg1;
			Log.e(TAG, "Notify received - Following " + this.following + " - ME: " + toString());
		}
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.GameEntity#evolveEntity() */
	@Override
	public void evolveEntity() {
		if (this.following != null) {

			// TODO Questa formula va corretta
			angle = (this.x - following.getX()) / (this.y - following.getY());
			physicMove(angle, MINE_SPEED);
		}
	}

	@Override
	public String toString() {
		return "MINE x:" + getX() + " y:" + getY() + " angle: " + this.angle;
	}
}
