package it.ncorti.tdp.user;

import it.ncorti.tdp.core.GameEngine;
import it.ncorti.tdp.core.entities.SpaceShip;

public class CommandPropel implements Command {

	private SpaceShip owner;
	
	public CommandPropel(SpaceShip owner) {
		this.owner = owner;
	}
	
	@Override
	public void execute() {
		GameEngine.getInstance().propelSpaceShip(owner);
	}
}
