import java.rmi.Naming;

public class UserClient {

	public static void main(String[] args) {
		try {
			RemoteGame service = (RemoteGame) Naming.lookup("rmi://127.0.0.1/RemoteGame");
			
			service.addPlayer('a', 'd', 'w', 's');
			service.setWindowed(false);
			service.playGame();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
