package it.ncorti.tdp.core.entities;
/**
 * Interfaccia che deve essere implementata dagli oggetti che vogliono collidere con altri
 * 
 * @author Nicola Corti
 *
 */
public interface Collideable {

	/**
	 * Ritorna l'area nel quale una entita' registra le collisioni
	 * 
	 * @return L'area nel quale una entita' registra le collisioni
	 */
	public BoundCircle getBoundCircle();
	
	/**
	 * Metodo che viene invocato quando un'entita' collide con un'altra
	 * 
	 * @param c
	 */
	public void collideWith(Collideable c);
	
}