import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class GameEnvironment extends GameDisplay {

	private Timer timer;
	private List<Command> commands;
	
	public final static int FPS = 25;
	
	public GameEnvironment() {
		timer = new Timer();
		commands = Collections.synchronizedList(new ArrayList<Command>());
		
	}
	
	@Override
	public void render() {
		// Render del gioco in una schermata nera.
	}
	
	public void stub(){
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
				  for (Command cmd: commands)
					  cmd.execute();
				  
				  commands.clear();
				  //chechCollisions
				  //renderBackground
				  //render();
			  }
			}, 1000/FPS, 1000/FPS);
	}

	@Override
	public void receiveCommand(Command c) {
		commands.add(c);
	}
}
