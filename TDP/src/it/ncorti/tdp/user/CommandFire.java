package it.ncorti.tdp.user;

import it.ncorti.tdp.core.GameEngine;
import it.ncorti.tdp.core.entities.SpaceShip;

/**
 * Comando che rappresenta una richiesta di far sparare una {@link SpaceShip}
 * 
 * @author Nicola Corti
 *
 */
public class CommandFire implements Command {

	/** Riferimento alla navicella che dovra' sparare */
	private SpaceShip owner;
	
	/** Costruttore di base
	 * @param owner Navicella che dovra' sparare
	 */
	public CommandFire(SpaceShip owner) {
		this.owner = owner;
	}
	
	/* (non-Javadoc)
	 * @see it.ncorti.tdp.user.Command#execute()
	 */
	@Override
	public void execute() {
		GameEngine.getInstance().fireSpaceShip(owner);
	}
}
