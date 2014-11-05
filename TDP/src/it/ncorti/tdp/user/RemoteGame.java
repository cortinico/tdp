package it.ncorti.tdp.user;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interfaccia del Remote Proxy Definisce i metodi che il giocatore remoto puo' chiamare sul proxy
 * 
 * @author nicola
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
	 * @param left Carattere per il tasto left
	 * @param right Carattere per il tasto right
	 * @param propel Carattere per il tasto propel
	 * @param fire Carattere per il tasto fire
	 * @return Un {@link KeyEventManager} per poterlo linkare ad un controllo grafico
	 * @throws RemoteException Errore a livello di rete/rmi
	 */
	public KeyEventManager addPlayer(char left, char right, char propel, char fire) throws RemoteException;

	/**
	 * Imposta la schermata in modalita' windowed
	 * 
	 * @param windowed Flag per indicare se si vuole il gioco in modalita' windowed o meno
	 * @throws RemoteException Errore a livello di rete/rmi
	 */
	public void setWindowed(boolean windowed) throws RemoteException;
}
