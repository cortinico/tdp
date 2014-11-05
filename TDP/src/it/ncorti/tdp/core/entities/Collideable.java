package it.ncorti.tdp.core.entities;
public interface Collideable {

	public BoundCircle getBoundCircle();
	public void collideWith(Collideable c);
	
}