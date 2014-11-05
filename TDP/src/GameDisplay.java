public abstract class GameDisplay{

	public abstract void renderBorder(GraphicEnvironment env);
	
	public abstract void start();
	public abstract void stop();
	
	public abstract void receiveCommand(Command c);
	
}