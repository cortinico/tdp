package it.ncorti.tdp.user;
import it.ncorti.tdp.core.GameDisplay;
import it.ncorti.tdp.core.GameEngine;
import it.ncorti.tdp.core.WindowDecorator;
import it.ncorti.tdp.core.entities.SpaceShip;
import it.ncorti.tdp.graphics.GraphicEnvironment;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

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
	private GameEngine gameEnv;
	/** Riferimento alla finestra */
	private WindowDecorator gameDecorator;
	
	/** Elenco dei manager utente registrati */
	private List<KeyEventManager> userManagers;
	
	/** Flag che indica se è stata impostata la modalità window */
	private boolean flagWindowed = false;
	
	
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
		gameEnv = GameEngine.getInstance();
		
		gameDecorator = new WindowDecorator(gameEnv);
		this.flagWindowed = windowed;
		
		if (windowed)
			gameDisp = gameDecorator;
		else
			gameDisp = gameEnv;
		
		userManagers = new ArrayList<>();
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
		
	/* (non-Javadoc)
	 * @see RemoteGame#addPlayer(char, char, char, char)
	 */
	public KeyEventManager addPlayer(char left, char right, char propel, char fire) {
		
		// Creo una nuova navicella in coordinate 0,0
		SpaceShip newShip = new SpaceShip(0, 0, 0);
		gameEnv.addEntity(newShip);
		
		// Creo un nuovo EventManager
		KeyEventManager mgr = new KeyEventManager(gameDisp, newShip, left, right, propel, fire);
		userManagers.add(mgr);
		
		Log.e(TAG, "Ship Created");
		return mgr;
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
			gameDisp = gameEnv;
		gameDisp.renderWindow(new GraphicEnvironment());
		
		Log.e(TAG, "Setted Window to " + windowed);
	}
}
