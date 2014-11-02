
public class CommandPropel implements Command {

	private SpaceShip owner;
	
	public CommandPropel(SpaceShip owner) {
		this.owner = owner;
	}
	
	@Override
	public void execute() {
		GameEnvironment.getInstance().propelSpaceShip(owner);
	}
}
