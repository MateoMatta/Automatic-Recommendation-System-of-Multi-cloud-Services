package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ResultadosView extends View {
	
	@FXML
	private TextArea textArea;
	
	@FXML
	private Button buttonFinalizar;
	
	@FXML
	private Button buttonGoToInit;

	@Override
	public void init(Main main) {
		System.out.println("Finalizar!");
		super.init(main);
		buttonFinalizar.setOnAction((evt)->{
           main.dispose();
		});
		buttonGoToInit.setOnAction((evt)->{
			System.out.println("Va a atras");
		});
	}
	

	public TextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(TextArea textArea) {
		this.textArea = textArea;
	}
	
	
}
