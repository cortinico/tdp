import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class GameFacade extends UnicastRemoteObject implements RemoteGame {
	
	private static final long serialVersionUID = 1L;

	private GameDisplay gameDisp;
	
	private GameEnvironment gameEnv;
	private WindowDecorator gameDecorator;
	
	private List<KeyEventManager> managers;
	
	private boolean windowed = false;
	
	public GameFacade() throws RemoteException {
		this(false);
	}
	
	public GameFacade(boolean windowed) throws RemoteException {		
		gameEnv = GameEnvironment.getInstance();
		
		gameDecorator = new WindowDecorator(gameEnv);
		this.windowed = windowed;
		
		if (windowed)
			gameDisp = gameDecorator;
		else
			gameDisp = gameEnv;
		
		managers = new ArrayList<>();
	}

	
	public void playGame() {
		gameDisp.renderBorder(new GraphicEnvironment());
		gameDisp.start();
	}

	public void stopGame() {
		gameDisp.stop();
	}
		
	public KeyEventManager addPlayer(char left, char right, char propel, char fire) {
		SpaceShip newShip = new SpaceShip(0, 0, 0);
		gameEnv.addEntity(newShip);
		KeyEventManager mgr = new KeyEventManager(gameDisp, newShip, left, right, propel, fire);
		managers.add(mgr);
		return mgr;
	}
	
	public void setWindowed(boolean windowed){
		if (windowed == this.windowed) return;
		this.windowed = windowed;
		
		if (windowed)
			gameDisp = gameDecorator;
		else
			gameDisp = gameEnv;
		gameDisp.renderBorder(new GraphicEnvironment());
	}
}
