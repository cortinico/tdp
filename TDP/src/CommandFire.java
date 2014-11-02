
public class CommandFire implements Command {

	private SpaceShip owner;
	
	public CommandFire(SpaceShip owner) {
		this.owner = owner;
	}
	
	@Override
	public void execute() {
		GameEnvironment.getInstance().fireSpaceShip(owner);
	}
}
