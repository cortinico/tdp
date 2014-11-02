import java.util.List;

public abstract class EntityState {

	public abstract boolean isGameOver();
	public abstract List<GraphicEntity> getEntity();
	
	public abstract void collide(GameEntity s, Collideable c);
}