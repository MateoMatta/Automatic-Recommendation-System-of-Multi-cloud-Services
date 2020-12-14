package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class PreguntasTecnologiaView extends View {

	@FXML
	private Button nextButtonTecnologia;

	@FXML
	private Button backButtonTecnologia;

	@FXML
	private RadioButton true1InitTecnologia;

	@FXML
	private RadioButton true2InitTecnologia;

	@FXML
	private RadioButton true3InitTecnologia;

	@FXML
	private RadioButton true4InitTecnologia;

	@FXML
	private RadioButton false1InitTecnologia;

	@FXML
	private RadioButton false2InitTecnologia;

	@FXML
	private RadioButton false3InitTecnologia;

	@FXML
	private RadioButton false4InitTecnologia;


	private boolean[] respuestasTecnologia;

	@Override
	public void init(Main main) {
		respuestasTecnologia = new boolean[4];
//		System.out.println("Antes del init");
		super.init(main);

		nextButtonTecnologia.setOnAction((evt) -> {
//			System.out.println("Se hace click!");
			try {
				if (true1InitTecnologia.isSelected() && !false1InitTecnologia.isSelected()) {
					respuestasTecnologia[0] = true;
				} else {
					respuestasTecnologia[0] = false;
				}
				if (true2InitTecnologia.isSelected() && !false2InitTecnologia.isSelected()) {
					respuestasTecnologia[1] = true;
				} else {
					respuestasTecnologia[1] = false;
				}
				if (true3InitTecnologia.isSelected() && !false3InitTecnologia.isSelected()) {
					respuestasTecnologia[2] = true;
				} else {
					respuestasTecnologia[2] = false;
				}
				if (true4InitTecnologia.isSelected() && !false4InitTecnologia.isSelected()) {
					respuestasTecnologia[3] = true;
				} else {
					respuestasTecnologia[3] = false;
				}
				boolean[] respuestasActual = main.getRespuestasTotal();
				boolean[] nuevasRespuestas = new boolean[respuestasActual.length + respuestasTecnologia.length];
				System.arraycopy(respuestasActual, 0, nuevasRespuestas, 0, respuestasActual.length);
                System.arraycopy(respuestasTecnologia, 0, nuevasRespuestas, respuestasActual.length, respuestasTecnologia.length);
				main.setRespuestasTotal(nuevasRespuestas);
				main.initActionSeven();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		backButtonTecnologia.setOnAction((evt) -> {
//			System.out.println("Se hace click hacia atra!");
			try {
				main.goBackAction();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	public RadioButton getTrue1InitTecnologia() {
		return true1InitTecnologia;
	}

	public void setTrue1InitTecnologia(RadioButton true1InitTecnologia) {
		this.true1InitTecnologia = true1InitTecnologia;
	}

	public RadioButton getTrue2InitTecnologia() {
		return true2InitTecnologia;
	}

	public void setTrue2InitTecnologia(RadioButton true2InitTecnologia) {
		this.true2InitTecnologia = true2InitTecnologia;
	}

	public RadioButton getTrue3InitTecnologia() {
		return true3InitTecnologia;
	}

	public void setTrue3InitTecnologia(RadioButton true3InitTecnologia) {
		this.true3InitTecnologia = true3InitTecnologia;
	}

	public RadioButton getTrue4InitTecnologia() {
		return true4InitTecnologia;
	}

	public void setTrue4InitTecnologia(RadioButton true4InitTecnologia) {
		this.true4InitTecnologia = true4InitTecnologia;
	}

	public RadioButton getFalse1InitTecnologia() {
		return false1InitTecnologia;
	}

	public void setFalse1InitTecnologia(RadioButton false1InitTecnologia) {
		this.false1InitTecnologia = false1InitTecnologia;
	}

	public RadioButton getFalse2InitTecnologia() {
		return false2InitTecnologia;
	}

	public void setFalse2InitTecnologia(RadioButton false2InitTecnologia) {
		this.false2InitTecnologia = false2InitTecnologia;
	}

	public RadioButton getFalse3InitTecnologia() {
		return false3InitTecnologia;
	}

	public void setFalse3InitTecnologia(RadioButton false3InitTecnologia) {
		this.false3InitTecnologia = false3InitTecnologia;
	}

	public RadioButton getFalse4InitTecnologia() {
		return false4InitTecnologia;
	}

	public void setFalse4InitTecnologia(RadioButton false4InitTecnologia) {
		this.false4InitTecnologia = false4InitTecnologia;
	}

	
}
