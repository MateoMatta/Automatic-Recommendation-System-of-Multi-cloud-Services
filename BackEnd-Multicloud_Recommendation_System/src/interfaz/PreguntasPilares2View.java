package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class PreguntasPilares2View extends View {

	@FXML
	private Button nextButtonPilares2;
	
	@FXML
	private Button backButtonPilares2;
	
	@FXML
	private RadioButton true1InitPilares2;
	
	@FXML
	private RadioButton true2InitPilares2;
	
	@FXML
	private RadioButton true3InitPilares2;
	
	@FXML
	private RadioButton true4InitPilares2;
	
	@FXML
	private RadioButton true5InitPilares2;
	
	@FXML
	private RadioButton false1InitPilares2;
	
	@FXML
	private RadioButton false2InitPilares2;
	
	@FXML
	private RadioButton false3InitPilares2;
	
	@FXML
	private RadioButton false4InitPilares2;
	
	@FXML
	private RadioButton false5InitPilares2;

	private boolean[] respuestas;

	@Override
	public void init(Main main) {
		respuestas = new boolean[5];
		super.init(main);
		
		nextButtonPilares2.setOnAction((evt)->{
			try {
			     if (true1InitPilares2.isSelected() && !false1InitPilares2.isSelected()) {
			    	 respuestas[0] = true;
			     }else {
			    	 respuestas[0] = false;
			     }
			     if (true2InitPilares2.isSelected() && !false2InitPilares2.isSelected()) {
			    	 respuestas[1] = true;
			     }else {
			    	 respuestas[1] = false;
			     }
			     if (true3InitPilares2.isSelected() && !false3InitPilares2.isSelected()) {
			    	 respuestas[2] = true;
			     }else {
			    	 respuestas[2] = false;
			     }
			     if (true4InitPilares2.isSelected() && !false4InitPilares2.isSelected()) {
			    	 respuestas[3] = true;
			     }else {
			    	 respuestas[3] = false;
			     }
			     if (true5InitPilares2.isSelected() && !false5InitPilares2.isSelected()) {
			    	 respuestas[4] = true;
			     }else {
			    	 respuestas[4] = false;
			     }
			     boolean[] respuestasActual = main.getRespuestasTotalPilares();
                 boolean[] nuevasRespuestas = new boolean[respuestasActual.length+respuestas.length];
                 System.arraycopy(respuestasActual, 0, nuevasRespuestas, 0, respuestasActual.length);
                 System.arraycopy(respuestas, 0, nuevasRespuestas, respuestasActual.length, respuestas.length);
			     System.out.println("View 2 son :"+respuestas.length);
			     System.out.println("Y el acomulado de View 2 son :"+nuevasRespuestas.length);

                 main.setRespuestasTotalPilares(nuevasRespuestas);
			     main.initActionTen();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		backButtonPilares2.setOnAction((evt)->{
			System.out.println("Se hace click hacia atra!");
			try {
				main.goBackAction();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}


	public RadioButton getTrue1InitPilares2() {
		return true1InitPilares2;
	}


	public void setTrue1InitPilares2(RadioButton true1InitPilares2) {
		this.true1InitPilares2 = true1InitPilares2;
	}


	public RadioButton getTrue2InitPilares2() {
		return true2InitPilares2;
	}


	public void setTrue2InitPilares2(RadioButton true2InitPilares2) {
		this.true2InitPilares2 = true2InitPilares2;
	}


	public RadioButton getTrue3InitPilares2() {
		return true3InitPilares2;
	}


	public void setTrue3InitPilares2(RadioButton true3InitPilares2) {
		this.true3InitPilares2 = true3InitPilares2;
	}


	public RadioButton getTrue4InitPilares2() {
		return true4InitPilares2;
	}


	public void setTrue4InitPilares2(RadioButton true4InitPilares2) {
		this.true4InitPilares2 = true4InitPilares2;
	}


	public RadioButton getTrue5InitPilares2() {
		return true5InitPilares2;
	}


	public void setTrue5InitPilares2(RadioButton true5InitPilares2) {
		this.true5InitPilares2 = true5InitPilares2;
	}


	public RadioButton getFalse1InitPilares2() {
		return false1InitPilares2;
	}


	public void setFalse1InitPilares2(RadioButton false1InitPilares2) {
		this.false1InitPilares2 = false1InitPilares2;
	}


	public RadioButton getFalse2InitPilares2() {
		return false2InitPilares2;
	}


	public void setFalse2InitPilares2(RadioButton false2InitPilares2) {
		this.false2InitPilares2 = false2InitPilares2;
	}


	public RadioButton getFalse3InitPilares2() {
		return false3InitPilares2;
	}


	public void setFalse3InitPilares2(RadioButton false3InitPilares2) {
		this.false3InitPilares2 = false3InitPilares2;
	}


	public RadioButton getFalse4InitPilares2() {
		return false4InitPilares2;
	}


	public void setFalse4InitPilares2(RadioButton false4InitPilares2) {
		this.false4InitPilares2 = false4InitPilares2;
	}


	public RadioButton getFalse5InitPilares2() {
		return false5InitPilares2;
	}


	public void setFalse5InitPilares2(RadioButton false5InitPilares2) {
		this.false5InitPilares2 = false5InitPilares2;
	}

	
	
}
