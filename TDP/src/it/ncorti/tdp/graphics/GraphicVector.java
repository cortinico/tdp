package it.ncorti.tdp.graphics;

import it.ncorti.tdp.user.Log;

/**
 * Classe che rappresenta un vettore grafico da disegnare
 * 
 * @author Nicola Corti
 */
public class GraphicVector implements GraphicEntity {

	/** TAG per le stampe di debug */
	private static final String TAG = "##### DrawVector";
	
	/** Coordinata x di inizio */
	private int beginX;
	/** Coordinata y di inizio */
	private int beginY;
	/** Coordinata x di fine */
	private int endX;
	/** Coordinata y di fine */
	private int endY;
	/** Colore del vettore */
	private int color;

	/** Messaggio di debug */
	private String message;

	/**
	 * Costruttore di base per un nuovo vettore da disengare
	 * 
	 * @param beginX Coordinata x di inizio
	 * @param beginY Coordinata y di inizio
	 * @param endX Coordinata x di fine
	 * @param endY Coordinata x di fine
	 * @param color Colore del vettore
	 */
	public GraphicVector(int beginX, int beginY, int endX, int endY, int color) {
		this.setBeginX(beginX);
		this.setBeginY(beginY);
		this.setEndX(endX);
		this.setEndY(endY);
		this.setColor(color);
		this.message = "COORD VECT";
	}

	/**
	 * Costruttore per creare un vettore di debug
	 * 
	 * @param message Messaggio di debug da mostrare
	 */
	public GraphicVector(String message) {
		this.setBeginX(0);
		this.setBeginY(0);
		this.setEndX(0);
		this.setEndY(0);
		this.setColor(0);
		this.message = message;
	}

	/** Ritorna la coordinata di inizio di X
	 * @return La coordinata di inizio di X
	 */
	public int getBeginX() {
		return beginX;
	}

	/** Imposta la coordinata di inizio di X
	 * @param beginX la coordinata di inizio di X
	 */
	public void setBeginX(int beginX) {
		this.beginX = beginX;
	}

	/** Ritorna la coordinata di inizio di Y
	 * @return La coordinata di inizio di Y
	 */
	public int getBeginY() {
		return beginY;
	}

	/** Imposta la coordinata di inizio di Y
	 * @param beginY la coordinata di inizio di Y
	 */
	public void setBeginY(int beginY) {
		this.beginY = beginY;
	}

	/** Ritorna la coordinata di fine di X
	 * @return La coordinata di fine di X
	 */
	public int getEndX() {
		return endX;
	}

	/** Imposta la coordinata di fine di X
	 * @param endX la coordinata di fine di X
	 */
	public void setEndX(int endX) {
		this.endX = endX;
	}

	/** Ritorna la coordinata di fine di Y
	 * @return La coordinata di fine di Y
	 */
	public int getEndY() {
		return endY;
	}

	/** Imposta la coordinata di fine di Y
	 * @param endY la coordinata di fine di Y
	 */
	public void setEndY(int endY) {
		this.endY = endY;
	}

	/** Ritorna il colore del vettore
	 * @return il colore del vettore
	 */
	public int getColor() {
		return color;
	}

	/** Imposta il colore del vettore
	 * @param color Il colore del vettore
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.graphics.GraphicEntity#drawString()
	 */
	@Override
	public String drawString() {
		Log.e(TAG, "Drawed Vector " + message);
		return null;
	}

}
