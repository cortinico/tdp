package it.ncorti.tdp.core.entities;

import java.util.List;

/**
 * Interfaccia che rappresenta un mediatore che si occupa di notificare a tutti i Collideable
 * che si e' verificata una collisione
 * 
 * @author Nicola Corti
 *
 */
public interface CollisionMediator {

	/**
	 * Metodo per controllare se all'interno di una lista di collideable esistono delle 
	 * collisioni e notifica i relativi oggetti della collisione (entrambi i soggetti)
	 * 
	 * @param entities Lista di collideable da controllare e notificare
	 */
	public void checkCollision(List<? extends Collideable> entities);

}