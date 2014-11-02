import java.util.ArrayList;
import java.util.List;

public class CollisionMediator {

	List<Collideable> objects;
	public static final int BND_RADIUS = 5;
	
	public CollisionMediator(){
		objects = new ArrayList<>();
	}
	
	public void addCollideable(Collideable e){
		objects.add(e);
	}
	
	public void removeCollideable(Collideable e){
		objects.remove(e);
	}
	
	public void checkCollision(){
		for (Collideable first: objects){
			for (Collideable second: objects){
				if (!first.equals(second)){
					BoundCircle firstCircle = first.getBoundCircle();
					BoundCircle secondCircle = second.getBoundCircle();
					if (overLap(firstCircle, secondCircle))
						first.collideWith(second);
				}
			}
		}
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