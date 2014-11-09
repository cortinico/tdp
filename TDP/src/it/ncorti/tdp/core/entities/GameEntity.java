package it.ncorti.tdp.core.entities;

import it.ncorti.tdp.graphics.DrawStrategy;
import it.ncorti.tdp.graphics.Drawable;
import it.ncorti.tdp.graphics.GraphicEnvironment;

/**
 * Classe astratta che rappresenta un entita' del gioco.
 * Mantiene i riferimenti ad uno stato dell'entita' e ad una strategia di gioco 
 * 
 * @author Nicola Corti
 */
public abstract class GameEntity implements Drawable, Collideable {
	
	/** Coordinata x dell'entita' */
	protected int x;
	/** Coordinata y dell'entita' */
	protected int y;
	
	/** Stato dell'entita' */
	private EntityState state;
	/** Strategia di gioco */
	private DrawStrategy strategy;
	
	/**
	 * Costruttore base che crea una nuova entita' di gioco.
	 * Lo state e lo strategy vengono creati con il Factory Method
	 * 
	 * @param x Coordinata x dell'entita'
	 * @param y Coordinata y dell'entita'
	 */
	public GameEntity(int x, int y) {
		this.x = x;
		this.y = y;
		this.state = createInitialState();
		this.strategy = createInitialStrategy();
	}
	
	/**
	 * Factory method che crea lo stato in cui parte l'entita' di gioco
	 * 
	 * @return Stato iniziale dell'entita' di gioco
	 */
	protected abstract EntityState createInitialState();
	
	/**
	 * Factory method che crea la strategia per disegnare l'entita' di gioco
	 * 
	 * @return Strategia di disegno dell'entita'
	 */
	protected abstract DrawStrategy createInitialStrategy();

	/**
	 * Ritorna la coordinata x dell'entita'
	 * 
	 * @return La coordinata x dell'entita'
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Ritorna la coordinata y dell'entita'
	 * 
	 * @return La coordinata y dell'entita'
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Metodo che viene invocato ad ogni ciclo del gioco
	 * per indicare come si evolve l'entita' dal punto di vista fisico
	 * (velocita', spostamento, inseguimento, etc...)
	 * 
	 */
	public abstract void evolveEntity();
	
	/**
	 * Aggiorna lo stato dell'entita' di gioco
	 * 
	 * @param state Nuovo stato dell'entita' di gioco
	 */
	protected void setState(EntityState state){
		this.state = state;
	}
	
	/**
	 * Aggiorna la strategia di disegno dell'entita
	 * 
	 * @param state Nuova strategia di disegno dell'entita' di gioco
	 */
	protected void setStrategy(DrawStrategy strategy){
		this.strategy = strategy;
	}
	
	
	/**
	 * Indica se l'entita' di gioco e' stata distrutta
	 * 
	 * @return True se l'entita' e' stata distrutta
	 */
	public boolean isDestroyed(){
		return this.state.isDestroyed();
	}
	
	/**
	 * Muove l'entita' fisica dalle coordinati iniziali, verso un angolo angle alla velocita' speed
	 * 
	 * @param angle Angolo di movimento
	 * @param speed Velocita' di movimento
	 */
	protected void physicMove(double angle, int speed){
		
		// Nota: questa formula fisica non e' stata testata a fondo
		this.x += Math.cos(Math.toRadians(angle)) * speed;
		this.y += Math.sin(Math.toRadians(angle)) * speed;
	}
	
	/* (non-Javadoc)
	 * @see it.ncorti.tdp.graphics.Drawable#draw(it.ncorti.tdp.graphics.GraphicEnvironment)
	 */
	@Override
	public void draw(GraphicEnvironment g) {
		this.strategy.drawEntities(g, state.getGraphicEntities());
	}
	

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.Collideable#getBoundCircle()
	 */
	public BoundCircle getBoundCircle(){
		return new BoundCircle(getX(), getY(), CollisionConcreteMediator.BND_RADIUS);
	}
	
	
	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.Collideable#collideWith(it.ncorti.tdp.core.entities.Collideable)
	 */
	public void collideWith(Collideable c){
		this.state.collide(this, c);
	}
}
