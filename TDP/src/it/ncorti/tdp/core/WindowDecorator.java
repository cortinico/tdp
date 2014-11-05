package it.ncorti.tdp.core;

import it.ncorti.tdp.graphics.GraphicEnvironment;
import it.ncorti.tdp.user.Command;
import it.ncorti.tdp.user.Log;

/**
 * Classe decorator che aggiunge del comportamento alle classi base di {@link GameDisplay}
 * In particolare aggiunge il comportamento per poter visualizzare una finestra
 * 
 * @author nicola
 */
public class WindowDecorator extends GameDisplay {

	/** TAG per le stampe di debug */
	private static final String TAG = "+++++ Decorator";
	
	/** Riferimento all'oggetto che si sta decorando */
	GameDisplay component;
	
	/**Costruttore di base
	 * @param component Riferimento al {@link GameDisplay} che si vuole decorare
	 */
	public WindowDecorator(GameDisplay component) {
		this.component = component;
	}
	
	/* (non-Javadoc)
	 * @see GameDisplay#renderWindow(GraphicEnvironment)
	 */
	@Override
	public void renderWindow(GraphicEnvironment env) {
		component.renderWindow(env);
		Log.e(TAG, "Rendering Window");
	}

	/* (non-Javadoc)
	 * @see GameDisplay#receiveCommand(Command)
	 */
	@Override
	public void receiveCommand(Command c) {
		/*  Qui potrei gestire dei comandi 
		 *  e non recapitarli all'environment
		 */
		component.receiveCommand(c);
		Log.e(TAG, "Command received");
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
