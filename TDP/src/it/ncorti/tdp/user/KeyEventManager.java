package it.ncorti.tdp.user;
import it.ncorti.tdp.core.GameDisplay;
import it.ncorti.tdp.core.entities.SpaceShip;

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
		if (arg0.getKeyChar() == left){
			toSend = rotateLeft;
			System.err.println("%%% PRESSED: ROTATE LEFT");
		} else if (arg0.getKeyChar() == right) {
			toSend = rotateRight;
			System.err.println("%%% PRESSED: ROTATE RIGHT");
		} else if (arg0.getKeyChar() == propel) {
			toSend = propelOn;
			System.err.println("%%% PRESSED: PROPEL");
		} else if (arg0.getKeyChar() == fire) {
			toSend = fireOff;
			System.err.println("%%% PRESSED: FIRE");
		}
		
		if (toSend != null) display.receiveCommand(toSend);
	}

	public void keyReleased(KeyEvent arg0) { }
	public void keyTyped(KeyEvent arg0) { }

}
