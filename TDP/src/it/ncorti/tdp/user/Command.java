package it.ncorti.tdp.user;

/**
 * Interfaccia comune per gli oggetti Command
 * 
 * @author Nicola Corti
 */
public interface Command {

	/**
	 * Metodo che deve essere eseguito quando il comando viene invocato
	 */
	public void execute();
}