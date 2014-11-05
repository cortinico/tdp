import java.util.ArrayList;
import java.util.List;


public class MineDeadState extends EntityState {

	private List<GraphicEntity> mineDeadSprites;

	public MineDeadState() {
		mineDeadSprites = new ArrayList<>();
		mineDeadSprites.add(new GraphicSprite("mineDead - 1"));
		mineDeadSprites.add(new GraphicSprite("mineDead - 2"));
	}
	
	@Override
	public boolean isDestroyed() {
		return true;
	}

	@Override
	public List<GraphicEntity> getEntity() {
	
		return mineDeadSprites;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		// Ignora, la mina non esiste piu'
	}

}
