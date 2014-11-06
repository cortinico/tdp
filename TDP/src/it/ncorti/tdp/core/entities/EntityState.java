package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.graphics.GraphicEntity;

import java.util.List;

/**
 * Classe astratta che rappresenta un generico stato di gioco
 * 
 * @author nicola
 */
public abstract class EntityState {

	/**
	 * Metodo che indica se l'entita' si trova in uno stato in cui puo' considerarsi distrutta
	 * 
	 * @return True se l'entita' si trova in uno stato in cui puo' considerarsi distrutta, false altrimenti
	 */
	public abstract boolean isDestroyed();
	
	/**
	 * Ritorna una lista di entita' grafiche che permettono di disegnare l'entita' in quello specifico stato
	 * 
	 * @return Lista di entita' grafiche che permettono di disegnare l'entita'
	 */
	public abstract List<GraphicEntity> getEntity();
	
	/**
	 * Definisce il comportamento dell'entita' quando viene in collisione con un'altra entita'
	 * e permette di evolvere di conseguenza lo stato dell'entita'
	 * 
	 * @param s Riferimento all'entita di cui si sta rappresentando lo stato
	 * @param c Oggetto con cui si e' entrati in collisione
	 */
	public abstract void collide(GameEntity s, Collideable c);
}