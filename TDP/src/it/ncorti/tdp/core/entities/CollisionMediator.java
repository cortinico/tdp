package it.ncorti.tdp.core.entities;
import java.util.ArrayList;
import java.util.List;

public class CollisionMediator {

	public static final int BND_RADIUS = 5;
	
	public void checkCollision(List<GameEntity> entities){
		
		List<Collideable> objects = filter(entities);
		
		for (Collideable first: objects){
			for (Collideable second: objects){
				if (!first.equals(second)){
					BoundCircle firstCircle = first.getBoundCircle();
					BoundCircle secondCircle = second.getBoundCircle();
					if (overLap(firstCircle, secondCircle)){
						first.collideWith(second);
						System.err.println("$$$ COLLISION!!!");
					}
				}
			}
		}
	}
	
	private List<Collideable> filter(List<GameEntity> entities) {
		List<Collideable> filtered = new ArrayList<>();
		for (GameEntity ent : entities)
			if (ent instanceof Collideable) 
				filtered.add((Collideable)ent);
		
		return filtered;
	}

	private boolean overLap(BoundCircle first, BoundCircle second){
		int width = first.getX() - second.getX();
		int height = first.getY() - second.getY();
		double distance = Math.sqrt(width*width + height*height);
		if (distance <= first.getRadius() + second.getRadius())
			return true;
		else
			return false;
	}
}