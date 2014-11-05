package it.ncorti.tdp.user;

import it.ncorti.tdp.core.GameEngine;
import it.ncorti.tdp.core.entities.SpaceShip;

public class CommandFire implements Command {

	private SpaceShip owner;
	
	public CommandFire(SpaceShip owner) {
		this.owner = owner;
	}
	
	@Override
	public void execute() {
		GameEngine.getInstance().fireSpaceShip(owner);
	}
}
