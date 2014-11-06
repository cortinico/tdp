package it.ncorti.tdp.core.entities;

/**
 * Classe che rappresenta un area circolare, utilizzata per calcolare le collisioni
 * 
 * @author nicola
 */
public class BoundCircle {

	/** Coordinata x del centro del cerchio */
	private int x;
	/** Coordinata y del centro del cerchio */
	private int y;
	/** Raggio del cerchio */
	private int radius;
	
	/**
	 * Costruttore base che ritorna una nuova area circolare, impostando centro e raggio
	 * 
	 * @param x Coordinata x del centro del cerchio
	 * @param y Coordinata y del centro del cerchio
	 * @param radius Raggio del cerchio
	 */
	public BoundCircle(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	/**
	 * Ritorna la coordinata x del centro del cerchio
	 * 
	 * @return La coordinata x del centro del cerchio
	 */
	public int getX() {
		return x;
	}

	/**
	 * Ritorna la coordinata y del centro del cerchio
	 * 
	 * @return La coordinata y del centro del cerchio
	 */
	public int getY() {
		return y;
	}

	/**
	 * Ritorna il raggio del cerchio
	 * 
	 * @return Il raggio del cerchio
	 */
	public int getRadius() {
		return radius;
	}
}
