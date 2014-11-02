
public class CommandRotate implements Command {

	SpaceShip owner;
	int direction;
	
	public CommandRotate(SpaceShip owner, int direction) {
		this.owner = owner;
		this.direction = direction;
	}	
	
	@Override
	public void execute() {
		GameEnvironment.getInstance().rotateSpaceShip(owner, direction);
	}
}
