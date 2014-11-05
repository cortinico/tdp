package it.ncorti.tdp.user;
import java.awt.Panel;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Classe di test per effettuare alcune invocazioni sulle classi del videogioco
 * 
 * @author Nicola Corti
 *
 */
public class Main {

	/**
	 * Metodo main
	 * 
	 * @param args
	 *            Parametri di invocazione
	 */
	public static void main(String[] args) {

		try {

			SwingUtilities.invokeLater(new Runnable() {
				public void run() {

					RemoteGame game;
					KeyEventManager manager = null;
					try {
						game = new GameFacade(true);
						manager = game.addPlayer('a', 'd', 'w', 's');
						game.playGame();
					} catch (RemoteException e) {
						
						e.printStackTrace();
					}

					JFrame f = new JFrame("Star Castle Test Window");
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					f.setSize(800, 600);

					Panel p = new Panel();
					p.setSize(100, 100);
					p.addKeyListener(manager);
					p.setFocusable(true);
					f.add(p);
					p.requestFocusInWindow();
					f.pack();
					f.setVisible(true);
				}
			});

		} catch (Exception e) {
			
		}
	}
}
