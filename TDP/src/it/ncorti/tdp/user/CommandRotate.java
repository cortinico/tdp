package it.ncorti.tdp.user;

import it.ncorti.tdp.core.GameEngine;
import it.ncorti.tdp.core.entities.SpaceShip;

public class CommandRotate implements Command {

	SpaceShip owner;
	int direction;
	
	public CommandRotate(SpaceShip owner, int direction) {
		this.owner = owner;
		this.direction = direction;
	}	
	
	@Override
	public void execute() {
		GameEngine.getInstance().rotateSpaceShip(owner, direction);
	}
}
