package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import mundo.Preguntas;

public class PreguntasGeneralView extends View {	
	
	@FXML
	private Button nextButtonVentas;
	
	@FXML
	private Button backButtonVentas;
	
	@FXML
	private RadioButton true1InitVentas;
	
	@FXML
	private RadioButton true2InitVentas;
	
	@FXML
	private RadioButton true3InitVentas;
	
	@FXML
	private RadioButton true4InitVentas;
	
	@FXML
	private RadioButton true5InitVentas;
	
	@FXML
	private RadioButton false1InitVentas;
	
	@FXML
	private RadioButton false2InitVentas;
	
	@FXML
	private RadioButton false3InitVentas;
	
	@FXML
	private RadioButton false4InitVentas;
	
	@FXML
	private RadioButton false5InitVentas;

	private boolean[] respuestas;

	@Override
	public void init(Main main) {
		respuestas = new boolean[5];
		System.out.println("Antes del init");
		super.init(main);
		
		nextButtonVentas.setOnAction((evt)->{
			System.out.println("Se hace click!");
			try {
			     if (true1InitVentas.isSelected() && !false1InitVentas.isSelected()) {
			    	 respuestas[0] = true;
			     }else {
			    	 respuestas[0] = false;
			     }
			     if (true2InitVentas.isSelected() && !false2InitVentas.isSelected()) {
			    	 respuestas[1] = true;
			     }else {
			    	 respuestas[1] = false;
			     }
			     if (true3InitVentas.isSelected() && !false3InitVentas.isSelected()) {
			    	 respuestas[2] = true;
			     }else {
			    	 respuestas[2] = false;
			     }
			     if (true4InitVentas.isSelected() && !false4InitVentas.isSelected()) {
			    	 respuestas[3] = true;
			     }else {
			    	 respuestas[3] = false;
			     }
			     if (true5InitVentas.isSelected() && !false5InitVentas.isSelected()) {
			    	 respuestas[4] = true;
			     }else {
			    	 respuestas[4] = false;
			     }
			    
			     main.setRespuestasTotal(respuestas);
//			     main.getSistema().getPreguntasParaLaRecomendacion().setRespuestasSector(respuestas);
			     main.initActionThrid();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		backButtonVentas.setOnAction((evt)->{
			System.out.println("Se hace click hacia atra!");
			try {
				main.goBackAction();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}


	public RadioButton getTrue1InitVentas() {
		return true1InitVentas;
	}


	public void setTrue1InitVentas(RadioButton true1InitVentas) {
		this.true1InitVentas = true1InitVentas;
	}


	public RadioButton getTrue2InitVentas() {
		return true2InitVentas;
	}


	public void setTrue2InitVentas(RadioButton true2InitVentas) {
		this.true2InitVentas = true2InitVentas;
	}


	public RadioButton getTrue3InitVentas() {
		return true3InitVentas;
	}


	public void setTrue3InitVentas(RadioButton true3InitVentas) {
		this.true3InitVentas = true3InitVentas;
	}


	public RadioButton getTrue4InitVentas() {
		return true4InitVentas;
	}


	public void setTrue4InitVentas(RadioButton true4InitVentas) {
		this.true4InitVentas = true4InitVentas;
	}


	public RadioButton getTrue5InitVentas() {
		return true5InitVentas;
	}


	public void setTrue5InitVentas(RadioButton true5InitVentas) {
		this.true5InitVentas = true5InitVentas;
	}


	public RadioButton getFalse1InitVentas() {
		return false1InitVentas;
	}


	public void setFalse1InitVentas(RadioButton false1InitVentas) {
		this.false1InitVentas = false1InitVentas;
	}


	public RadioButton getFalse2InitVentas() {
		return false2InitVentas;
	}


	public void setFalse2InitVentas(RadioButton false2InitVentas) {
		this.false2InitVentas = false2InitVentas;
	}


	public RadioButton getFalse3InitVentas() {
		return false3InitVentas;
	}


	public void setFalse3InitVentas(RadioButton false3InitVentas) {
		this.false3InitVentas = false3InitVentas;
	}


	public RadioButton getFalse4InitVentas() {
		return false4InitVentas;
	}


	public void setFalse4InitVentas(RadioButton false4InitVentas) {
		this.false4InitVentas = false4InitVentas;
	}


	public RadioButton getFalse5InitVentas() {
		return false5InitVentas;
	}


	public void setFalse5InitVentas(RadioButton false5InitVentas) {
		this.false5InitVentas = false5InitVentas;
	}


	
	
	
}
