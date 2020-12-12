package interfaz;
	
import javafx.application.*;
import javafx.fxml.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;


public class main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent  root = FXMLLoader.load(getClass().getResource("Interfaz.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(STYLESHEET_MODENA);
			primaryStage.setTitle("Sistema de recomendación de servicios Multi-Cloud");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
