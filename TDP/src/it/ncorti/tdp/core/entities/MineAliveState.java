package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.graphics.GraphicEntity;
import it.ncorti.tdp.graphics.GraphicSprite;

import java.util.ArrayList;
import java.util.List;


public class MineAliveState extends EntityState {

	
	private List<GraphicEntity> mineAliveSprites;

	public MineAliveState() {
		mineAliveSprites = new ArrayList<>();
		mineAliveSprites.add(new GraphicSprite("mineAlive - 1"));
		mineAliveSprites.add(new GraphicSprite("mineAlive - 2"));
	}
	
	@Override
	public boolean isDestroyed() {
		return false;
	}

	@Override
	public List<GraphicEntity> getEntity() {		
		return mineAliveSprites;
	}

	@Override
	public void collide(GameEntity s, Collideable c) {
		if (c instanceof SpaceShip || c instanceof Missile){
			s.setState(new MineDeadState());
		}
	}

}
