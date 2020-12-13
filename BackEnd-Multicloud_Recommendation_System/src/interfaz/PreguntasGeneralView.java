package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PreguntasGeneralView extends View {
	@FXML
	private Button nextButtonIniciales;
	
	@FXML
	private Button backButtonIniciales;

	@Override
	public void init(Main main) {
		System.out.println("Antes del init");
		super.init(main);
		nextButtonIniciales.setOnAction((evt)->{
			System.out.println("Se hace click!");
			try {
				main.initActionSecond();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		backButtonIniciales.setOnAction((evt)->{
			System.out.println("Se hace click hacia atra!");
			try {
				main.goBackAction();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		
	}
}
