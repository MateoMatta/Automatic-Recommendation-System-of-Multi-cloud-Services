package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class PreguntasMicroserviciosView extends View {

	@FXML
	private Button nextButtonMicroservicios;

	@FXML
	private Button backButtonMicroservicios;

	@FXML
	private RadioButton true1InitMicroservicios;

	@FXML
	private RadioButton false1InitMicroservicios;
	
	@FXML
	private RadioButton true2InitMicroservicios;

	@FXML
	private RadioButton false2InitMicroservicios;
	

	
	private boolean[] respuestasMicroservicios;
	
	@Override
	public void init(Main main) {
		respuestasMicroservicios = new boolean[2];
		super.init(main);
		nextButtonMicroservicios.setOnAction((evt) -> {
//			System.out.println("Se hace click!");
			try {
				if (true1InitMicroservicios.isSelected() && !false1InitMicroservicios.isSelected()) {
					respuestasMicroservicios[0] = true;
				} else {
					respuestasMicroservicios[0] = false;
				}if (true2InitMicroservicios.isSelected() && !false2InitMicroservicios.isSelected()) {
					respuestasMicroservicios[1] = true;
				} else {
					respuestasMicroservicios[1] = false;
				}	

				main.setRespuestasTotalServicios(respuestasMicroservicios);
				main.initActionEigth2();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		backButtonMicroservicios.setOnAction((evt) -> {
//			System.out.println("Se hace click hacia atra!");
			try {
				main.goBackAction();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	public boolean[] getRespuestasMicroservicios() {
		return respuestasMicroservicios;
	}

	public void setRespuestasMicroservicios(boolean[] respuestasMicroservicios) {
		this.respuestasMicroservicios = respuestasMicroservicios;
	}
	
	
}
