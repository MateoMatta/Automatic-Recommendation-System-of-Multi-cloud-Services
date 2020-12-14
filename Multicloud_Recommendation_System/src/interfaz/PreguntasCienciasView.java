package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class PreguntasCienciasView extends View {
	@FXML
	private Button nextButtonCiencias;

	@FXML
	private Button backButtonCiencias;

	@FXML
	private RadioButton true1InitCiencias;

	@FXML
	private RadioButton true2InitCiencias;

	@FXML
	private RadioButton true3InitCiencias;

	@FXML
	private RadioButton true4InitCiencias;

	@FXML
	private RadioButton false1InitCiencias;

	@FXML
	private RadioButton false2InitCiencias;

	@FXML
	private RadioButton false3InitCiencias;

	@FXML
	private RadioButton false4InitCiencias;


	private boolean[] respuestasCiencias;

	@Override
	public void init(Main main) {
		respuestasCiencias = new boolean[4];
		System.out.println("Antes del init");
		super.init(main);

		nextButtonCiencias.setOnAction((evt) -> {
			System.out.println("Se hace click!");
			try {
				if (true1InitCiencias.isSelected() && !false1InitCiencias.isSelected()) {
					respuestasCiencias[0] = true;
				} else {
					respuestasCiencias[0] = false;
				}
				if (true2InitCiencias.isSelected() && !false2InitCiencias.isSelected()) {
					respuestasCiencias[1] = true;
				} else {
					respuestasCiencias[1] = false;
				}
				if (true3InitCiencias.isSelected() && !false3InitCiencias.isSelected()) {
					respuestasCiencias[2] = true;
				} else {
					respuestasCiencias[2] = false;
				}
				if (true4InitCiencias.isSelected() && !false4InitCiencias.isSelected()) {
					respuestasCiencias[3] = true;
				} else {
					respuestasCiencias[3] = false;
				}
				boolean[] respuestasActual = main.getRespuestasTotal();
				boolean[] nuevasRespuestas = new boolean[respuestasActual.length + respuestasCiencias.length];
				System.arraycopy(respuestasActual, 0, nuevasRespuestas, 0, respuestasActual.length);
                System.arraycopy(respuestasCiencias, 0, nuevasRespuestas, respuestasActual.length, respuestasCiencias.length);
				main.setRespuestasTotal(nuevasRespuestas);
//			     main.getSistema().getPreguntasParaLaRecomendacion().setRespuestasSector(respuestasCiencias);
				main.initActionFive();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		backButtonCiencias.setOnAction((evt) -> {
			System.out.println("Se hace click hacia atra!");
			try {
				main.goBackAction();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	public RadioButton getTrue1InitCiencias() {
		return true1InitCiencias;
	}

	public void setTrue1InitCiencias(RadioButton true1InitCiencias) {
		this.true1InitCiencias = true1InitCiencias;
	}

	public RadioButton getTrue2InitCiencias() {
		return true2InitCiencias;
	}

	public void setTrue2InitCiencias(RadioButton true2InitCiencias) {
		this.true2InitCiencias = true2InitCiencias;
	}

	public RadioButton getTrue3InitCiencias() {
		return true3InitCiencias;
	}

	public void setTrue3InitCiencias(RadioButton true3InitCiencias) {
		this.true3InitCiencias = true3InitCiencias;
	}

	public RadioButton getTrue4InitCiencias() {
		return true4InitCiencias;
	}

	public void setTrue4InitCiencias(RadioButton true4InitCiencias) {
		this.true4InitCiencias = true4InitCiencias;
	}

	public RadioButton getFalse1InitCiencias() {
		return false1InitCiencias;
	}

	public void setFalse1InitCiencias(RadioButton false1InitCiencias) {
		this.false1InitCiencias = false1InitCiencias;
	}

	public RadioButton getFalse2InitCiencias() {
		return false2InitCiencias;
	}

	public void setFalse2InitCiencias(RadioButton false2InitCiencias) {
		this.false2InitCiencias = false2InitCiencias;
	}

	public RadioButton getFalse3InitCiencias() {
		return false3InitCiencias;
	}

	public void setFalse3InitCiencias(RadioButton false3InitCiencias) {
		this.false3InitCiencias = false3InitCiencias;
	}

	public RadioButton getFalse4InitCiencias() {
		return false4InitCiencias;
	}

	public void setFalse4InitCiencias(RadioButton false4InitCiencias) {
		this.false4InitCiencias = false4InitCiencias;
	}



}
