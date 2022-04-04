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
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/projectManagement/CreateProjectWindow.fxml"));
		primaryStage.setTitle("Create Project");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

}
