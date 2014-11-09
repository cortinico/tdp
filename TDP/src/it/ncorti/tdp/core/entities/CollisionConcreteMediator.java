package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.user.Log;

import java.util.List;

/**
 * Classe che rappresenta un mediatore concreto che si occupa di notificare a tutti i Collideable
 * che si e' verificata una collisione
 * 
 * @author Nicola Corti
 *
 */
public class CollisionConcreteMediator implements CollisionMediator {

	/** TAG per le stampe di debug */
	private static final String TAG = "***** CollisionMediator";
	
	/** Costante che indica la dimensione base del raggio dei {@link BoundCircle} */
	public static final int BND_RADIUS = 50;
	
	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.IMediator#checkCollision(java.util.List)
	 */
	@Override
	public void checkCollision(List<? extends Collideable> entities){
		
		for (Collideable first: entities){
			for (Collideable second: entities){
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