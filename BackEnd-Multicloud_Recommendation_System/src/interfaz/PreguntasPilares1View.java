package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class PreguntasPilares1View extends View {

	@FXML
	private Button nextButtonPilares1;
	
	@FXML
	private Button backButtonPilares1;
	
	@FXML
	private RadioButton true1InitPilares1;
	
	@FXML
	private RadioButton true2InitPilares1;
	
	@FXML
	private RadioButton true3InitPilares1;
	
	@FXML
	private RadioButton true4InitPilares1;
	
	@FXML
	private RadioButton true5InitPilares1;
	
	@FXML
	private RadioButton false1InitPilares1;
	
	@FXML
	private RadioButton false2InitPilares1;
	
	@FXML
	private RadioButton false3InitPilares1;
	
	@FXML
	private RadioButton false4InitPilares1;
	
	@FXML
	private RadioButton false5InitPilares1;

	private boolean[] respuestas;

	@Override
	public void init(Main main) {
		respuestas = new boolean[5];
		System.out.println("Antes del init");
		super.init(main);
		
		nextButtonPilares1.setOnAction((evt)->{
			System.out.println("Se hace click!");
			try {
			     if (true1InitPilares1.isSelected() && !false1InitPilares1.isSelected()) {
			    	 respuestas[0] = true;
			     }else {
			    	 respuestas[0] = false;
			     }
			     if (true2InitPilares1.isSelected() && !false2InitPilares1.isSelected()) {
			    	 respuestas[1] = true;
			     }else {
			    	 respuestas[1] = false;
			     }
			     if (true3InitPilares1.isSelected() && !false3InitPilares1.isSelected()) {
			    	 respuestas[2] = true;
			     }else {
			    	 respuestas[2] = false;
			     }
			     if (true4InitPilares1.isSelected() && !false4InitPilares1.isSelected()) {
			    	 respuestas[3] = true;
			     }else {
			    	 respuestas[3] = false;
			     }
			     if (true5InitPilares1.isSelected() && !false5InitPilares1.isSelected()) {
			    	 respuestas[4] = true;
			     }else {
			    	 respuestas[4] = false;
			     }
			    
			     main.setRespuestasTotalPilares(respuestas);
//			     main.getSistema().getPreguntasParaLaRecomendacion().setRespuestasSector(respuestas);
			     main.initActionNine();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		backButtonPilares1.setOnAction((evt)->{
			System.out.println("Se hace click hacia atra!");
			try {
				main.goBackAction();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}


	public RadioButton getTrue1InitPilares1() {
		return true1InitPilares1;
	}


	public void setTrue1InitPilares1(RadioButton true1InitPilares1) {
		this.true1InitPilares1 = true1InitPilares1;
	}


	public RadioButton getTrue2InitPilares1() {
		return true2InitPilares1;
	}


	public void setTrue2InitPilares1(RadioButton true2InitPilares1) {
		this.true2InitPilares1 = true2InitPilares1;
	}


	public RadioButton getTrue3InitPilares1() {
		return true3InitPilares1;
	}


	public void setTrue3InitPilares1(RadioButton true3InitPilares1) {
		this.true3InitPilares1 = true3InitPilares1;
	}


	public RadioButton getTrue4InitPilares1() {
		return true4InitPilares1;
	}


	public void setTrue4InitPilares1(RadioButton true4InitPilares1) {
		this.true4InitPilares1 = true4InitPilares1;
	}


	public RadioButton getTrue5InitPilares1() {
		return true5InitPilares1;
	}


	public void setTrue5InitPilares1(RadioButton true5InitPilares1) {
		this.true5InitPilares1 = true5InitPilares1;
	}


	public RadioButton getFalse1InitPilares1() {
		return false1InitPilares1;
	}


	public void setFalse1InitPilares1(RadioButton false1InitPilares1) {
		this.false1InitPilares1 = false1InitPilares1;
	}


	public RadioButton getFalse2InitPilares1() {
		return false2InitPilares1;
	}


	public void setFalse2InitPilares1(RadioButton false2InitPilares1) {
		this.false2InitPilares1 = false2InitPilares1;
	}


	public RadioButton getFalse3InitPilares1() {
		return false3InitPilares1;
	}


	public void setFalse3InitPilares1(RadioButton false3InitPilares1) {
		this.false3InitPilares1 = false3InitPilares1;
	}


	public RadioButton getFalse4InitPilares1() {
		return false4InitPilares1;
	}


	public void setFalse4InitPilares1(RadioButton false4InitPilares1) {
		this.false4InitPilares1 = false4InitPilares1;
	}


	public RadioButton getFalse5InitPilares1() {
		return false5InitPilares1;
	}


	public void setFalse5InitPilares1(RadioButton false5InitPilares1) {
		this.false5InitPilares1 = false5InitPilares1;
	}

	
}
