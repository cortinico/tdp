package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.graphics.DrawStrategy;
import it.ncorti.tdp.graphics.DrawVectors;
import it.ncorti.tdp.user.Log;

import java.util.Observer;

/**
 * Classe che rappresenta un'astronave comandata da un utente,
 * che puo' sparare Missili e che puo' entrare in collisione con altre entita'
 * e quindi morire
 * 
 * @author nicola
 *
 */
public class SpaceShip extends GameEntity implements Collideable {

	/** TAG per le stampe di debug */
	private static final String TAG = "&&&&& SpaceShip";
	
	/** Costante per indicare lo spostamento verso sinistra */
	public static final int SPACESHIP_LEFT = 1;
	/** Costante per indicare lo spostamento verso destra */
	public static final int SPACESHIP_RIGHT = 2;
	
	/** Costante che indica la velocita' massima raggiungibile dall'astronave */
	public static final int MAX_SPEED = 10;

	/** Velocita' a cui sta andando l'astronave */
	private int speed;
	/** Angolo di direzione */
	private int angle;
	
	/** Oggetto observable a cui si registrano le mine e il cannone */
	private DelegatedObservable obs;
		
	/**
	 * Costruttore base per creare una nuova astronave
	 * 
	 * @param x Coordinata x dell'astronave
	 * @param y Coordinata y dell'astronave
	 * @param angle Angolo di rotazione
	 */
	public SpaceShip(int x, int y, int angle){
		super(x, y);
		this.angle = angle;
		this.speed = 0;
		this.obs = new DelegatedObservable();
	}
	
	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.GameEntity#createInitialState()
	 */
	@Override
	protected EntityState createInitialState() {
		return new SpaceShipAliveState();
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
		physicMove(angle, speed);
		
		// Decrementa la velocita' ad ogni istante
		speed--;
	}

	/**
	 * Metodo che registra un observer presso la spaceship.
	 * 
	 * @param o Observer da registrare
	 */
	public void addObserver(Observer o){
		obs.addObserver(o);
		Log.e(TAG, "New Observer registered");
	}

	/**
	 * Metodo che registra un observer presso la spaceship.
	 * 
	 * @param o Observer da registrare
	 */
	public void deleteObserver(Observer o){
		obs.deleteObserver(o);
		Log.e(TAG, "Observer unregistered");
	}

	/**
	 * Funzione che permette di far accelerare la navicella
	 * 
	 * NOTA: notifica a tutti gli observer un cambiamento di stato
	 */
	public void propel(){
		this.speed++;
		if (this.speed > MAX_SPEED) this.speed = MAX_SPEED;
		
		obs.setChanged();
		obs.notifyObservers(this);
	}

	/**
	 * Funzione che permette di far ruotare la navicella
	 * 
	 * NOTA: notifica a tutti gli observer un cambiamento di stato
	 * @param direction Direzione di rotazione (SPACESHIP_LEFT o SPACESHIP_RIGHT)
	 */
	public void rotate(int direction){
		if (direction == SPACESHIP_LEFT){
			this.angle += 1 % 360;
		} else if (direction == SPACESHIP_RIGHT) {
			this.angle--;
			if (this.angle < 0) this.angle = 360;
		}
		
		obs.setChanged();
		obs.notifyObservers(this);
	}
	
	/**
	 * Funzione che permette di far fermare la navicella (per collisioni o altro)
	 */
	public void stop(){
		this.speed = 0;
	}

	/**
	 * Funzione che permette di far sparare la navicella
	 * 
	 * NOTA: notifica a tutti gli observer un cambiamento di stato
	 * @return Il riferimento al missile appena sparato
	 */
	public Missile shot(){
		Missile justShooted = new Missile(getX(), getY(), angle);
		Log.e(TAG, "I shooted a Missile! " + justShooted + " - Me " + toString());
		
		obs.setChanged();
		obs.notifyObservers(this);
		return justShooted;
	}

	/**
	 * Funzione che permette di far ruotare la navicella di 180' (per collisioni o altro)
	 */
	public void reverse() {
		this.angle += 180 % 360;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SPACESHIP x:" + getX() + " y:" + getY() + " angle: " + this.angle + " speed:" + this.speed;
	}
}