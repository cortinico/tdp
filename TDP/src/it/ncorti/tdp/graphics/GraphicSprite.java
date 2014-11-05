package it.ncorti.tdp.graphics;

import it.ncorti.tdp.user.Log;

/**
 * Classe che rappresenta uno sprite da disegnare
 * 
 * @author nicola
 *
 */
public class GraphicSprite implements GraphicEntity {

	/** TAG per le stampe di debug */
	private static final String TAG = "##### DrawSprite";
	/** Nome del file da cui prendere la sprite */
	private String file;

	/**
	 * Costruttore di base
	 * 
	 * @param file
	 */
	public GraphicSprite(String file) {
		this.setFile(file);
	}

	/**
	 * Ritorna il nome del file
	 * 
	 * @return Il nome del file della sprite
	 */
	public String getFile() {
		return file;
	}

	/**
	 * Imposta il nome del file della sprite
	 * 
	 * @param file Nome del file che deve essere impostato per la sprite
	 */
	public void setFile(String file) {
		this.file = file;
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.graphics.GraphicEntity#drawString() */
	@Override
	public String drawString() {
		Log.e(TAG, "Drawed Sprite " + file);
		return null;
	}
}
