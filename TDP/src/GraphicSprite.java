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
}
