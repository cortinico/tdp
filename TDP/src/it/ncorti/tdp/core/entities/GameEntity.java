package it.ncorti.tdp.core.entities;

import it.ncorti.tdp.graphics.DrawStrategy;
import it.ncorti.tdp.graphics.Drawable;
import it.ncorti.tdp.graphics.GraphicEnvironment;

public abstract class GameEntity implements Drawable {
	
	protected int x;
	protected int y;
	
	protected EntityState state;
	protected DrawStrategy strategy;
	
	public GameEntity(int x, int y) {
		this.x = x;
		this.y = y;
		this.state = createInitialState();
		this.strategy = createInitialStrategy();
	}
	
	protected abstract EntityState createInitialState();
	protected abstract DrawStrategy createInitialStrategy();

	public void setState(EntityState state){
		this.state = state;
	}

	public void setStrategy(DrawStrategy strategy){
		this.strategy = strategy;
	}
	
	public boolean isDestroyed(){
		return this.state.isDestroyed();
	}
	
	public abstract void evolveEntity();
	
	@Override
	public void draw(GraphicEnvironment g) {
		this.strategy.drawEntity(g, state.getEntity());
	}
	
	public void physicMove(int angle, int speed){
		this.x += Math.cos(Math.toRadians(angle)) * speed;
		this.y += Math.sin(Math.toRadians(angle)) * speed;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public abstract String toString();
}
