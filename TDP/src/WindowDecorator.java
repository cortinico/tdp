
public class WindowDecorator extends GameDisplay {

	GameDisplay component;
	
	public WindowDecorator(GameDisplay component) {
		this.component = component;
	}
	
	@Override
	public void renderBorder(GraphicEnvironment env) {
		component.renderBorder(env);
		System.err.println("+++++ WINDOW: RENDERING");
	}

	@Override
	public void receiveCommand(Command c) {
		/*  Qui potrei gestire dei comandi 
		 *  e non recapitarli all'environment
		 */
		component.receiveCommand(c);
		System.err.println("+++++ WINDOW: RECEIVED COMMAND");
	}

	@Override
	public void start() {
		component.start();
	}

	@Override
	public void stop() {
		component.stop();
	}

}
