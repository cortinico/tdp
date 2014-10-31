import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class Follower implements Observer {

	private ArrayList<SpaceShip> seenSpaceShips;
	
	public Follower(){
		seenSpaceShips = new ArrayList<SpaceShip>();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof SpaceShip){
			SpaceShip seen = (SpaceShip) arg;
			seenSpaceShips.add(seen);
		}
	}
	
	public abstract SpaceShip computeWhichFollow();
	public abstract void followTarget(SpaceShip s);
	
	
	public final void follow(){
		SpaceShip toFollow = computeWhichFollow();
		followTarget(toFollow);
		//checkCollision()
	}

}