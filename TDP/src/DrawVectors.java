import java.util.List;

public class DrawVectors extends DrawStrategy {

	@Override
	public void drawEntity(GraphicEnvironment env, List<GraphicEntity> vectors) {

		for (GraphicEntity vect : vectors)
			env.drawVector((GraphicVector) vect);

	}
}
