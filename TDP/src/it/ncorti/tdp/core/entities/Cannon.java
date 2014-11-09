package it.ncorti.tdp.core.entities;
import it.ncorti.tdp.core.GameEngine;
import it.ncorti.tdp.graphics.DrawStrategy;
import it.ncorti.tdp.graphics.DrawVectors;
import it.ncorti.tdp.user.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Cannon extends GameEntity implements Observer {
	
	/** TAG per le stampe di debug */
	private static final String TAG = "CCCCC Cannon";
	
	/** Angolo di rotazione */
	private double angle = 0;
	/** Astronave che si sta seguendo */
	private SpaceShip following;
	
	/*
	 * NOTA: La gestione delle powerbar e' abbastanza approssimativa,
	 * si dovrebbero calcolare gli angoli di rotazioni a partire dal centro del cannone
	 */
	/** Dimensione della powerbar */
	private final static int POWER_BAR_SIZE = 0;  // Attualmente inibito
	/** Spazio occupato dalla powerbar */
	private final static int POWER_BAR_SPACE = 10;
	
	/** Primo anello di barre di energia */
	private List<PowerBar> firstRing = null;
	/** Secondo anello di barre di energia */
	private List<PowerBar> secondRing = null;
	/** Terzo anello di barre di energia */
	private List<PowerBar> thirdRing = null;
		
	public Cannon(int x, int y) {
		super(x, y);
		following = null;
		
		// Genero le barre di energia
		firstRing = secondRing = thirdRing = new ArrayList<>(POWER_BAR_SIZE);
		
		int relativeAngle = 0;
		try{
			relativeAngle = 360 / POWER_BAR_SIZE;
		} catch (Exception e) {};
		
		for(int i = 0; i < POWER_BAR_SIZE; i++){
			firstRing.add(new PowerBar(x+POWER_BAR_SPACE, y, relativeAngle * i));
			secondRing.add(new PowerBar(x+(POWER_BAR_SPACE*2), y, relativeAngle * i));
			thirdRing.add(new PowerBar(x+(POWER_BAR_SPACE*3), y, relativeAngle * i));
		
			GameEngine.getInstance().addEntity(firstRing.get(i));
			GameEngine.getInstance().addEntity(secondRing.get(i));
			GameEngine.getInstance().addEntity(thirdRing.get(i));
		}
			
	}
	
	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.GameEntity#createInitialState()
	 */
	@Override
	protected EntityState createInitialState() {
		return new CannonAliveState();
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.GameEntity#createInitialStrategy()
	 */
	@Override
	protected DrawStrategy createInitialStrategy() {
		return new DrawVectors();
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof SpaceShip){
			this.following = (SpaceShip) arg1;
			Log.e(TAG, "Notify received - Following " + this.following + " - ME: " + toString());
		}
	}

	/* (non-Javadoc)
	 * @see it.ncorti.tdp.core.entities.GameEntity#evolveEntity()
	 */
	@Override
	public void evolveEntity() {
		if (this.following != null){
			
			// Nota: questa formula fisica non e' stata testata a fondo
			double m = (getY() - following.getY()) / (getX() - following.getX());
			double followingAngle = Math.toDegrees(Math.atan(m));
			
			// Faccio evolvere l'angolo verso la navicella
			if (followingAngle > angle)
				angle++;
			else if (followingAngle < angle)
				angle--;
			else {
				// Cannon aligned
				if (checkPowerBars()){
					firePlasmaBall();
				}
				if (checkMineSpawn()){
					spawnMine();
				}
			}
		}
	}

	/**
	 * Metodo che fa sparare una plasmaball
	 */
	private void firePlasmaBall() {
		PlasmaBall ball = new PlasmaBall(getX(), getY(), angle);
		GameEngine.getInstance().addEntity(ball);
	}
	
	/**
	 * Metodo che fa rilasciare una nuova mina
	 */
	private void spawnMine() {
		Mine m = new Mine(getX(), getY());
		GameEngine.getInstance().addEntity(m);
	}

	/**
	 * Metodo che controlla se fra le powerbars c'e' spazio per poter sparare al nemico
	 * 
	 * @return True se c'e' spazio, false altrimenti 
	 */
	private boolean checkPowerBars() {
		/*	Metodo per controllare se c'e' spazio
		 * 	fra gli anelli e quindi sparare.
		 */
		return false;
	}
	
	/**
	 * Metodo che controlla se sono presenti le condizioni per rilasciare una nuova
	 * mina
	 * 
	 * @return True se si puo' generare una nuova mina, false altrimenti
	 */
	private boolean checkMineSpawn() {
		/*	Metodo per controllare se si deve rilasciare una nuova mina
		 */
		return false;
	}
	
	@Override
	public String toString() {
		return "CANNON x:" + getX() + " y:" + getY() + " angle: " + this.angle;
	}
}
