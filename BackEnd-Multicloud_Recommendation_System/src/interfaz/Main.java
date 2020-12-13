package interfaz;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import javafx.application.*;
import javafx.fxml.*;
import javafx.stage.*;
import mundo.Preguntas;
import mundo.SistemaDeRecomendacion;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.event.*;

public class Main extends Application {

	private Stage actualStage;

	private InterfazView interfazView;
	private PreguntasView preguntasView;
	private PreguntasGeneralView preguntasInicialesView;
	private PreguntasFinancieroView preguntasFinanciero;
	private PreguntasCienciasView preguntasCienciasView;
	private PreguntasIndustriaView preguntasIndustriaView;
	private PreguntasTecnologiaView preguntasTecnologiaView;
	private PreguntasBasesDatosView preguntaBaseDatosView;
	private ResultadosView resultadosView;

	private SistemaDeRecomendacion sistema;
	private String[] preguntasSectorVentas;
	private String[] preguntasSectorFinanciero;
	private String[] preguntasCiencias;
	private String[] preguntasIndustria;
	private String[] preguntasTecnologia;
	private boolean[] respuestasTotal;
	private boolean[] respuestasTotalServicios;
	private String sectorGeneral;

	private static String INTERFAZ_VIEW = "Interfaz.fxml";
	private static String PREGUNTAS_VIEW = "Preguntas.fxml";
	private static String PREGUNTAS_INICIALES_VIEW = "PreguntasIniciales.fxml";
	private static String PREGUNTAS_FINANCIERO_VIEW = "PreguntasSectoFinanciero.fxml";
	private static String PREGUNTAS_CIENCIAS_VIEW = "PreguntasCiencias.fxml";
	private static String PREGUNTAS_INDUSTRIA_VIEW = "PreguntasIndustria.fxml";
	private static String PREGUNTAS_TECNOLOGIA_VIEW = "PreguntasTecnologia.fxml";
	private static String RESULTADOS_VIEW = "Resultados.fxml";

