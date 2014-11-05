import java.rmi.Remote;
import java.rmi.RemoteException;


public interface RemoteGame extends Remote {

	public void playGame() throws RemoteException;
	public void stopGame() throws RemoteException;
	
	public KeyEventManager addPlayer(char left, char right, char propel, char fire) throws RemoteException;
	public void setWindowed(boolean windowed) throws RemoteException;
}
