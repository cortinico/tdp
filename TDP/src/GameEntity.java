public abstract class GameEntity implements Drawable {
	
	protected int x;
	protected int y;
	
	protected EntityState state;
	protected DrawStrategy strategy;
	
	public GameEntity(int x, int y) {
		this.x = x;
		this.y = y;
		this.state = createInitialState();
		this.strategy = createInitialStrategy();
	}
	
	protected abstract EntityState createInitialState();
	protected abstract DrawStrategy createInitialStrategy();

	public void setState(EntityState state){
		this.state = state;
	}

	public void setStrategy(DrawStrategy strategy){
		this.strategy = strategy;
	}
	
	public abstract void evolveEntity();
	
	@Override
	public void draw(GraphicEnvironment g) {
		this.strategy.drawEntity(g, state.getEntity());
	}
	
	public void physicMove(int angle, int speed){
		this.x += Math.cos(angle) * speed;
		this.y += Math.sin(angle) * speed;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}