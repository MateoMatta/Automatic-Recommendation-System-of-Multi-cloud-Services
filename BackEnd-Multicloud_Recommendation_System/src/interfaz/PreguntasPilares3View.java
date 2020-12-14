package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class PreguntasPilares3View extends View {

	@FXML
	private Button nextButtonPilares3;
	
	@FXML
	private Button backButtonPilares3;
	
	@FXML
	private RadioButton true1InitPilares3;
	
	@FXML
	private RadioButton true2InitPilares3;
	
	@FXML
	private RadioButton true3InitPilares3;
	
	@FXML
	private RadioButton true4InitPilares3;
	
	@FXML
	private RadioButton true5InitPilares3;
	
	@FXML
	private RadioButton false1InitPilares3;
	
	@FXML
	private RadioButton false2InitPilares3;
	
	@FXML
	private RadioButton false3InitPilares3;
	
	@FXML
	private RadioButton false4InitPilares3;
	
	@FXML
	private RadioButton false5InitPilares3;

	private boolean[] respuestas;

	@Override
	public void init(Main main) {
		respuestas = new boolean[5];
		super.init(main);
		
		nextButtonPilares3.setOnAction((evt)->{
			try {
			     if (true1InitPilares3.isSelected() && !false1InitPilares3.isSelected()) {
			    	 respuestas[0] = true;
			     }else {
			    	 respuestas[0] = false;
			     }
			     if (true2InitPilares3.isSelected() && !false2InitPilares3.isSelected()) {
			    	 respuestas[1] = true;
			     }else {
			    	 respuestas[1] = false;
			     }
			     if (true3InitPilares3.isSelected() && !false3InitPilares3.isSelected()) {
			    	 respuestas[2] = true;
			     }else {
			    	 respuestas[2] = false;
			     }
			     if (true4InitPilares3.isSelected() && !false4InitPilares3.isSelected()) {
			    	 respuestas[3] = true;
			     }else {
			    	 respuestas[3] = false;
			     }
			     if (true5InitPilares3.isSelected() && !false5InitPilares3.isSelected()) {
			    	 respuestas[4] = true;
			     }else {
			    	 respuestas[4] = false;
			     }
			     boolean[] respuestasActual = main.getRespuestasTotalPilares();
                 boolean[] nuevasRespuestas = new boolean[respuestasActual.length+respuestas.length];
                 System.arraycopy(respuestasActual, 0, nuevasRespuestas, 0, respuestasActual.length);
                 System.arraycopy(respuestas, 0, nuevasRespuestas, respuestasActual.length, respuestas.length);
                 main.setRespuestasTotalPilares(nuevasRespuestas);
			     main.initActionEleven();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		backButtonPilares3.setOnAction((evt)->{
			System.out.println("Se hace click hacia atra!");
			try {
				main.goBackAction();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}


	public RadioButton getTrue1InitPilares3() {
		return true1InitPilares3;
	}


	public void setTrue1InitPilares3(RadioButton true1InitPilares3) {
		this.true1InitPilares3 = true1InitPilares3;
	}


	public RadioButton getTrue2InitPilares3() {
		return true2InitPilares3;
	}


	public void setTrue2InitPilares3(RadioButton true2InitPilares3) {
		this.true2InitPilares3 = true2InitPilares3;
	}


	public RadioButton getTrue3InitPilares3() {
		return true3InitPilares3;
	}


	public void setTrue3InitPilares3(RadioButton true3InitPilares3) {
		this.true3InitPilares3 = true3InitPilares3;
	}


	public RadioButton getTrue4InitPilares3() {
		return true4InitPilares3;
	}


	public void setTrue4InitPilares3(RadioButton true4InitPilares3) {
		this.true4InitPilares3 = true4InitPilares3;
	}


	public RadioButton getTrue5InitPilares3() {
		return true5InitPilares3;
	}


	public void setTrue5InitPilares3(RadioButton true5InitPilares3) {
		this.true5InitPilares3 = true5InitPilares3;
	}


	public RadioButton getFalse1InitPilares3() {
		return false1InitPilares3;
	}


	public void setFalse1InitPilares3(RadioButton false1InitPilares3) {
		this.false1InitPilares3 = false1InitPilares3;
	}


	public RadioButton getFalse2InitPilares3() {
		return false2InitPilares3;
	}


	public void setFalse2InitPilares3(RadioButton false2InitPilares3) {
		this.false2InitPilares3 = false2InitPilares3;
	}


	public RadioButton getFalse3InitPilares3() {
		return false3InitPilares3;
	}


	public void setFalse3InitPilares3(RadioButton false3InitPilares3) {
		this.false3InitPilares3 = false3InitPilares3;
	}


	public RadioButton getFalse4InitPilares3() {
		return false4InitPilares3;
	}


	public void setFalse4InitPilares3(RadioButton false4InitPilares3) {
		this.false4InitPilares3 = false4InitPilares3;
	}


	public RadioButton getFalse5InitPilares3() {
		return false5InitPilares3;
	}


	public void setFalse5InitPilares3(RadioButton false5InitPilares3) {
		this.false5InitPilares3 = false5InitPilares3;
	}
	
}
