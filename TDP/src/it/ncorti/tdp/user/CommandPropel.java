package it.ncorti.tdp.user;

import it.ncorti.tdp.core.GameEngine;
import it.ncorti.tdp.core.entities.SpaceShip;

/**
 * Comando che rappresenta una richiesta di far accelerare una {@link SpaceShip}
 * 
 * @author nicola
 *
 */
public class CommandPropel implements Command {

	/** Riferimento alla navicella che dovra' accelerare */
	private SpaceShip owner;
	
	/** Costruttore di base
	 * @param owner Navicella che dovra' accelerare
	 */
	public CommandPropel(SpaceShip owner) {
		this.owner = owner;
	}
	
	/* (non-Javadoc)
	 * @see it.ncorti.tdp.user.Command#execute()
	 */
	@Override
	public void execute() {
		GameEngine.getInstance().propelSpaceShip(owner);
	}
}
