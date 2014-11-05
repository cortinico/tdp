package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.graphics.GraphicEntity;
import it.ncorti.tdp.graphics.GraphicSprite;

import java.util.ArrayList;
import java.util.List;


public class MissileDeadState extends EntityState {

	private List<GraphicEntity> missileDeadSprites;

	public MissileDeadState() {
		missileDeadSprites = new ArrayList<>();
		missileDeadSprites.add(new GraphicSprite("missileDead - 1"));
		missileDeadSprites.add(new GraphicSprite("missileDead - 2"));
	}
	
	@Override
	public boolean isDestroyed() { return true; }

	@Override
	public List<GraphicEntity> getEntity() {
		return missileDeadSprites;			
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		// Ignoro e rimuovo il missile, tanto e' esploso
	}

}
