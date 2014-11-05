package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.graphics.DrawSprite;
import it.ncorti.tdp.graphics.DrawStrategy;

import java.util.Observable;
import java.util.Observer;


public class Mine extends GameEntity implements Collideable, Observer {

	private int angle = 0;
	private SpaceShip following = null;
	private static final int MINE_SPEED = 5;
		
	public Mine(int x, int y) {
		super(x, y);
	}

	@Override
	protected EntityState createInitialState() {
		return new MineAliveState();
	}

	@Override
	protected DrawStrategy createInitialStrategy() {
		return new DrawSprite();
	}
	
	@Override
	public BoundCircle getBoundCircle() {
		return new BoundCircle(getX(), y, CollisionMediator.BND_RADIUS);
	}

	@Override
	public void collideWith(Collideable c) {
		state.collide(this, c);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof SpaceShip)
			this.following = (SpaceShip) arg1;
	}

	@Override
	public void evolveEntity() {
		if (this.following != null){
			angle = (this.x - following.getX())/(this.y - following.getY());
			physicMove(angle, MINE_SPEED);
		}
	}

	@Override
	public String toString() {
		return "MINE x:" + this.x + " y:" + this.y + " angle: " + this.angle;
	}
}
