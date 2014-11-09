package it.ncorti.tdp.graphics;
import java.util.List;

/**
 * Strategia per disegnare una serie di vettori grafici
 * 
 * @author Nicola Corti
 *
 */
public class DrawVectors extends DrawStrategy {

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.graphics.DrawStrategy#drawEntity(it.ncorti.tdp.graphics.GraphicEnvironment, java.util.List)
	 */
	@Override
	public void drawEntities(GraphicEnvironment env, List<GraphicEntity> vectors) {
		
		// Disegna semplicemente ogni primitiva grafica
		for (GraphicEntity vect : vectors)
			env.drawVector((GraphicVector) vect);
	}
}
