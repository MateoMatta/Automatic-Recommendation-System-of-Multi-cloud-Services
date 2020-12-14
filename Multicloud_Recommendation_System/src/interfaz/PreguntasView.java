package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.*;

public class PreguntasView extends View {

	@FXML
	private Button nextButtonInfo;
	
	@FXML
	private CheckBox checkBoxInfo;
	
	@Override
	public void init(Main main) {
//		System.out.println("Checkbox!");
		super.init(main);
		nextButtonInfo.setOnAction((evt)->{
//			System.out.println("ENTRO!");
			if(checkBoxInfo.isSelected()) {
				try {
					main.initActionSecond();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				//Nada
			}
		});
	}
	
	
	
}
