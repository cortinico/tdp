package it.ncorti.tdp.core.entities;

import it.ncorti.tdp.graphics.GraphicEntity;
import it.ncorti.tdp.graphics.GraphicVector;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta lo stato di un'astronave viva, che riceve comandi utente e che puo' sparare
 * 
 * @author nicola
 */
public class SpaceShipAliveState extends EntityState {

	/** Elenco di vettori per mostrare l'astronave */
	private List<GraphicEntity> spaceShipAliveVect;

	/**
	 * Costruttore di base per creare un nuovo stato dell'astronave viva
	 */
	public SpaceShipAliveState() {
		spaceShipAliveVect = new ArrayList<>();
		spaceShipAliveVect.add(new GraphicVector("spaceShipAlive - 1"));
		spaceShipAliveVect.add(new GraphicVector("spaceShipAlive - 2"));
		spaceShipAliveVect.add(new GraphicVector("spaceShipAlive - 3"));
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.EntityState#isDestroyed() */
	@Override
	public boolean isDestroyed() {
		return false;
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.EntityState#collide(it.ncorti.tdp.core.entities.GameEntity,
	 * it.ncorti.tdp.core.entities.Collideable) */
	public void collide(GameEntity e, Collideable c) {
		SpaceShip ship = (SpaceShip) e;

		// Evolve lo stato dell'astronave in base all'oggetto con cui si e' entrati in collisione
		if (c instanceof Mine) {
			ship.setState(new EntityDeadState());
		} else if (c instanceof SpaceShip) {
			ship.reverse();
		} else if (c instanceof PowerBar) {
			ship.stop();
		} else if (c instanceof PlasmaBall) {
			ship.setState(new EntityDeadState());
		}
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.EntityState#getEntity() */
	@Override
	public List<GraphicEntity> getEntity() {
		return spaceShipAliveVect;
	}

}
