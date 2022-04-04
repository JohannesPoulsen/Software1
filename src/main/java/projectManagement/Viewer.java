package projectManagement;



import java.net.URL;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Viewer extends Application {
	public static Stage primaryStage;
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) throws Exception{
		Viewer.primaryStage = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("/projectManagement/mainMenu.fxml"));
		primaryStage.setTitle("Welcome!");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

}
