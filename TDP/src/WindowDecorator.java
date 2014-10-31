
public class WindowDecorator extends GameDisplay {

	GameDisplay component;
	
	public WindowDecorator(GameDisplay component) {
		this.component = component;
	}
	
	@Override
	public void render() {
		component.render();
		// TODO Aggiunge il  comportamento per la finestra
	}

	@Override
	public void receiveCommand(Command c) {
		if (c instanceof EscCommand){
			// TODO Gestisco la richiesta
		} else {
			component.receiveCommand(c);
		}
		
	}

}
