public class GraphicSprite implements GraphicEntity {

	private String file;
	
	public GraphicSprite(String file) {
		this.setFile(file);
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Override
	public String drawString() {
		System.err.println("### DRAWED SPRITE - " + file);
		return null;
	}
}
