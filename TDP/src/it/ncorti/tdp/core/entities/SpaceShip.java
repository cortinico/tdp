package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.graphics.DrawStrategy;
import it.ncorti.tdp.graphics.DrawVectors;

import java.util.Observer;

public class SpaceShip extends GameEntity implements Collideable {

	public static final int SPACESHIP_LEFT = 1;
	public static final int SPACESHIP_RIGHT = 2;
	
	public static final int MAX_SPEED = 10;

	private int speed;
	private int angle;
	
	private DelegatedObservable obs;
		
	public SpaceShip(int x, int y, int angle){
		super(x, y);
		this.angle = angle;
		this.speed = 0;
		this.obs = new DelegatedObservable();
	}
	
	@Override
	protected EntityState createInitialState() {
		return new SpaceShipAliveState();
	}

	@Override
	protected DrawStrategy createInitialStrategy() {
		return new DrawVectors();
	}
	
	public void propel(){
		this.speed++;
		if (this.speed > MAX_SPEED) this.speed = MAX_SPEED;
		
		obs.setChanged();
		obs.notifyObservers(this);
	}
	
	public void rotate(int direction){
		if (direction == SPACESHIP_LEFT){
			this.angle += 1 % 360;
		} else if (direction == SPACESHIP_RIGHT) {
			this.angle--;
			if (this.angle < 0) this.angle = 360;
		}
		
		obs.setChanged();
		obs.notifyObservers(this);
	}
	
	public void addObserver(Observer o){
		obs.addObserver(o);
	}
	
	public void deleteObserver(Observer o){
		obs.deleteObserver(o);
	}
	
	public void reverseDirection() {
		this.angle += 180 % 360;
	}
	
	public void stop(){
		this.speed = 0;
	}
	
	public Missile shot(){
		Missile justShooted = new Missile(x, y, angle);
		return justShooted;
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
		physicMove(angle, speed);
		speed--;
	}
	
	@Override
	public String toString() {
		return "SPACESHIP x:" + this.x + " y:" + this.y + " angle: " + this.angle + " speed:" + this.speed;
	}
}