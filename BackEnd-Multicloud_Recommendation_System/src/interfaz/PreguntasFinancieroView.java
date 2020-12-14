package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class PreguntasFinancieroView extends View {

	@FXML
	private Button nextButtonFinanciero;
	
	@FXML
	private Button backButtonFinanciero;
	
	@FXML
	private RadioButton true1InitFinanciero;
	
	@FXML
	private RadioButton true2InitFinanciero;
	
	@FXML
	private RadioButton true3InitFinanciero;
	
	@FXML
	private RadioButton true4InitFinanciero;
	
	@FXML
	private RadioButton true5InitFinanciero;
	
	@FXML
	private RadioButton false1InitFinanciero;
	
	@FXML
	private RadioButton false2InitFinanciero;
	
	@FXML
	private RadioButton false3InitFinanciero;
	
	@FXML
	private RadioButton false4InitFinanciero;
	
	@FXML
	private RadioButton false5InitFinanciero;

	private boolean[] respuestasFinanciero;

	@Override
	public void init(Main main) {
		respuestasFinanciero = new boolean[4];
		System.out.println("Antes del init");
		super.init(main);
		
		
		nextButtonFinanciero.setOnAction((evt)->{
			System.out.println("Se hace click!");
			try {
			     if (true1InitFinanciero.isSelected() && !false1InitFinanciero.isSelected()) {
			    	 respuestasFinanciero[0] = true;
			     }else {
			    	 respuestasFinanciero[0] = false;
			     }
			     if (true2InitFinanciero.isSelected() && !false2InitFinanciero.isSelected()) {
			    	 respuestasFinanciero[1] = true;
			     }else {
			    	 respuestasFinanciero[1] = false;
			     }
			     if (true3InitFinanciero.isSelected() && !false3InitFinanciero.isSelected()) {
			    	 respuestasFinanciero[2] = true;
			     }else {
			    	 respuestasFinanciero[2] = false;
			     }
			     if (true4InitFinanciero.isSelected() && !false4InitFinanciero.isSelected()) {
			    	 respuestasFinanciero[3] = true;
			     }else {
			    	 respuestasFinanciero[3] = false;
			     }
			     boolean[] respuestasActual = main.getRespuestasTotal();
                 boolean[] nuevasRespuestas = new boolean[respuestasActual.length+respuestasFinanciero.length];
                 System.arraycopy(respuestasActual, 0, nuevasRespuestas, 0, respuestasActual.length);
                 System.arraycopy(respuestasFinanciero, 0, nuevasRespuestas, respuestasActual.length, respuestasFinanciero.length);
                 main.setRespuestasTotal(nuevasRespuestas);
//			     main.getSistema().getPreguntasParaLaRecomendacion().setRespuestasSector(respuestasFinanciero);
			     main.initActionFourth();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		backButtonFinanciero.setOnAction((evt)->{
			System.out.println("Se hace click hacia atra!");
			try {
				main.goBackAction();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}


	public RadioButton getTrue1InitFinanciero() {
		return true1InitFinanciero;
	}


	public void setTrue1InitFinanciero(RadioButton true1InitFinanciero) {
		this.true1InitFinanciero = true1InitFinanciero;
	}


	public RadioButton getTrue2InitFinanciero() {
		return true2InitFinanciero;
	}


	public void setTrue2InitFinanciero(RadioButton true2InitFinanciero) {
		this.true2InitFinanciero = true2InitFinanciero;
	}


	public RadioButton getTrue3InitFinanciero() {
		return true3InitFinanciero;
	}


	public void setTrue3InitFinanciero(RadioButton true3InitFinanciero) {
		this.true3InitFinanciero = true3InitFinanciero;
	}


	public RadioButton getTrue4InitFinanciero() {
		return true4InitFinanciero;
	}


	public void setTrue4InitFinanciero(RadioButton true4InitFinanciero) {
		this.true4InitFinanciero = true4InitFinanciero;
	}


	public RadioButton getTrue5InitFinanciero() {
		return true5InitFinanciero;
	}


	public void setTrue5InitFinanciero(RadioButton true5InitFinanciero) {
		this.true5InitFinanciero = true5InitFinanciero;
	}


	public RadioButton getFalse1InitFinanciero() {
		return false1InitFinanciero;
	}


	public void setFalse1InitFinanciero(RadioButton false1InitFinanciero) {
		this.false1InitFinanciero = false1InitFinanciero;
	}


	public RadioButton getFalse2InitFinanciero() {
		return false2InitFinanciero;
	}


	public void setFalse2InitFinanciero(RadioButton false2InitFinanciero) {
		this.false2InitFinanciero = false2InitFinanciero;
	}


	public RadioButton getFalse3InitFinanciero() {
		return false3InitFinanciero;
	}


	public void setFalse3InitFinanciero(RadioButton false3InitFinanciero) {
		this.false3InitFinanciero = false3InitFinanciero;
	}


	public RadioButton getFalse4InitFinanciero() {
		return false4InitFinanciero;
	}


	public void setFalse4InitFinanciero(RadioButton false4InitFinanciero) {
		this.false4InitFinanciero = false4InitFinanciero;
	}


	public RadioButton getFalse5InitFinanciero() {
		return false5InitFinanciero;
	}


	public void setFalse5InitFinanciero(RadioButton false5InitFinanciero) {
		this.false5InitFinanciero = false5InitFinanciero;
	}


	
	
}
