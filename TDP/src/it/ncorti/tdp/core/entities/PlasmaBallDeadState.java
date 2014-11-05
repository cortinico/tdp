package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.graphics.GraphicEntity;
import it.ncorti.tdp.graphics.GraphicSprite;

import java.util.ArrayList;
import java.util.List;


public class PlasmaBallDeadState extends EntityState {

	private List<GraphicEntity> plasmaBallDeadSprites;

	public PlasmaBallDeadState() {
		plasmaBallDeadSprites = new ArrayList<>();
		plasmaBallDeadSprites.add(new GraphicSprite("plasmaBallDead - 1"));
		plasmaBallDeadSprites.add(new GraphicSprite("plasmaBallDead - 2"));
	}
	
	@Override
	public boolean isDestroyed() { return true; }

	@Override
	public List<GraphicEntity> getEntity() {	
		return plasmaBallDeadSprites;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		// Ignora
	}

}
