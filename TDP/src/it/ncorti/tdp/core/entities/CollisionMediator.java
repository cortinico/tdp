package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.user.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta un mediatore che si occupa 
 * 
 * @author nicola
 *
 */
public class CollisionMediator {

	/** TAG per le stampe di debug */
	private static final String TAG = "***** CollisionMediator";
	
	/** Costante che indica la dimensione base del raggio dei {@link BoundCirlce} */
	public static final int BND_RADIUS = 5;
	
	/**
	 * Metodo per controllare se all'interno di una lista di entita' esistono delle 
	 * collisioni fra entita' e notifica i relativi oggetti della collisione (entrambi i soggetti)
	 * 
	 * @param entities Lista di entita' di gioco da controllare e notificare
	 */
	public void checkCollision(List<GameEntity> entities){
		
		List<Collideable> objects = filter(entities);
		
		for (Collideable first: objects){
			for (Collideable second: objects){
				if (!first.equals(second)){
					BoundCircle firstCircle = first.getBoundCircle();
					BoundCircle secondCircle = second.getBoundCircle();
					if (overLap(firstCircle, secondCircle)){
						first.collideWith(second);
						Log.e(TAG, "Collision between: " + first);
						Log.e(TAG, "Collision     and: " + second);
					}
				}
			}
		}
	}
	
	/**
	 * Metodo che filtra una lista di entita' e ritorna una lista di oggetti Collideable
	 * 
	 * @param entities Lista di entita' da filtrare
	 * @return Una lista di collideable filtrata
	 */
	private List<Collideable> filter(List<GameEntity> entities) {
		List<Collideable> filtered = new ArrayList<>();
		for (GameEntity ent : entities)
			if (ent instanceof Collideable) 
				filtered.add((Collideable)ent);
		
		return filtered;
	}

	/**
	 * Metodo che controlla se due aree BoundCircle si intersecano
	 * 
	 * @param first Primo bound circle da controllare
	 * @param second Secondo bound circle da controllare
	 * @return True se si intersecano, false altrimenti
	 */
	private boolean overLap(BoundCircle first, BoundCircle second){
		int width = first.getX() - second.getX();
		int height = first.getY() - second.getY();
		double distance = Math.sqrt(width*width + height*height);
		if (distance <= first.getRadius() + second.getRadius())
			return true;
		else
			return false;
	}
}