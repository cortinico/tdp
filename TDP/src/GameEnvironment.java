import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.text.html.parser.Entity;


public class GameEnvironment extends GameDisplay {

	private Timer timer;
	private List<Command> commands;
	private List<GameEntity> entities;
	private CollisionMediator mediator;
	
	private GraphicEnvironment backgroundBuffer;
	private GraphicEnvironment frontBuffer;
	
	public final static int FPS = 25;
	
	private static GameEnvironment env = new GameEnvironment();
	private GameEnvironment() {
		timer = new Timer();
		commands = Collections.synchronizedList(new ArrayList<Command>());
		entities = Collections.synchronizedList(new ArrayList<GameEntity>());
		mediator = new CollisionMediator();
	}
	
	public static GameEnvironment getInstance(){
		return env;
	}
	
	@Override
	public void render(GraphicEnvironment env) {
		  for (GameEntity e: entities)
			  e.draw(env);
	}
	
	public void stub(){
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
				  for (Command cmd: commands)
					  cmd.execute();
				  
				  commands.clear();
				  for (GameEntity e: entities)
					  e.evolveEntity();
				  
				  mediator.checkCollision();
				  
				  render(backgroundBuffer);
				  
				  frontBuffer = backgroundBuffer;
			  }
			}, 1000/FPS, 1000/FPS);
	}
	
	public void rotateSpaceShip(SpaceShip s, int direction){
		s.rotate(direction);
	}

	public void propelSpaceShip(SpaceShip s){
		s.propel();
	}
	
	public void fireSpaceShip(SpaceShip s){
		Missile m = s.shot();
		mediator.addCollideable(m);
	}
	
	@Override
	public void receiveCommand(Command c) {
		commands.add(c);
	}
}
