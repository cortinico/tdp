package it.ncorti.tdp.user.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interfaccia del Remote Proxy Definisce i metodi che il giocatore remoto puo' chiamare sul proxy
 * 
 * @author Nicola Corti
 *
 */
public interface RemoteGame extends Remote {

	/**
	 * Metodo che fa partire il gioco
	 * 
	 * @throws RemoteException Errore a livello di rete/rmi
	 */
	public void playGame() throws RemoteException;

	/**
	 * Metodo che fa fermare il gioco
	 * 
	 * @throws RemoteException Errore a livello di rete/rmi
	 */
	public void stopGame() throws RemoteException;

	/**
	 * Metodo che permette di aggiungere un nuovo giocatore
	 * 
	 * @return L'id del giocatore per poter fare interagire con il server
	 * @throws RemoteException Errore a livello di rete/rmi
	 */
	public double addPlayer() throws RemoteException;

	/**
	 * Imposta la schermata in modalita' windowed
	 * 
	 * @param windowed Flag per indicare se si vuole il gioco in modalita' windowed o meno
	 * @throws RemoteException Errore a livello di rete/rmi
	 */
	public void setWindowed(boolean windowed) throws RemoteException;
	
	
	public void rotate(double playerID, int direction) throws RemoteException;
	public void propel(double playerID) throws RemoteException;
	public void fire(double playerID) throws RemoteException;
}
