package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class PreguntasPilares5View extends View {

	@FXML
	private Button nextButtonPilares5;
	
	@FXML
	private Button backButtonPilares5;
	
	@FXML
	private RadioButton true1InitPilares5;
	
	@FXML
	private RadioButton true2InitPilares5;
	
	@FXML
	private RadioButton true3InitPilares5;
	
	@FXML
	private RadioButton true4InitPilares5;
	
	@FXML
	private RadioButton true5InitPilares5;
	
	@FXML
	private RadioButton false1InitPilares5;
	
	@FXML
	private RadioButton false2InitPilares5;
	
	@FXML
	private RadioButton false3InitPilares5;
	
	@FXML
	private RadioButton false4InitPilares5;
	
	@FXML
	private RadioButton false5InitPilares5;

	private boolean[] respuestas;

	@Override
	public void init(Main main) {
		respuestas = new boolean[5];
		super.init(main);
		
		nextButtonPilares5.setOnAction((evt)->{
			try {
			     if (true1InitPilares5.isSelected() && !false1InitPilares5.isSelected()) {
			    	 respuestas[0] = true;
			     }else {
			    	 respuestas[0] = false;
			     }
			     if (true2InitPilares5.isSelected() && !false2InitPilares5.isSelected()) {
			    	 respuestas[1] = true;
			     }else {
			    	 respuestas[1] = false;
			     }
			     if (true3InitPilares5.isSelected() && !false3InitPilares5.isSelected()) {
			    	 respuestas[2] = true;
			     }else {
			    	 respuestas[2] = false;
			     }
			     if (true4InitPilares5.isSelected() && !false4InitPilares5.isSelected()) {
			    	 respuestas[3] = true;
			     }else {
			    	 respuestas[3] = false;
			     }
			     if (true5InitPilares5.isSelected() && !false5InitPilares5.isSelected()) {
			    	 respuestas[4] = true;
			     }else {
			    	 respuestas[4] = false;
			     }
			     boolean[] respuestasActual = main.getRespuestasTotalPilares();
                 boolean[] nuevasRespuestas = new boolean[respuestasActual.length+respuestas.length];
                 System.arraycopy(respuestasActual, 0, nuevasRespuestas, 0, respuestasActual.length);
                 System.arraycopy(respuestas, 0, nuevasRespuestas, respuestasActual.length, respuestas.length);
                 main.setRespuestasTotalPilares(nuevasRespuestas);
			     main.initActionThirteen();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		backButtonPilares5.setOnAction((evt)->{
			System.out.println("Se hace click hacia atra!");
			try {
				main.goBackAction();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}


	public RadioButton getTrue1InitPilares5() {
		return true1InitPilares5;
	}


	public void setTrue1InitPilares5(RadioButton true1InitPilares5) {
		this.true1InitPilares5 = true1InitPilares5;
	}


	public RadioButton getTrue2InitPilares5() {
		return true2InitPilares5;
	}


	public void setTrue2InitPilares5(RadioButton true2InitPilares5) {
		this.true2InitPilares5 = true2InitPilares5;
	}


	public RadioButton getTrue3InitPilares5() {
		return true3InitPilares5;
	}


	public void setTrue3InitPilares5(RadioButton true3InitPilares5) {
		this.true3InitPilares5 = true3InitPilares5;
	}


	public RadioButton getTrue4InitPilares5() {
		return true4InitPilares5;
	}


	public void setTrue4InitPilares5(RadioButton true4InitPilares5) {
		this.true4InitPilares5 = true4InitPilares5;
	}


	public RadioButton getTrue5InitPilares5() {
		return true5InitPilares5;
	}


	public void setTrue5InitPilares5(RadioButton true5InitPilares5) {
		this.true5InitPilares5 = true5InitPilares5;
	}


	public RadioButton getFalse1InitPilares5() {
		return false1InitPilares5;
	}


	public void setFalse1InitPilares5(RadioButton false1InitPilares5) {
		this.false1InitPilares5 = false1InitPilares5;
	}


	public RadioButton getFalse2InitPilares5() {
		return false2InitPilares5;
	}


	public void setFalse2InitPilares5(RadioButton false2InitPilares5) {
		this.false2InitPilares5 = false2InitPilares5;
	}


	public RadioButton getFalse3InitPilares5() {
		return false3InitPilares5;
	}


	public void setFalse3InitPilares5(RadioButton false3InitPilares5) {
		this.false3InitPilares5 = false3InitPilares5;
	}


	public RadioButton getFalse4InitPilares5() {
		return false4InitPilares5;
	}


	public void setFalse4InitPilares5(RadioButton false4InitPilares5) {
		this.false4InitPilares5 = false4InitPilares5;
	}


	public RadioButton getFalse5InitPilares5() {
		return false5InitPilares5;
	}


	public void setFalse5InitPilares5(RadioButton false5InitPilares5) {
		this.false5InitPilares5 = false5InitPilares5;
	}
	
	
	
}
