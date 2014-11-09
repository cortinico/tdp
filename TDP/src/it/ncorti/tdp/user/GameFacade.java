package it.ncorti.tdp.user;
import it.ncorti.tdp.core.GameDisplay;
import it.ncorti.tdp.core.GameEngine;
import it.ncorti.tdp.core.WindowDecorator;
import it.ncorti.tdp.core.entities.SpaceShip;
import it.ncorti.tdp.graphics.GraphicEnvironment;
import it.ncorti.tdp.user.rmi.RemoteGame;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 * Classe facade per gestire in modo semplificato l'avvio e lo stop
 * del videogioco
 * 
 * @author Nicola Corti
 */
public class GameFacade extends UnicastRemoteObject implements RemoteGame {
	
	/** UID per la serializzazione */
	private static final long serialVersionUID = 1L;
	
	/** TAG per le stampe di debug */
	private static final String TAG = "§§§§§ Façade";

	/** Riferimento al videogioco */
	private GameDisplay gameDisp;
	
	/** Riferimento all'ambiente di gioco (stato) */
	private GameEngine gameEng;
	/** Riferimento alla finestra */
	private WindowDecorator gameDecorator;
	
	/** Flag che indica se è stata impostata la modalità window */
	private boolean flagWindowed = false;
	
	/** Hashmap che mantiene i riferimenti alle astronavi dei giocatori */
	private HashMap<Double, SpaceShip> players;
	
	
	/** Costruttore base che crea un nuovo GameFacade senza finestra
	 * @throws RemoteException Se c'è stato un problema con il proxy
	 */
	public GameFacade() throws RemoteException {
		this(false);
	}
	
	/** Costruttore base che crea un nuovo GameFacade
	 * @param windowed Indica se si desidera la finestra o meno
	 * @throws RemoteException Se c'è stato un problema con il proxy
	 */
	public GameFacade(boolean windowed) throws RemoteException {	
		gameEng = GameEngine.getInstance();
		
		gameDecorator = new WindowDecorator(gameEng);
		this.flagWindowed = windowed;
		
		if (windowed)
			gameDisp = gameDecorator;
		else
			gameDisp = gameEng;
			
		players = new HashMap<>(1);
		
		Log.e(TAG, "Façade ready!");
	}

	
	/* (non-Javadoc)
	 * @see RemoteGame#playGame()
	 */
	public void playGame() {
		gameDisp.renderWindow(new GraphicEnvironment());
		Log.e(TAG, "Starting game...");
		gameDisp.start();
	}

	/* (non-Javadoc)
	 * @see RemoteGame#stopGame()
	 */
	public void stopGame() {
		Log.e(TAG, "Stopping game!");
		gameDisp.stop();
	}
		
	@Override
	public double addPlayer() {
		
		// Creo una nuova navicella in coordinate 0,0
		SpaceShip newShip = new SpaceShip(0, 0, 0);
		double ID = newShip.getID();
		
		players.put(ID, newShip);
		gameEng.addEntity(newShip);
		
		Log.e(TAG, "Ship " + ID + " Created");
		return ID;
	}

	/**
	 * Metodo che permette di aggiungere un nuovo giocatore e che ritorna il suo event listner swing
	 * 
	 * @param left Carattere per il tasto left
	 * @param right Carattere per il tasto right
	 * @param propel Carattere per il tasto propel
	 * @param fire Carattere per il tasto fire
	 * @return Un {@link KeyEventManager} per poterlo linkare ad un controllo grafico
	 */
	public KeyEventManager addPlayer(char left, char right, char propel, char fire) {
		
		double ID = this.addPlayer();
		SpaceShip newShip = players.get(ID);
		
		// Creo un nuovo EventManager
		KeyEventManager mgr = new KeyEventManager(gameDisp, newShip, left, right, propel, fire);
		
		Log.e(TAG, "KeyEventManager Created");
		return mgr;
	}

	@Override
	public void rotate(double playerID, int direction) {
		
		// Invio un comando di rotazione
		SpaceShip owner = players.get(playerID);
		if (owner != null && (direction == SpaceShip.SPACESHIP_LEFT || direction == SpaceShip.SPACESHIP_RIGHT)){
			CommandRotate rotate = new CommandRotate(owner, direction);
			gameDisp.sendCommand(rotate);
		}
	}

	@Override
	public void propel(double playerID) {
		
		// Invio un comando di propulsione
		SpaceShip owner = players.get(playerID);
		if (owner != null){
			CommandPropel propel = new CommandPropel(owner);
			gameDisp.sendCommand(propel);
		}
	}

	
	/* (non-Javadoc)
	 * @see it.ncorti.tdp.user.RemoteGame#fire(double)
	 */
	@Override
	public void fire(double playerID) {
		
		// Invio un comando di sparo
		SpaceShip owner = players.get(playerID);
		if (owner != null){
			CommandFire fire = new CommandFire(owner);
			gameDisp.sendCommand(fire);
		}
	}

	/* (non-Javadoc)
	 * @see RemoteGame#setWindowed(boolean)
	 */
	public void setWindowed(boolean windowed){
		if (windowed == this.flagWindowed) return;
		this.flagWindowed = windowed;
		
		if (windowed)
			gameDisp = gameDecorator;
		else
			gameDisp = gameEng;
		gameDisp.renderWindow(new GraphicEnvironment());
		
		Log.e(TAG, "Setted Window to " + windowed);
	}

}
