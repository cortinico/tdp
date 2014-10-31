import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyEventManager implements KeyListener {

	GameDisplay receiver;
	
	Command rotateLeft;
	Command rotateRight;
	Command propelOn;
	Command escKey;
	Command spaceKey;
	
	public KeyEventManager(GameDisplay receiver) {
		this.receiver = receiver;
		
		// TODO manca l'environment e la rotazione
		rotateLeft = new RotateCommand(null);
		rotateRight = new RotateCommand(null);
		
		propelOn = new PropelCommand(null);
		escKey = new EscCommand(null);
		spaceKey = new EscCommand(null);
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		Command toSend = null;
		if (arg0.getKeyChar() == 'a')
			toSend = rotateLeft;
		else if (arg0.getKeyChar() == 'd')
			toSend = rotateRight;
		else if (arg0.getKeyChar() == 'w')
			toSend = propelOn;
		else if (arg0.getKeyChar() == 's')
			toSend = spaceKey;
		else if (arg0.getKeyChar() == 'e')
			toSend = escKey;
		
		if (toSend != null) receiver.receiveCommand(toSend);
	}

	public void keyReleased(KeyEvent arg0) { }
	public void keyTyped(KeyEvent arg0) { }

}
