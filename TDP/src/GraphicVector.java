public class GraphicVector implements GraphicEntity {

	private int beginX;
	private int beginY;
	private int endX;
	private int endY;
	private int color;
	
	private String message;

	public GraphicVector(int beginX, int beginY, int endX, int endY, int color) {
		this.setBeginX(beginX);
		this.setBeginY(beginY);
		this.setEndX(endX);
		this.setEndY(endY);
		this.setColor(color);
		this.message = "MANUAL VECT";
	}
	
	public GraphicVector(String message) {
		this.setBeginX(0);
		this.setBeginY(0);
		this.setEndX(0);
		this.setEndY(0);
		this.setColor(0);
		this.message = message;
	}

	public int getBeginX() {
		return beginX;
	}

	public void setBeginX(int beginX) {
		this.beginX = beginX;
	}

	public int getBeginY() {
		return beginY;
	}

	public void setBeginY(int beginY) {
		this.beginY = beginY;
	}

	public int getEndX() {
		return endX;
	}

	public void setEndX(int endX) {
		this.endX = endX;
	}

	public int getEndY() {
		return endY;
	}

	public void setEndY(int endY) {
		this.endY = endY;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	@Override
	public String drawString() {
		System.err.println("### DRAWED VECT - " + message);
		return null;
	}

}
