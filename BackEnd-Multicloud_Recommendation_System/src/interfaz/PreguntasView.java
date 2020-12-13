package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PreguntasView extends View {

	@FXML
	private Button nextButtonInfo;

	@Override
	public void init(Main main) {
		System.out.println("Antes del init z21");
		super.init(main);
		nextButtonInfo.setOnAction((evt)->{
			System.out.println("Se hace click 2!");
			System.out.println(this.getNode("TextID").toString());
			
		});
	}
	
	
	
}
