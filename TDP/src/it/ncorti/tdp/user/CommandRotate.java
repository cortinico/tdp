package it.ncorti.tdp.user;

import it.ncorti.tdp.core.GameEngine;
import it.ncorti.tdp.core.entities.SpaceShip;

/**
 * Comando che rappresenta una richiesta di far accelerare una {@link SpaceShip}
 * 
 * @author nicola
 *
 */
public class CommandRotate implements Command {

	/** Riferimento alla navicella che dovra' accelerare */
	private SpaceShip owner;
	/** Direzioni di rotazione {@link SpaceShip} */
	private int direction;
	
	/**Costruttore di base
	 * 
	 * @param owner Riferimento alla navicella che dovra' accelerare
	 * @param direction Direzioni di rotazione {@link SpaceShip}
	 */
	public CommandRotate(SpaceShip owner, int direction) {
		this.owner = owner;
		this.direction = direction;
	}	
	
	/* (non-Javadoc)
	 * @see it.ncorti.tdp.user.Command#execute()
	 */
	@Override
	public void execute() {
		GameEngine.getInstance().rotateSpaceShip(owner, direction);
	}
}
