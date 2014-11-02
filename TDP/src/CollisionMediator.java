import java.util.ArrayList;
import java.util.List;

public class CollisionMediator {

	List<Collideable> objects;
	
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
		
		return false;
	}
}