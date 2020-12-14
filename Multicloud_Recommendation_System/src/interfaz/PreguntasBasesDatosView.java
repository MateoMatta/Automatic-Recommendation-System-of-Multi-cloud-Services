package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class PreguntasBasesDatosView extends View {

	@FXML
	private Button nextButtonBasesDatos;

	@FXML
	private Button backButtonBasesDatos;

	@FXML
	private RadioButton true1InitBasesDatos;

	@FXML
	private RadioButton false1InitBasesDatos;
	
	@FXML
	private RadioButton true2InitBasesDatos;

	@FXML
	private RadioButton false2InitBasesDatos;
	
	@FXML
	private RadioButton true3InitBasesDatos;

	@FXML
	private RadioButton false3InitBasesDatos;
	
	private boolean[] respuestasBasesDatos;
	
	@Override
	public void init(Main main) {
		respuestasBasesDatos = new boolean[3];
		super.init(main);
		nextButtonBasesDatos.setOnAction((evt) -> {
//			System.out.println("Se hace click!");
			try {
				if (true1InitBasesDatos.isSelected() && !false1InitBasesDatos.isSelected()) {
					respuestasBasesDatos[0] = true;
				} else {
					respuestasBasesDatos[0] = false;
				}if (true2InitBasesDatos.isSelected() && !false2InitBasesDatos.isSelected()) {
					respuestasBasesDatos[1] = true;
				} else {
					respuestasBasesDatos[1] = false;
					respuestasBasesDatos[2] = false;	
				}
				//OJO AQUI
				if (true2InitBasesDatos.isSelected()) {
					if (true3InitBasesDatos.isSelected() && !false3InitBasesDatos.isSelected()) {
						respuestasBasesDatos[2] = true;
					} else {
						respuestasBasesDatos[2] = false;
					}
				}	
				main.setRespuestasTotalServicios(respuestasBasesDatos);
//			    main.getSistema().getPreguntasParaLaRecomendacion().setRespuestasSector(respuestasBasesDatos);
				main.initActionEigth();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		backButtonBasesDatos.setOnAction((evt) -> {
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
