package interfaz;


import java.util.HashMap;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class View {
	
	private Main main;
	
	private Pane pane;
	private Stage stage;
	private HashMap<String, Node> nodes;
	
	public void init(Main main) {
		this.main = main;
		nodes = new HashMap<String, Node>();
		for (Node node : pane.getChildren()) {
			nodes.put(node.getId(), node);
		}
	}
	
	public Node getNode(String id) {
		return nodes.get(id);
	}
	
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public HashMap<String, Node> getNodes() {
		return nodes;
	}

	public void setNodes(HashMap<String, Node> nodes) {
		this.nodes = nodes;
	}

	public Pane getPane() {
		return pane;
	}

	public Stage getStage() {
		return stage;
	}

	public void setPane(Pane pane) {
		this.pane = pane;
	}

	public void setStage(Stage stage) {
		this.stage = stage;

	}

	public void show(boolean show) {
		if (show) {
			stage.show();
		} else if(stage.isShowing()) {
			stage.hide();
		}
	}
	
	
	
	

}