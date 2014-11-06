package it.ncorti.tdp.user;
import java.rmi.Naming;

/**
 * Client per connettersi al Remote Proxy, utilizzando la tecnologia java RMI
 * 
 * @author nicola
 */
public class UserClient {

	/**
	 * Classe main
	 * 
	 * @param args Parametri di invocazione
	 */
	public static void main(String[] args) {
		try {
			RemoteGame service = (RemoteGame) Naming.lookup("rmi://127.0.0.1/RemoteGame");
			
			service.addPlayer('a', 'd', 'w', 's');
			service.setWindowed(false);
			service.playGame();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
