package it.ncorti.tdp.graphics;

/**
 * Interfaccia che deve essere implementata dalle entita che devono prevedere di essere disegnate a schermo
 * 
 * @author Nicola Corti
 *
 */
public interface Drawable {

	/**
	 * Metodo che verra' invocato quando sera' richiesto di disegnare l'oggetto Drawable
	 * 
	 * @param g L'ambiente grafico da utilizza per disegnarsi
	 */
	public void draw(GraphicEnvironment g);

}