	@Override
	public void start(Stage primaryStage) {

		try {
			initViews(primaryStage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initViews(Stage stage) throws Exception {

		FXMLLoader loader = new FXMLLoader(new File("src/interfaz/" + INTERFAZ_VIEW).toURI().toURL());
		InputStream stream = getClass().getResourceAsStream(INTERFAZ_VIEW);
		Pane pane = loader.load(stream);
		interfazView = loader.getController();

		interfazView.setPane(pane);
		Scene scene2 = new Scene(pane);
		stage.setScene(scene2);
		interfazView.setStage(stage);

		interfazView.init(this);
		interfazView.show(true);
	}

	public void initData() {
		try {
			sistema = new SistemaDeRecomendacion();
			setArrayPregSector();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void goBackAction() {

	}

	public void initAction() throws Exception {
		interfazView.show(false);

		if (preguntasView == null) {
			FXMLLoader loader = new FXMLLoader(new File("src/interfaz/" + PREGUNTAS_VIEW).toURI().toURL());
			InputStream stream = getClass().getResourceAsStream(PREGUNTAS_VIEW);
			Pane pane;
			try {
				pane = loader.load(stream);
				preguntasView = loader.getController();
				Scene scene = new Scene(pane);
				Stage stage = new Stage();
				stage.setScene(scene);

				preguntasView.setPane(pane);
				preguntasView.setStage(stage);
				preguntasView.init(this);
				preguntasView.show(true);

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			preguntasView.show(true);
		}
	}

	public void initActionSecond() throws Exception {
		preguntasView.show(false);

		if (preguntasInicialesView == null) {
			FXMLLoader loader = new FXMLLoader(new File("src/interfaz/" + PREGUNTAS_INICIALES_VIEW).toURI().toURL());
			InputStream stream = getClass().getResourceAsStream(PREGUNTAS_INICIALES_VIEW);
			Pane pane;
			try {
				pane = loader.load(stream);
				preguntasInicialesView = loader.getController();
				Scene scene = new Scene(pane);
				Stage stage = new Stage();
				stage.setScene(scene);

				preguntasInicialesView.setPane(pane);
				preguntasInicialesView.setStage(stage);
				preguntasInicialesView.init(this);
				preguntasInicialesView.show(true);

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			preguntasInicialesView.show(true);
		}

	}

	public void initActionThrid() throws Exception {
		preguntasInicialesView.show(false);

		if (preguntasFinanciero == null) {
			FXMLLoader loader = new FXMLLoader(new File("src/interfaz/" + PREGUNTAS_FINANCIERO_VIEW).toURI().toURL());
			InputStream stream = getClass().getResourceAsStream(PREGUNTAS_FINANCIERO_VIEW);
			Pane pane;
			try {
				pane = loader.load(stream);
				preguntasFinanciero = loader.getController();
				Scene scene = new Scene(pane);
				Stage stage = new Stage();
				stage.setScene(scene);

				preguntasFinanciero.setPane(pane);
				preguntasFinanciero.setStage(stage);
				preguntasFinanciero.init(this);
				preguntasFinanciero.show(true);

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			preguntasFinanciero.show(true);
		}
	}

	public void initActionFourth() throws Exception {
		preguntasFinanciero.show(false);

		if (preguntasCienciasView == null) {
			FXMLLoader loader = new FXMLLoader(new File("src/interfaz/" + PREGUNTAS_CIENCIAS_VIEW).toURI().toURL());
			InputStream stream = getClass().getResourceAsStream(PREGUNTAS_CIENCIAS_VIEW);
			Pane pane;
			try {
				pane = loader.load(stream);
				preguntasCienciasView = loader.getController();
				Scene scene = new Scene(pane);
				Stage stage = new Stage();
				stage.setScene(scene);

				preguntasCienciasView.setPane(pane);
				preguntasCienciasView.setStage(stage);
				preguntasCienciasView.init(this);
				preguntasCienciasView.show(true);

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			preguntasCienciasView.show(true);
		}
	}

	public void initActionFive() throws Exception {
		preguntasCienciasView.show(false);

		if (preguntasIndustriaView == null) {
			FXMLLoader loader = new FXMLLoader(new File("src/interfaz/" + PREGUNTAS_INDUSTRIA_VIEW).toURI().toURL());
			InputStream stream = getClass().getResourceAsStream(PREGUNTAS_INDUSTRIA_VIEW);
			Pane pane;
			try {
				pane = loader.load(stream);
				preguntasIndustriaView = loader.getController();
				Scene scene = new Scene(pane);
				Stage stage = new Stage();
				stage.setScene(scene);

				preguntasIndustriaView.setPane(pane);
				preguntasIndustriaView.setStage(stage);
				preguntasIndustriaView.init(this);
				preguntasIndustriaView.show(true);

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			preguntasIndustriaView.show(true);
		}

	}

	public void initActionSix() throws Exception {
		preguntasIndustriaView.show(false);

		if (preguntasTecnologiaView == null) {
			FXMLLoader loader = new FXMLLoader(new File("src/interfaz/" + PREGUNTAS_TECNOLOGIA_VIEW).toURI().toURL());
			InputStream stream = getClass().getResourceAsStream(PREGUNTAS_TECNOLOGIA_VIEW);
			Pane pane;
			try {
				pane = loader.load(stream);
				preguntasTecnologiaView = loader.getController();
				Scene scene = new Scene(pane);
				Stage stage = new Stage();
				stage.setScene(scene);

				preguntasTecnologiaView.setPane(pane);
				preguntasTecnologiaView.setStage(stage);
				preguntasTecnologiaView.init(this);
				preguntasTecnologiaView.show(true);

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			preguntasTecnologiaView.show(true);
		}
	}

	public void initActionSeven() throws Exception {
		// MANDAR LA INFO AL MODELO Y SEGUIR CON LAS OTRAS PREGUNTAS
		sistema.getPreguntasParaLaRecomendacion().setRespuestasSector(respuestasTotal);
		sectorGeneral = sistema.getPreguntasParaLaRecomendacion().interpretarRespuestasSector();
		if (sectorGeneral.equals(Preguntas.NEGOCIOS_TECNOLOGIA)) {
			
		} else {
            
		}

	}

	public void setArrayPregSector() {
		Preguntas pre = this.getSistema().getPreguntasParaLaRecomendacion();
		if (pre.getSector() == null) {
			String[][] preSector = pre.getPreguntasSector();
			for (int i = 0; i < preSector.length; i++) {
				if (preSector[i][0].equals("Negocios con alto uso de tecnologia")) {
					preguntasTecnologia[i] = preSector[i][1];
				} else if (preSector[i][0].equals("Sector ventas")) {
					preguntasSectorVentas[i] = preSector[i][1];
				} else if (preSector[i][0].equals("Sector financiero")) {
					preguntasSectorFinanciero[i] = preSector[i][1];
				} else if (preSector[i][0].equals("Ciencias biologicas y sector sanitario")) {
					preguntasCiencias[i] = preSector[i][1];
				} else if (preSector[i][0].equals("Industria y fabricacion")) {
					preguntasIndustria[i] = preSector[i][1];
				}
			}
		}
	}

	public SistemaDeRecomendacion getSistema() {
		return sistema;
	}

	public void setSistema(SistemaDeRecomendacion sistema) {
		this.sistema = sistema;
	}

	public static void main(String[] args) {
		launch(args);
	}

	public String[] getPreguntasSectorVentas() {
		return preguntasSectorVentas;
	}

	public void setPreguntasSectorVentas(String[] preguntasSectorVentas) {
		this.preguntasSectorVentas = preguntasSectorVentas;
	}

	public String[] getPreguntasSectorFinanciero() {
		return preguntasSectorFinanciero;
	}

	public void setPreguntasSectorFinanciero(String[] preguntasSectorFinanciero) {
		this.preguntasSectorFinanciero = preguntasSectorFinanciero;
	}

	public String[] getPreguntasCiencias() {
		return preguntasCiencias;
	}

	public void setPreguntasCiencias(String[] preguntasCiencias) {
		this.preguntasCiencias = preguntasCiencias;
	}

	public String[] getPreguntasIndustria() {
		return preguntasIndustria;
	}

	public void setPreguntasIndustria(String[] preguntasIndustria) {
		this.preguntasIndustria = preguntasIndustria;
	}

	public String[] getPreguntasTecnologia() {
		return preguntasTecnologia;
	}

	public void setPreguntasTecnologia(String[] preguntasTecnologia) {
		this.preguntasTecnologia = preguntasTecnologia;
	}

	public boolean[] getRespuestasTotal() {
		return respuestasTotal;
	}

	public void setRespuestasTotal(boolean[] respuestasTotal) {
		this.respuestasTotal = respuestasTotal;
	}

	public boolean[] getRespuestasTotalServicios() {
		return respuestasTotalServicios;
	}

	public void setRespuestasTotalServicios(boolean[] respuestasTotalServicios) {
		this.respuestasTotalServicios = respuestasTotalServicios;
	}

	
	
}
