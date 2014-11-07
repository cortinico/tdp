package it.ncorti.tdp.user;

import it.ncorti.tdp.core.GameDisplay;
import it.ncorti.tdp.core.entities.SpaceShip;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Classe che si occupa di gestire gli eventi della tastiera e di trasformarli in {@link Command}
 * 
 * @author Nicola Corti
 */
public class KeyEventManager implements KeyListener {

	/** TAG per le stampe di debug */
	private static final String TAG = "%%%%% KeyEvent";

	/** Riferimento al videogioco */
	private GameDisplay display;

	/** Comando per ruotare a sinistra */
	private Command rotateLeft;
	/** Comando per ruotare a destra */
	private Command rotateRight;
	/** Comando per accelerare */
	private Command propelOn;
	/** Comando per sparare */
	private Command fireOff;

	/** carattere tasto left */
	char left;
	/** carattere tasto right */
	char right;
	/** carattere tasto propel */
	char propel;
	/** carattere tasto fire */
	char fire;

	/**
	 * Costruttore per creare un nuovo KeyEventManager per un nuovo giocatore
	 * 
	 * @param display Riferimento al videogioco
	 * @param owner Riferimento all'astronave del giocatore
	 * @param left Carattere tasto left
	 * @param right Carattere tasto right
	 * @param propel Carattere tasto propel
	 * @param fire Carattere tasto fire
	 */
	public KeyEventManager(GameDisplay display, SpaceShip owner, char left, char right, char propel, char fire) {
		this.display = display;

		this.left = left;
		this.right = right;
		this.propel = propel;
		this.fire = fire;

		rotateLeft = new CommandRotate(owner, SpaceShip.SPACESHIP_LEFT);
		rotateRight = new CommandRotate(owner, SpaceShip.SPACESHIP_RIGHT);
		propelOn = new CommandPropel(owner);
		fireOff = new CommandFire(owner);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent) */
	@Override
	public void keyPressed(KeyEvent arg0) {
		Command toSend = null;
		if (arg0.getKeyChar() == left) {
			toSend = rotateLeft;
			Log.e(TAG, "PRESSED: ROTATE LEFT");
		} else if (arg0.getKeyChar() == right) {
			toSend = rotateRight;
			Log.e(TAG, "PRESSED: ROTATE RIGHT");
		} else if (arg0.getKeyChar() == propel) {
			toSend = propelOn;
			Log.e(TAG, "PRESSED: PROPEL");
		} else if (arg0.getKeyChar() == fire) {
			toSend = fireOff;
			Log.e(TAG, "PRESSED: FIRE");
		}

		if (toSend != null) display.sendCommand(toSend);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent) */
	public void keyReleased(KeyEvent arg0) {}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent) */
	public void keyTyped(KeyEvent arg0) {}

}
