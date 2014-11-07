package it.ncorti.tdp.user.rmi;

import it.ncorti.tdp.core.entities.SpaceShip;
import it.ncorti.tdp.user.Log;
import it.ncorti.tdp.user.SimpleClient;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.SwingUtilities;

/**
 * Client per connettersi al Remote Proxy, utilizzando la tecnologia java RMI
 * 
 * @author Nicola Corti
 */
public class RemoteClient {

	/** TAG per le stampe di debug */
	private static final String TAG = "<RMI> RemoteClient";

	/**
	 * Classe main
	 * 
	 * @param args Parametri di invocazione
	 */
	public static void main(String[] args) {

		if (args.length != 6) {
			System.err.println("Invalid invocation!");
			System.err.println("Usage: java it.ncorti.tdp.user.SimpleUserClient");
			System.err.println("\t \t \t <left-key> <right-key> <propel-key> <fire-key> <serverip> <serverport>");
			System.exit(-1);
		}

		final char left, right, propel, fire;

		// Recupero il mapping dei pulsanti
		left = args[0].charAt(0);
		right = args[1].charAt(0);
		propel = args[2].charAt(0);
		fire = args[3].charAt(0);

		// Recupero indirizzo e porta del server
		String server = args[4];
		int port = Integer.parseInt(args[5]);

		try {

			// Recupero il servizio remoto
			String URI = "rmi://" + server + ":" + port + "/" + RemoteServer.SERVICE_NAME;
			final RemoteGame service = (RemoteGame) Naming.lookup(URI);

			// Ottengo l'ID del giocatore
			final double ID = service.addPlayer();
			
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					
					KeyListener manager = new RemoteKeyListner(service, ID, left, right, propel, fire);
					SimpleClient.showWindow(manager);		
			
					try {
						service.playGame();
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			});

		} catch (RemoteException e) {
			Log.e(TAG, "Unable to connect to server due to: " + e.getMessage());
		} catch (MalformedURLException e) {
			Log.e(TAG, "Your URL is malformed: " + e.getMessage());
		} catch (NotBoundException e) {
			Log.e(TAG, "Service not bound on server: " + e.getMessage());
		}
	}

	/**
	 * Classe che rappresenta un event listner Swing che collega gli input utente alle chiamate sul servizio remoto
	 * 
	 * @author nicola
	 */
	private static class RemoteKeyListner implements KeyListener {

		/** Carattere tasto sinistra */
		private char left;
		/** Carattere tasto destra */
		private char right;
		/** Carattere tasto accelera */
		private char propel;
		/** Carattere tasto fuoco */
		private char fire;

		/** Riferimento al servizio remoto */
		private RemoteGame service;
		/** ID del giocatore */
		private double ID;

		/**
		 * Costruttore che crea un nuovo RemoteKeyListner che puo' essere assegnato ad un componente Java Swing
		 * 
		 * @param service Servizio remoto a cui inviare le richieste
		 * @param ID ID del giocatore associato
		 * @param left Carattere tasto sinistra
		 * @param right Carattere tasto destra
		 * @param propel Carattere tasto accelera
		 * @param fire Carattere tasto fuoco
		 */
		public RemoteKeyListner(RemoteGame service, double ID, char left, char right, char propel, char fire) {
			this.left = left;
			this.right = right;
			this.propel = propel;
			this.fire = fire;
			this.ID = ID;
			this.service = service;
		}

		/* (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent) */
		@Override
		public void keyPressed(KeyEvent arg0) {
			try {
				if (arg0.getKeyChar() == left) {
					service.rotate(ID, SpaceShip.SPACESHIP_LEFT);
				} else if (arg0.getKeyChar() == right) {
					service.rotate(ID, SpaceShip.SPACESHIP_RIGHT);
				} else if (arg0.getKeyChar() == propel) {
					service.propel(ID);
				} else if (arg0.getKeyChar() == fire) {
					service.fire(ID);
				}
			} catch (RemoteException e) {
				Log.e(TAG, "Unable to deliver your command due to: " + e.getMessage());
			}

		}

		public void keyReleased(KeyEvent arg0) {}

		public void keyTyped(KeyEvent arg0) {}

	}
}
