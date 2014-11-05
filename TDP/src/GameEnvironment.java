import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class GameEnvironment extends GameDisplay {

	private Timer timer;
	private List<Command> commands;
	private List<GameEntity> entities;
	private CollisionMediator mediator;
	
	private GraphicEnvironment backgroundBuffer;
	private GraphicEnvironment frontBuffer;
	
	//public final static long FPS = 1;
	public final static long MSEC = 2000;
	
	private static GameEnvironment env = new GameEnvironment();
	private GameEnvironment() {
		timer = new Timer();
		commands = Collections.synchronizedList(new ArrayList<Command>());
		entities = Collections.synchronizedList(new ArrayList<GameEntity>());
		mediator = new CollisionMediator();
		
		frontBuffer = new GraphicEnvironment();
		backgroundBuffer = new GraphicEnvironment();
	}
	
	public static GameEnvironment getInstance(){
		return env;
	}
	
	public void addEntity(GameEntity ent){
		this.entities.add(ent);
	}
	
	public void removeEntity(GameEntity ent){
		this.entities.remove(ent);
	}

	public void renderBorder(GraphicEnvironment env) {
		System.err.println("@@@ DRAW BLACK BOX @@@");
	}

	public void render(GraphicEnvironment env) {
		  for (GameEntity e: entities)
			  e.draw(env);
	}

	
	public void start(){
		
		initialState();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
				  
				  cleanEntities();
				  System.err.println("=== CLEAN ENTITIES ===");
				  
				  for (Command cmd: commands){
					  cmd.execute();
					  System.err.println("!!!!!!!! ESEGUITO UN COMANDO !!!!!!!!!");
				  }
				  
				  System.err.println("=== EXECUTED COMMANDS ===");
				  
				  commands.clear();
				  for (GameEntity e: entities)
					  e.evolveEntity();
				  
				  System.err.println("=== EVOLVED ENTITIES ===");
				  
				  dumpStatus();
				  			  
				  
				  mediator.checkCollision(entities);
				  
				  System.err.println("=== CHECK COLLISION ENTITIES ===");
				  
				  render(backgroundBuffer);
				  
				  System.err.println("=== RENDER BUFFER ===");
				  
				  frontBuffer = backgroundBuffer;
				  
				  renderRealBuffer(frontBuffer);
				  
			  }
			}, MSEC, MSEC);
	}
	
	private void initialState() {
		addEntity(new Cannon(9000, 0));
		addEntity(new PowerBar(2000, 1000, 0));
		addEntity(new PowerBar(3000, 1000, 0));
		addEntity(new PowerBar(4000, 1000, 0));
		addEntity(new Mine(1000, 1000));
		addEntity(new Missile(5000, 5000, 180));
	}

	private void dumpStatus() {
		  for (GameEntity e: entities){
			  System.err.println(e.toString());
			  
		  }
	}
	
	public void stop(){
		timer.cancel();
	}
	
	protected void cleanEntities() {
		for (GameEntity ent: entities){
			if (ent instanceof Mine || ent instanceof PlasmaBall || ent instanceof PowerBar)
				if (ent.isDestroyed()) {
					System.err.println("||| ENTITY CLEANED |||");
					removeEntity(ent);
				}
		}
	}
	
	protected void checkStatus() {
		for (GameEntity ent: entities){
			if (ent instanceof SpaceShip || ent instanceof Cannon)
				if (ent.isDestroyed()) stop();
					System.err.println("||| GAME OVER |||");
		}
	}

	private void renderRealBuffer(GraphicEnvironment buffer) {
		buffer.renderOver();
	}

	public void rotateSpaceShip(SpaceShip s, int direction){
		s.rotate(direction);
	}

	public void propelSpaceShip(SpaceShip s){
		s.propel();
	}
	
	public void fireSpaceShip(SpaceShip s){
		Missile m = s.shot();
		addEntity(m);
		
	}
	
	@Override
	public void receiveCommand(Command c) {
		commands.add(c);
	}
}
