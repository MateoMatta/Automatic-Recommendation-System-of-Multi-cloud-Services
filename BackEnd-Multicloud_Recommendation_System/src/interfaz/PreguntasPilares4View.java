package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class PreguntasPilares4View extends View {


	@FXML
	private Button nextButtonPilares4;
	
	@FXML
	private Button backButtonPilares4;
	
	@FXML
	private RadioButton true1InitPilares4;
	
	@FXML
	private RadioButton true2InitPilares4;
	
	@FXML
	private RadioButton true3InitPilares4;
	
	@FXML
	private RadioButton true4InitPilares4;
	
	@FXML
	private RadioButton true5InitPilares4;
	
	@FXML
	private RadioButton false1InitPilares4;
	
	@FXML
	private RadioButton false2InitPilares4;
	
	@FXML
	private RadioButton false3InitPilares4;
	
	@FXML
	private RadioButton false4InitPilares4;
	
	@FXML
	private RadioButton false5InitPilares4;

	private boolean[] respuestas;

	@Override
	public void init(Main main) {
		respuestas = new boolean[5];
		super.init(main);
		
		nextButtonPilares4.setOnAction((evt)->{
			try {
			     if (true1InitPilares4.isSelected() && !false1InitPilares4.isSelected()) {
			    	 respuestas[0] = true;
			     }else {
			    	 respuestas[0] = false;
			     }
			     if (true2InitPilares4.isSelected() && !false2InitPilares4.isSelected()) {
			    	 respuestas[1] = true;
			     }else {
			    	 respuestas[1] = false;
			     }
			     if (true3InitPilares4.isSelected() && !false3InitPilares4.isSelected()) {
			    	 respuestas[2] = true;
			     }else {
			    	 respuestas[2] = false;
			     }
			     if (true4InitPilares4.isSelected() && !false4InitPilares4.isSelected()) {
			    	 respuestas[3] = true;
			     }else {
			    	 respuestas[3] = false;
			     }
			     if (true5InitPilares4.isSelected() && !false5InitPilares4.isSelected()) {
			    	 respuestas[4] = true;
			     }else {
			    	 respuestas[4] = false;
			     }
			     boolean[] respuestasActual = main.getRespuestasTotalPilares();
                 boolean[] nuevasRespuestas = new boolean[respuestasActual.length+respuestas.length];
                 System.arraycopy(respuestasActual, 0, nuevasRespuestas, 0, respuestasActual.length);
                 System.arraycopy(respuestas, 0, nuevasRespuestas, respuestasActual.length, respuestas.length);
                 main.setRespuestasTotalPilares(nuevasRespuestas);
			     main.initActionTwelve();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		backButtonPilares4.setOnAction((evt)->{
			System.out.println("Se hace click hacia atra!");
			try {
				main.goBackAction();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}


	public RadioButton getTrue1InitPilares4() {
		return true1InitPilares4;
	}


	public void setTrue1InitPilares4(RadioButton true1InitPilares4) {
		this.true1InitPilares4 = true1InitPilares4;
	}


	public RadioButton getTrue2InitPilares4() {
		return true2InitPilares4;
	}


	public void setTrue2InitPilares4(RadioButton true2InitPilares4) {
		this.true2InitPilares4 = true2InitPilares4;
	}


	public RadioButton getTrue3InitPilares4() {
		return true3InitPilares4;
	}


	public void setTrue3InitPilares4(RadioButton true3InitPilares4) {
		this.true3InitPilares4 = true3InitPilares4;
	}


	public RadioButton getTrue4InitPilares4() {
		return true4InitPilares4;
	}


	public void setTrue4InitPilares4(RadioButton true4InitPilares4) {
		this.true4InitPilares4 = true4InitPilares4;
	}


	public RadioButton getTrue5InitPilares4() {
		return true5InitPilares4;
	}


	public void setTrue5InitPilares4(RadioButton true5InitPilares4) {
		this.true5InitPilares4 = true5InitPilares4;
	}


	public RadioButton getFalse1InitPilares4() {
		return false1InitPilares4;
	}


	public void setFalse1InitPilares4(RadioButton false1InitPilares4) {
		this.false1InitPilares4 = false1InitPilares4;
	}


	public RadioButton getFalse2InitPilares4() {
		return false2InitPilares4;
	}


	public void setFalse2InitPilares4(RadioButton false2InitPilares4) {
		this.false2InitPilares4 = false2InitPilares4;
	}


	public RadioButton getFalse3InitPilares4() {
		return false3InitPilares4;
	}


	public void setFalse3InitPilares4(RadioButton false3InitPilares4) {
		this.false3InitPilares4 = false3InitPilares4;
	}


	public RadioButton getFalse4InitPilares4() {
		return false4InitPilares4;
	}


	public void setFalse4InitPilares4(RadioButton false4InitPilares4) {
		this.false4InitPilares4 = false4InitPilares4;
	}


	public RadioButton getFalse5InitPilares4() {
		return false5InitPilares4;
	}


	public void setFalse5InitPilares4(RadioButton false5InitPilares4) {
		this.false5InitPilares4 = false5InitPilares4;
	}
	
}
