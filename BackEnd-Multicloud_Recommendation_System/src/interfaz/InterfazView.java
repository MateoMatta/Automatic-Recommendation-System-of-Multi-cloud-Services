package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class InterfazView extends View {
	
	@FXML
	private Button startButton;

	@Override
	public void init(Main main) {
		System.out.println("Antes del init");
		super.init(main);
		startButton.setOnAction((evt)->{
			System.out.println("Se hace click!");
			try {
				main.initAction();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	

}
