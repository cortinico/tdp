package it.ncorti.tdp.user.rmi;

import it.ncorti.tdp.user.GameFacade;
import it.ncorti.tdp.user.Log;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Classe di test che rappresenta il gioco in esecuzione su un server remoto
 * 
 * @author Nicola Corti
 *
 */
public class RemoteServer {

	/** TAG per le stampe di debug */
	private static final String TAG = "<RMI> RemoteServer";

	/** Nome del servizio RMI */
	public final static String SERVICE_NAME = "StarCastle";

	/**
	 * Metodo main
	 * 
	 * @param args Parametri di invocazione
	 */
	public static void main(String[] args) {

		if (args.length < 2) {
			System.err.println("Invalid invocation!");
			System.err.println("Usage: java it.ncorti.tdp.user.rmi.RemoteServer");
			System.err.println("\t \t \t <hostname> <port>");
			System.exit(-1);
		}

		String hostname = args[0];
		int port = Integer.parseInt(args[1]);

		// Imposta l'hostname
		System.setProperty("java.rmi.server.hostname", hostname);
		Log.e(TAG, "Setted hostname to: " + hostname);
		try {

			// Recupera il registro RMI
			Registry registry;
			try {
				registry = LocateRegistry.createRegistry(port);
			} catch (RemoteException e) {
				registry = LocateRegistry.getRegistry(port);
			}
			Log.e(TAG, "Getted registry on port: " + port);

			GameFacade game = new GameFacade(false);
			registry.rebind(SERVICE_NAME, game);

			Log.e(TAG, "!!!Server ready!!! -> rmi://" + hostname + ":" + port + "/" + SERVICE_NAME);

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
