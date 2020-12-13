package interfaz;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import javafx.application.*;
import javafx.fxml.*;
import javafx.stage.*;
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
	private ResultadosView resultadosView;
	
	private SistemaDeRecomendacion sistema;
	
	private static String INTERFAZ_VIEW = "Interfaz.fxml";
	private static String PREGUNTAS_VIEW = "Preguntas.fxml";
	private static String PREGUNTAS_INICIALES_VIEW = "PreguntasIniciales.fxml";
	private static String RESULTADOS_VIEW = "Resultados.fxml";

	@Override
	public void start(Stage primaryStage) {
		try {
			initViews(primaryStage);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initViews(Stage stage)throws Exception {
			
		FXMLLoader loader = new FXMLLoader(new File("src/interfaz/"+INTERFAZ_VIEW).toURI().toURL());
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
		sistema = new SistemaDeRecomendacion();
	}

    public void goBackAction() {
		
	}
	
	public void initAction() throws Exception {
		interfazView.show(false);
		
		if (preguntasView == null) {
			FXMLLoader loader = new FXMLLoader(new File("src/interfaz/"+PREGUNTAS_VIEW).toURI().toURL());
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
			FXMLLoader loader = new FXMLLoader(new File("src/interfaz/"+PREGUNTAS_INICIALES_VIEW).toURI().toURL());
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

	@FXML
	protected void handleSumitButtonAction(ActionEvent event) {
		System.out.println("GG");
	}

	public static void main(String[] args) {
		launch(args);
	}

	
}
