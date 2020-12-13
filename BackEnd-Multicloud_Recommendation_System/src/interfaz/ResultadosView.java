package interfaz;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ResultadosView extends View {
	
	private TextArea textArea;
	private Button buttonFinalizar;
	private Button buttonGoToInit;

	@Override
	public void init(Main main) {
		System.out.println("Finalizar!");
		super.init(main);
		buttonFinalizar.setOnAction((evt)->{
			System.out.println("Finaliza");
		//	System.exit(0);
		});
		buttonGoToInit.setOnAction((evt)->{
			System.out.println("Va a atras");
		});
	}
	
	
}
