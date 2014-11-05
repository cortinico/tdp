package it.ncorti.tdp.graphics;
import java.util.List;

/**
 * Strategia per disegnare una serie di sprite
 * 
 * @author nicola
 *
 */
public class DrawSprite extends DrawStrategy {

	/** Lista degli sprite */
	private List<GraphicEntity> lastSprites;
	/** Indice dello sprite appena disegnato */
	private int animation = 0;

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.graphics.DrawStrategy#drawEntity(it.ncorti.tdp.graphics.GraphicEnvironment, java.util.List)
	 */
	@Override
	public void drawEntity(GraphicEnvironment env, List<GraphicEntity> entity) {

		// Controllo se mi hanno inviato la stessa lista di entita' grafiche
		if (lastSprites == null || !lastSprites.equals(entity)) {
			lastSprites = entity;
			animation = 0;
		}
		
		// Disegno una singola sprite
		GraphicSprite spriteToDraw = (GraphicSprite) entity.get(animation);
		env.drawSprite(spriteToDraw);
		
		// Aggiorno il contatore per la prossima sprite
		animation++;
		if (animation >= entity.size()) animation = 0;
	}
}
