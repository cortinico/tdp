import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class GameFacade extends UnicastRemoteObject implements RemoteGame {
	
	private static final long serialVersionUID = 1L;

	private GameDisplay game;
	
	private GameEnvironment gameEnv;
	private WindowDecorator gameDecorator;
	
	private List<KeyEventManager> managers;
	
	private boolean windowed = false;
	
	public GameFacade() throws RemoteException { }
	
	public GameFacade(boolean windowed) throws RemoteException {		
		gameEnv = GameEnvironment.getInstance();
		gameDecorator = new WindowDecorator(gameEnv);
		this.windowed = windowed;
		
		if (windowed)
			game = gameDecorator;
		else
			game = gameEnv;
		
		managers = new ArrayList<>();
	}
	
	public static void main(String[] args) {
		try {
			RemoteGame game = new GameFacade();
			Naming.bind("RemoteGame", game);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void playGame() {
		gameEnv.start();
	}

	public void stopGame() {
		gameEnv.stop();
	}
	
	public void render() {
		game.render(new GraphicEnvironment());
	}
	
	public void addPlayer(char left, char right, char propel, char fire) {
		SpaceShip newShip = new SpaceShip(0, 0, 0);
		gameEnv.addEntity(newShip);
		managers.add(new KeyEventManager(game, newShip, left, right, propel, fire));
	}
	
	public void setWindowed(boolean windowed){
		if (windowed == this.windowed) return;
		this.windowed = windowed;
		
		if (windowed)
			game = gameDecorator;
		else
			game = gameEnv;
	}
}
