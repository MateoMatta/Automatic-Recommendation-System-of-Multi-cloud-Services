package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class PreguntasIndustriaView extends View {

	@FXML
	private Button nextButtonIndustria;

	@FXML
	private Button backButtonIndustria;

	@FXML
	private RadioButton true1InitIndustria;

	@FXML
	private RadioButton true2InitIndustria;

	@FXML
	private RadioButton true3InitIndustria;

	@FXML
	private RadioButton true4InitIndustria;

	@FXML
	private RadioButton false1InitIndustria;

	@FXML
	private RadioButton false2InitIndustria;

	@FXML
	private RadioButton false3InitIndustria;

	@FXML
	private RadioButton false4InitIndustria;

	private boolean[] respuestasIndustria;

	@Override
	public void init(Main main) {
		respuestasIndustria = new boolean[4];
//		System.out.println("Antes del init");
		super.init(main);
		nextButtonIndustria.setOnAction((evt) -> {
//			System.out.println("Se hace click!");
			try {
				if (true1InitIndustria.isSelected() && !false1InitIndustria.isSelected()) {
					respuestasIndustria[0] = true;
				} else {
					respuestasIndustria[0] = false;
				}
				if (true2InitIndustria.isSelected() && !false2InitIndustria.isSelected()) {
					respuestasIndustria[1] = true;
				} else {
					respuestasIndustria[1] = false;
				}
				if (true3InitIndustria.isSelected() && !false3InitIndustria.isSelected()) {
					respuestasIndustria[2] = true;
				} else {
					respuestasIndustria[2] = false;
				}
				if (true4InitIndustria.isSelected() && !false4InitIndustria.isSelected()) {
					respuestasIndustria[3] = true;
				} else {
					respuestasIndustria[3] = false;
				}
				boolean[] respuestasActual = main.getRespuestasTotal();
				boolean[] nuevasRespuestas = new boolean[respuestasActual.length + respuestasIndustria.length];
				System.arraycopy(respuestasActual, 0, nuevasRespuestas, 0, respuestasActual.length);
                System.arraycopy(respuestasIndustria, 0, nuevasRespuestas, respuestasActual.length, respuestasIndustria.length);
				main.setRespuestasTotal(nuevasRespuestas);
//			     main.getSistema().getPreguntasParaLaRecomendacion().setRespuestasSector(respuestasIndustria);
				main.initActionSix();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		backButtonIndustria.setOnAction((evt) -> {
//			System.out.println("Se hace click hacia atra!");
			try {
				main.goBackAction();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	public RadioButton getTrue1InitIndustria() {
		return true1InitIndustria;
	}

	public void setTrue1InitIndustria(RadioButton true1InitIndustria) {
		this.true1InitIndustria = true1InitIndustria;
	}

	public RadioButton getTrue2InitIndustria() {
		return true2InitIndustria;
	}

	public void setTrue2InitIndustria(RadioButton true2InitIndustria) {
		this.true2InitIndustria = true2InitIndustria;
	}

	public RadioButton getTrue3InitIndustria() {
		return true3InitIndustria;
	}

	public void setTrue3InitIndustria(RadioButton true3InitIndustria) {
		this.true3InitIndustria = true3InitIndustria;
	}

	public RadioButton getTrue4InitIndustria() {
		return true4InitIndustria;
	}

	public void setTrue4InitIndustria(RadioButton true4InitIndustria) {
		this.true4InitIndustria = true4InitIndustria;
	}

	public RadioButton getFalse1InitIndustria() {
		return false1InitIndustria;
	}

	public void setFalse1InitIndustria(RadioButton false1InitIndustria) {
		this.false1InitIndustria = false1InitIndustria;
	}

	public RadioButton getFalse2InitIndustria() {
		return false2InitIndustria;
	}

	public void setFalse2InitIndustria(RadioButton false2InitIndustria) {
		this.false2InitIndustria = false2InitIndustria;
	}

	public RadioButton getFalse3InitIndustria() {
		return false3InitIndustria;
	}

	public void setFalse3InitIndustria(RadioButton false3InitIndustria) {
		this.false3InitIndustria = false3InitIndustria;
	}

	public RadioButton getFalse4InitIndustria() {
		return false4InitIndustria;
	}

	public void setFalse4InitIndustria(RadioButton false4InitIndustria) {
		this.false4InitIndustria = false4InitIndustria;
	}
	
}
