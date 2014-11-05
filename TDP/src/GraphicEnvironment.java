import java.util.ArrayList;


public class GraphicEnvironment {
	
	private ArrayList<GraphicEntity> list = new ArrayList<>();
	
	public void drawSprite(GraphicSprite spriteToDraw){ list.add(spriteToDraw); }
	public void drawVector(GraphicVector vect){ list.add(vect); }
	public void renderOver(){
		System.err.println("@@@ RENDERING TO TERMINAL");
		for (GraphicEntity ent : list){
			ent.drawString();
		}
		list.clear();
	}
}
