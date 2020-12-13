package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class InterfazView extends View {
	
	@FXML
	private Button startButton;

	@Override
	public void init(Main main) {
		super.init(main);
		startButton.setOnAction((evt)->{
			try {
				main.initAction();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	

}
