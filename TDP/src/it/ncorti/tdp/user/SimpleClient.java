package it.ncorti.tdp.user;

import java.awt.event.KeyListener;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

/**
 * Classe di test per effettuare alcune invocazioni sulle classi del videogioco.
 * Avvia il gioco e connette direttamente un giocatore sullo stessa macchina
 * 
 * @author Nicola Corti
 *
 */
public class SimpleClient {

	/**
	 * Metodo main
	 * 
	 * @param args Parametri di invocazione
	 */
	public static void main(String[] args) {

		final char left, right, propel, fire;

		if (args.length < 4) {
			System.err.println("Invalid invocation!");
			System.err.println("Usage: java it.ncorti.tdp.user.SimpleUserClient");
			System.err.println("\t \t \t <left-key> <right-key> <propel-key> <fire-key>");
			System.exit(-1);
		}

		left = args[0].charAt(0);
		right = args[1].charAt(0);
		propel = args[2].charAt(0);
		fire = args[3].charAt(0);

		try {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					try {
						GameFacade game = new GameFacade(true);
						KeyListener manager = game.addPlayer(left, right, propel, fire);

						showWindow(manager);
						
						game.playGame();
					} catch (RemoteException e) {
						e.printStackTrace();
					}

				}
			});

		} catch (Exception e) {

		}
	}

	/**
	 * Metodo per mostrare un generico frame che funga da recettore degli eventi di input
	 * da tastiera
	 * 
	 * @param manager Manager input che deve essere associato al pannello 
	 * 
	 * @return Un JFrame che contiene una singola textbox
	 */
	public static JFrame showWindow(KeyListener manager) {
		JFrame frame = new JFrame("Star Castle Event Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setFocusable(true);

		JTextPane text = new JTextPane();
		text.setText("StarCastel Event Window");

		panel.addKeyListener(manager);
		
		panel.add(text);
		frame.add(panel);

		panel.requestFocusInWindow();
		frame.pack();
		frame.setVisible(true);
		return frame;
	}
}
