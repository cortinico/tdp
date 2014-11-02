public abstract class GameEntity implements Drawable {
	
	protected int x;
	protected int y;
	
	protected EntityState state;
	protected DrawStrategy strategy;
	
	public void setState(EntityState state){
		this.state = state;
	}

	public void setStrategy(DrawStrategy strategy){
		this.strategy = strategy;
	}
	
	@Override
	public void draw(GraphicEnvironment g) {
		this.strategy.drawEntity(g, state.getEntity());
	}
}
