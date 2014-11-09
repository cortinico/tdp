package it.ncorti.tdp.graphics;
import java.util.List;

/**
 * Classe che rappresenta una Strategy per effettuare il disegno di una serie di primitive grafiche
 * 
 * @author Nicola Corti
 *
 */
public abstract class DrawStrategy {

	/**
	 * Metodo per disegnare una serie di primitive grafiche
	 * 
	 * @param env Ambiente grafico
	 * @param entity Lista di primitive grafiche
	 */
	public abstract void drawEntities(GraphicEnvironment env, List<GraphicEntity> entity);
	
}
