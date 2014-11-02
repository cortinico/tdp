
public class WindowDecorator extends GameDisplay {

	GameDisplay component;
	
	public WindowDecorator(GameDisplay component) {
		this.component = component;
	}
	
	@Override
	public void render(GraphicEnvironment env) {
		component.render(env);
		/*  Aggiungo la decorazione per la finestra,
		 *  quali bordi, menu, bottoni chiusura, ombre,
		 *  secondo l'ambiente di sistema.
		 */
	}

	@Override
	public void receiveCommand(Command c) {
		/*  Qui potrei gestire dei comandi 
		 *  e non recapitarli all'environment
		 */
		component.receiveCommand(c);
	}

}
