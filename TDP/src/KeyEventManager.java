import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyEventManager implements KeyListener {

	SpaceShip owner;
	GameDisplay display;
	
	Command rotateLeft;
	Command rotateRight;
	Command propelOn;
	Command fireOff;
	
	public KeyEventManager(GameDisplay display, SpaceShip owner) {
		this.owner = owner;
		this.display = display;
		
		rotateLeft = new CommandRotate(owner, SpaceShip.SPACESHIP_LEFT);
		rotateRight = new CommandRotate(owner, SpaceShip.SPACESHIP_RIGHT);
		propelOn = new CommandPropel(owner);
		fireOff = new CommandFire(owner);
		
		propelOn = new CommandPropel(null);
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
			toSend = fireOff;
		
		if (toSend != null) display.receiveCommand(toSend);
	}

	public void keyReleased(KeyEvent arg0) { }
	public void keyTyped(KeyEvent arg0) { }

}
