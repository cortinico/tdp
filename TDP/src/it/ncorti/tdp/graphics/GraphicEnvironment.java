package it.ncorti.tdp.graphics;
import it.ncorti.tdp.user.Log;

import java.util.ArrayList;
/**
 * Classe che rappresenta un ambiente grafico, contenente tutti gli strumenti
 * per disegnare su schermo le primitive grafiche (sprite o vettori)
 * 
 * @author nicola
 */
public class GraphicEnvironment {
	
	/** TAG per le stampe di debug */
	private static final String TAG = "##### GraphicEnvironment";
	/** Lista di primitive che e' stato richiesto di disegnare */
	private ArrayList<GraphicEntity> list = new ArrayList<>();

	/**
	 * Metodo per disegnare una sprite
	 * 
	 * @param spriteToDraw Riferimento alla sprite da disegnare
	 */
	public void drawSprite(GraphicSprite spriteToDraw){ list.add(spriteToDraw); }
	
	/**
	 * Metodo per disegnare un vettore
	 * 
	 * @param vectToDraw Riferimento al vettore da disegnare
	 */
	public void drawVector(GraphicVector vectToDraw){ list.add(vectToDraw); }
	
	/**
	 * Svuota la lista delle primitive di cui e' stato richiesto il draw e le
	 * disegna su terminale. 
	 */
	public void renderOver(){
		Log.e(TAG, "Rendering to terminal");
		for (GraphicEntity ent : list){
			ent.drawString();
		}
		list.clear();
	}
}
