import java.util.List;

public class DrawSprite extends DrawStrategy {

	private List<GraphicEntity> lastSprites;
	private int animation = 0;

	@Override
	public void drawEntity(GraphicEnvironment env, List<GraphicEntity> entity) {

		if (lastSprites == null || !lastSprites.equals(entity)) {
			lastSprites = entity;
			animation = 0;
		}
		
		GraphicSprite spriteToDraw = (GraphicSprite) entity.get(animation);
		env.drawSprite(spriteToDraw);
		animation++;
		if (animation >= entity.size()) animation = 0;
	}
}
