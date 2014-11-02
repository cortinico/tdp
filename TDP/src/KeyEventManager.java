import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyEventManager implements KeyListener {

	SpaceShip owner;
	GameDisplay display;
	
	Command rotateLeft;
	Command rotateRight;
	Command propelOn;
	Command fireOff;
	
	char left, right, propel, fire;
	
	public KeyEventManager(GameDisplay display, SpaceShip owner, char left, char right, char propel, char fire) {
		this.owner = owner;
		this.display = display;
		
		this.left = left;
		this.right = right;
		this.propel = propel;
		this.fire = fire;
		
		rotateLeft = new CommandRotate(owner, SpaceShip.SPACESHIP_LEFT);
		rotateRight = new CommandRotate(owner, SpaceShip.SPACESHIP_RIGHT);
		propelOn = new CommandPropel(owner);
		fireOff = new CommandFire(owner);
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		Command toSend = null;
		if (arg0.getKeyChar() == left)
			toSend = rotateLeft;
		else if (arg0.getKeyChar() == right)
			toSend = rotateRight;
		else if (arg0.getKeyChar() == propel)
			toSend = propelOn;
		else if (arg0.getKeyChar() == fire)
			toSend = fireOff;
		
		if (toSend != null) display.receiveCommand(toSend);
	}

	public void keyReleased(KeyEvent arg0) { }
	public void keyTyped(KeyEvent arg0) { }

}
