import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {

		try {

			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					JFrame f = new JFrame("Star Castle Test Window");
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					f.setSize(100, 100);
					MyPanel p = new MyPanel();
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

	public static class MyPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		public MyPanel() {
			try {
			setBorder(BorderFactory.createLineBorder(Color.black));
			
			RemoteGame game = new GameFacade(true);
			KeyEventManager manager = game.addPlayer('a', 'd', 'w', 's');
			game.playGame();
			addKeyListener(manager);
			} catch (Exception e){
				e.printStackTrace();
			}
		}

		public Dimension getPreferredSize() {
			return new Dimension(100, 100);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
		}
	}
}
