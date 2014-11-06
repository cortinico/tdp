package it.ncorti.tdp.core.entities;

import it.ncorti.tdp.graphics.DrawStrategy;
import it.ncorti.tdp.graphics.DrawVectors;

public class PowerBar extends GameEntity implements Collideable{

	private int angle;
	private static final int ROTATION_ANGLE = 10;
	
	public PowerBar(int x, int y, int angle) {
		super(x, y);
		this.angle = angle;
	}

	@Override
	protected EntityState createInitialState() {
		return new PowerBarNoHitState();
	}

	@Override
	protected DrawStrategy createInitialStrategy() {
		return new DrawVectors();
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
	public void evolveEntity() {
		angle += ROTATION_ANGLE % 360;
	}
	
	public int getAngle(){
		return this.angle;
	}
	
	@Override
	public String toString() {
		return "POWER BAR x:" + this.x + " y:" + this.y + " angle: " + this.angle;
	}
}
