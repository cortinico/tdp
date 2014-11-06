package it.ncorti.tdp.core;

import it.ncorti.tdp.core.entities.Cannon;
import it.ncorti.tdp.core.entities.CollisionMediator;
import it.ncorti.tdp.core.entities.GameEntity;
import it.ncorti.tdp.core.entities.Mine;
import it.ncorti.tdp.core.entities.Missile;
import it.ncorti.tdp.core.entities.PlasmaBall;
import it.ncorti.tdp.core.entities.PowerBar;
import it.ncorti.tdp.core.entities.SpaceShip;
import it.ncorti.tdp.graphics.GraphicEnvironment;
import it.ncorti.tdp.user.Command;
import it.ncorti.tdp.user.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Classe base del decorator {@link GameDisplay} Questa classe mantiene i riferimenti agli oggetti dello stato di gioco
 * e si occupa di gestire il ciclo di rendering del videogioco
 * 
 * Mantenuto con pattern Singleton (instanziato eager)
 * 
 * @author nicola
 */
public class GameEngine extends GameDisplay {

	/** TAG per le stampe di debug */
	private static final String TAG = "@@@@@ Engine";

	/** Timer per l'esecuzione del ciclo temporizzato */
	private Timer timer;

	/** Lista di comandi da gestire */
	private List<Command> commands;
	/** Lista di entità di gioco da mantenere */
	private List<GameEntity> entities;
	/** Mediatore delle collisioni */
	private CollisionMediator mediator;

	/** Buffer per il rendering in background */
	private GraphicEnvironment backBuffer;
	/** Buffer per il rendering su schermo */
	private GraphicEnvironment dispBuffer;

	/** Millisecondi a cui temporizzare l'esecuzione del ciclo */
	public final static long MSEC = 2000;
	// public final static long FPS = 1;

	/**
	 * Riferimento all'istanza
	 */
	private static GameEngine env = new GameEngine();

	/**
	 * Costruttore privato
	 */
	private GameEngine() {
		timer = new Timer();

		// Le liste sono sincronizzate per evitare problemi di concorrenza
		commands = Collections.synchronizedList(new ArrayList<Command>());
		entities = Collections.synchronizedList(new ArrayList<GameEntity>());
		mediator = new CollisionMediator();

		dispBuffer = new GraphicEnvironment();
		backBuffer = new GraphicEnvironment();
	}

	/**
	 * Metodo per recuperare il riferimento al GameEngine
	 * 
	 * @return Il riferimento concreto al GameEngine
	 */
	public static GameEngine getInstance() {
		return env;
	}

	/**
	 * Aggiunge un'entità di gioco allo stato
	 * 
	 * @param ent Entità di gioco da aggiungere
	 */
	public void addEntity(GameEntity ent) {
		this.entities.add(ent);
	}

	/**
	 * Rimuove un'entità di gioco dallo stato
	 * 
	 * @param ent Entità di gioco da rimuovere
	 */
	public void removeEntity(GameEntity ent) {
		this.entities.remove(ent);
	}

	/* (non-Javadoc)
	 * @see GameDisplay#renderWindow(GraphicEnvironment) */
	public void renderWindow(GraphicEnvironment env) {

		// Ovviamente qui dovrei mettere i metodi che usano 'env'
		// per disegnare la finestra di gioco full-screen
		Log.e(TAG, "Drawing a black box");
	}

	/* (non-Javadoc)
	 * @see GameDisplay#start() */
	public void start() {

		// Genero lo stato iniziale
		initialState();

		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {

				// Controllo il gameover
				checkStatus();

				// Rimuovo le entità esplose
				cleanEntities();
				Log.e(TAG, "Dead Entity Cleaned");

				// Eseguo i comandi in coda
				for (Command cmd : commands) {
					cmd.execute();
				}

				if (commands.size() > 0) Log.e(TAG, "Commands executed " + commands.size());

				commands.clear();

				// Faccio evolvere lo stato
				for (GameEntity e : entities)
					e.evolveEntity();

				Log.e(TAG, "Evolved state succesfully computed");

				dumpStatus();

				mediator.checkCollision(entities);

				Log.e(TAG, "Collision Checked successfully");

				for (GameEntity e : entities)
					e.draw(backBuffer);

				Log.e(TAG, "Backbuffer Render complete");

				dispBuffer = backBuffer;

				renderRealBuffer(dispBuffer);

				Log.e(TAG, "Render Cycle over! :)");

			}
		}, MSEC, MSEC);
	}

	/* (non-Javadoc)
	 * @see GameDisplay#stop() */
	public void stop() {
		timer.cancel();
	}

	/* (non-Javadoc)
	 * @see GameDisplay#receiveCommand(Command) */
	@Override
	public void receiveCommand(Command c) {
		commands.add(c);
		Log.e(TAG, "Command received");
		
	}

	/**
	 * Funzione che permette di ruotare una navicella in gioco
	 * 
	 * @param s Riferimento alla navicella da routare
	 * @param direction Direzione di rotazione {@link SpaceShip} per le costanti di rotazione
	 */
	public void rotateSpaceShip(SpaceShip s, int direction) {
		s.rotate(direction);
	}

	/**
	 * Funzione che permette di far accelerare una navicella in gioco
	 * 
	 * @param s Riferimento alla navicella da far accelerare
	 */
	public void propelSpaceShip(SpaceShip s) {
		s.propel();
	}

	/**
	 * Funzione che permette di far sparare una navicella in gioco
	 * 
	 * @param s Riferimento alla navicella da far sparare
	 */
	public void fireSpaceShip(SpaceShip s) {
		Missile m = s.shot();
		addEntity(m);
	
	}

	/**
	 * Metodo che genera uno stato iniziale per il gioco
	 */
	private void initialState() {
		addEntity(new Cannon(9000, 0));
		addEntity(new PowerBar(2000, 1000, 0));
		addEntity(new PowerBar(3000, 1000, 0));
		addEntity(new PowerBar(4000, 1000, 0));
		addEntity(new Mine(1000, 1000));
		addEntity(new Missile(5000, 5000, 180));
	}

	/**
	 * Funzione di Debug che stampa lo stato di tutte le entità in gioco
	 */
	private void dumpStatus() {
		for (GameEntity e : entities) {
			Log.e(TAG, ">>>> DUMP STATE >>>> " + e.toString());
		}
	}

	private void cleanEntities() {
		for (GameEntity ent : entities) {
			if (ent instanceof Mine || ent instanceof PlasmaBall || ent instanceof PowerBar) if (ent.isDestroyed()) {
				Log.e(TAG, "I'm about to CLEAN: " + ent);
				removeEntity(ent);
			}
		}
	}

	/**
	 * Funzione di comodo che controlla se il gioco e' in uno stato di Game Over o meno
	 */
	private void checkStatus() {
		for (GameEntity ent : entities) {
			if (ent instanceof SpaceShip || ent instanceof Cannon) {
				if (ent.isDestroyed()) {
					Log.e(TAG, "|||||||||||||||||| GAME OVER ||||||||||||||||||");
					stop();
				}
			}
		}
	}

	/**
	 * Funzione che mostra il buffer calcolato sul monitor
	 */
	private void renderRealBuffer(GraphicEnvironment buffer) {
		buffer.renderOver();
	}
}
