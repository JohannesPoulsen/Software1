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
	static String selectedProjectID;
	static String selectedProjectIDWithName;
	

    @FXML
    private TextField project_leader_TF;

    @FXML
    private TextField project_name_TF;
    
    @FXML
    private ListView<String> list = new ListView<String>();
    
    private ObservableList<String> items =FXCollections.observableArrayList ();
    @FXML
    private ListView<String> activityList = new ListView<String>();
    
    private ObservableList<String> items2 =FXCollections.observableArrayList ();

    @FXML
    private TextField activityName;

    @FXML
    private TextField endWeekForActivity;

    @FXML
    private TextField initialsForChangeLeader;

    @FXML
    private TextField startWeekForActivity;

    @FXML
    void onAddActivityClick(ActionEvent event) throws IOException{
    	if(activityName != null) {
    		Activity newAct = new Activity(activityName.getText());
    		application.getProjectById(selectedProjectID).addActivity(newAct);
    		changeScene("/projectManagement/ProjectWindow.fxml");
    	}
    }
    @FXML
    void backToProjects(ActionEvent event) throws IOException{
    	changeScene("/projectManagement/manageProjectWindow.fxml");
    }

    @FXML
    void onChangeProjectLeaderClick(ActionEvent event) throws IOException{
    	//application.getProjectById(selectedProjectID).setProjectLeader(application.getDeveloperByInitials(initialsForChangeLeader.getText()));
    	
    	changeScene("/projectManagement/ProjectWindow.fxml");
    }

    @FXML
    void onEndActivityClick(ActionEvent event) {
    	
    }

    @FXML
    void onEndProjectClick(ActionEvent event) throws IOException{
    	application.endProject(application.getProjectById(selectedProjectID));
    	selectedProjectID = null;
    	selectedProjectIDWithName = null;
    	Viewer.primaryStage.setTitle("Manage Projects");
    	changeScene("/projectManagement/manageProjectWindow.fxml");
    	
    }

    public void initialize(){
    	for(Project project : application.getProjects()) {
    		if(project.getName() == "") {
    			items.add(project.getId());
    		} else {
    			items.add(project.getId() + ": " + project.getName());
    		}
    	}
        list.setItems(items);
        if(selectedProjectID != null) {
        	for(Activity activity : application.getProjectById(selectedProjectID).getActivities()) {
        		items2.add(activity.getName());
        		}
        	activityList.setItems(items2);
        	}
        }
    
        
    @FXML
    void onCreateProjectClick(ActionEvent event) throws Exception {
    	if(application.doesProjectExist(project_name_TF.getText())) {
    		
    	}
    	else {
    		Project projectToAdd = new Project(project_name_TF.getText());
    		application.addProject(projectToAdd);
    		application.setProjectLeaderByInitials(projectToAdd, project_leader_TF.getText());
    		changeScene("/projectManagement/mainMenu.fxml");
    	}
    	
    }
    @FXML
    void openManageProjectsClick(ActionEvent event) throws IOException{
    	Viewer.primaryStage.setTitle("Manage Project");
    	changeScene("/projectManagement/manageProjectWindow.fxml");
    }

    @FXML
    void openProjectWindowClick(ActionEvent event) throws IOException {
    	Viewer.primaryStage.setTitle("Create Project");
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
    	selectedProjectIDWithName = list.getSelectionModel().getSelectedItem();
    	selectedProjectID = list.getSelectionModel().getSelectedItem().substring(0,6);
    	Viewer.primaryStage.setTitle(selectedProjectIDWithName);
    	changeScene("/projectManagement/ProjectWindow.fxml");

    }

    public void changeScene(String fxml) throws IOException{
    	Parent pane = FXMLLoader.load(
    	           getClass().getResource(fxml));

    	Scene scene = new Scene( pane );
    	Viewer.primaryStage.setScene(scene);
    }



}