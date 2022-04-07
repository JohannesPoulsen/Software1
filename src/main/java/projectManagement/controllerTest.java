package projectManagement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class controllerTest{

	
	ProjectApplication application = ProjectApplication.getInstance();
	
	

    @FXML
    private TextField project_leader_TF;

    @FXML
    private TextField project_name_TF;
    
    @FXML
    private ListView<String> list = new ListView<String>();
    
    private ObservableList<String> items =FXCollections.observableArrayList ();

    public void initialize(){
    	for(Project project : application.getProjects()) {
    		items.add(project.getId());
    	}
    	items.add("hej");
        list.setItems(items);
        }
        
    @FXML
    void onCreateProjectClick(ActionEvent event) throws Exception {
    	application.addProject(new Project(project_name_TF.getText()));
    	System.out.println(application.getProjects().size());
    }
    @FXML
    void openManageProjectsClick(ActionEvent event) throws IOException{
    	changeScene("/projectManagement/manageProjectWindow.fxml");
    }

    @FXML
    void openProjectWindowClick(ActionEvent event) throws IOException {
    	changeScene("/projectManagement/CreateProjectWindow.fxml");
    }

    @FXML
    void openRegisterTimeClick(ActionEvent event) {

    }
    @FXML
    void backToMainMenuClick(ActionEvent event) throws IOException {
    	changeScene("/projectManagement/mainMenu.fxml");
    }


    @FXML
    void manageProjectClick(ActionEvent event) throws IOException {

    }

    public void changeScene(String fxml) throws IOException{
    	Parent pane = FXMLLoader.load(
    	           getClass().getResource(fxml));

    	Scene scene = new Scene( pane );
    	Viewer.primaryStage.setScene(scene);
    }



}