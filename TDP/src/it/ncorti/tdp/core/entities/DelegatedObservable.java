package it.ncorti.tdp.core.entities;
import java.util.Observable;

/**
 * Classe che estende la visibilita' dei metodi clearChanged e setChanged per utilizzare
 * un oggetto di tipo java.util.Observable con delega 
 * 
 * @author Nicola Corti
 *
 */
public class DelegatedObservable extends Observable {

	/* (non-Javadoc)
	 * @see java.util.Observable#clearChanged()
	 */
	public void clearChanged(){
		super.clearChanged();
	}
	
	/* (non-Javadoc)
	 * @see java.util.Observable#setChanged()
	 */
	public void setChanged(){
		super.setChanged();
	}
}
