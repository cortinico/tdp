package it.ncorti.tdp.core;

import it.ncorti.tdp.graphics.GraphicEnvironment;
import it.ncorti.tdp.user.Command;

/**
 * Classe astratta padre della gerarchia delle finestre dei videogiochi. Questa classe rappresenta una generica finestra
 * di videogioco
 * 
 * @author Nicola Corti
 *
 */
public abstract class GameDisplay {

	/** Fai partire il videogioco */
	public abstract void start();

	/** Fai fermare il videogioco */
	public abstract void stop();

	/**
	 * Recapita un comando alla finestra
	 * 
	 * @param c Comando recapitato
	 */
	public abstract void sendCommand(Command c);

	/**
	 * Disegna la finestra. Questo metodo deve essere invocato solamente all'avvio del gioco, ed in ogni momento in cui
	 * si desidera modificare la finestra del gioco
	 * 
	 * @param env Ambiente grafico per il rendering della finestra
	 */
	public abstract void renderWindow(GraphicEnvironment env);

}