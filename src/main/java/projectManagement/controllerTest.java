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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class controllerTest {

	ProjectApplication application = ProjectApplication.getInstance();
	static String selectedProjectID;
	static String selectedProjectIDWithName;
	static String selectedActivity;
	static Developer developerForTimeReg = null;
	@FXML
	private Label currentProjectLeaderLabel = new Label();
	@FXML
	private TextField project_leader_TF;
	@FXML
	private TextField project_name_TF;
	@FXML
	private ListView<String> list = new ListView<String>();
	private ObservableList<String> items = FXCollections.observableArrayList();
	@FXML
	private ListView<String> activityList = new ListView<String>();
	private ObservableList<String> items2 = FXCollections.observableArrayList();
	@FXML
	private TextField activityName;
	@FXML
	private TextField endWeekForActivity;
	@FXML
	private TextField initialsForChangeLeader;
	@FXML
	private TextField startWeekForActivity;
	@FXML
	private TextField nameForChangeProjectName;
	@FXML
	private ListView<String> devList = new ListView<String>();
	private ObservableList<String> items3 = FXCollections.observableArrayList();
	@FXML
	private TextField initialToAddDevToActivity;
	@FXML
	private TextField weekForChangeEnd;
	@FXML
	private TextField weekForChangeStart;
	@FXML
	private Label startWeekCurrent = new Label();
	@FXML
	private Label endWeekCurrent = new Label();
	@FXML
	private Label currentDevTimeRegLabel = new Label();

	@FXML
	private Label timeForActivityLabel = new Label();

	@FXML
	private TextField timeForTimeRegisterTextField;

	@FXML
	private ListView<String> timerRegisterList = new ListView<String>();
	private ObservableList<String> items4 = FXCollections.observableArrayList();

	@FXML
	private Label totalTimeLabel = new Label();

	@FXML
	private TextField userForTimeReg;

	public void initialize() {
		initializeProjectList();
		
		initializeActivityListManageProject();

		initializeDeveloperListEditActivity();

		initializeTimeRegisterActivityList();

	}
	public void initializeProjectList() {
		for (Project project : application.getProjects()) {
			if (project.getName() == "") {
				items.add(project.getId());
			} else {
				items.add(project.getId() + ": " + project.getName());
			}
		}
		list.setItems(items);
	}

	
	public void initializeActivityListManageProject() {
		if (selectedProjectID != null) {
			if (application.getProjectById(selectedProjectID).getProjectLeader() != null) {
				currentProjectLeaderLabel
						.setText(application.getProjectById(selectedProjectID).getProjectLeader().getInitials());
			}
			for (Activity activity : application.getProjectById(selectedProjectID).getActivities()) {
				String item = activity.getName();
				if (activity.isNeedingHelp() == true) {
					items2.add(item + " (Need help)");
				} else {
					items2.add(item);
				}
			}
			activityList.setItems(items2);
		}
	}

	public void initializeDeveloperListEditActivity() {
		if (selectedActivity != null) {
			String start = String.valueOf(
					application.getProjectById(selectedProjectID).getActivityByName(selectedActivity).getStart());
			String end = String.valueOf(
					application.getProjectById(selectedProjectID).getActivityByName(selectedActivity).getEnd());
			startWeekCurrent.setText(start);
			endWeekCurrent.setText(end);
			for (Developer dev : application.getProjectById(selectedProjectID).getActivityByName(selectedActivity)
					.getDevelopers()) {
				items3.add(dev.getInitials());
			}
			devList.setItems(items3);
		}
	}

	public void initializeTimeRegisterActivityList() {
		if (developerForTimeReg != null) {

			for (Activity activity : developerForTimeReg.getActivities()) {
				items4.add(activity.getName());
			}
			timerRegisterList.setItems(items4);
		}
	}
	@FXML
	void registerTimeClick(ActionEvent event) throws Exception {
		Activity act = developerForTimeReg.getActivityByName(timerRegisterList.getSelectionModel().getSelectedItem());
		double hours = Double.parseDouble(timeForTimeRegisterTextField.getText());
		developerForTimeReg.registerTime(hours, act);
		changeScene("/projectManagement/TimeRegisterWindow.fxml");
	}

	@FXML
	void onListTimeRegClick(MouseEvent event) throws IOException {
		String s = "0.0";
		if (timerRegisterList.getSelectionModel().getSelectedItem() != null) {
			currentDevTimeRegLabel.setText(developerForTimeReg.getInitials());
			Activity act = developerForTimeReg
					.getActivityByName(timerRegisterList.getSelectionModel().getSelectedItem());
			if (developerForTimeReg.getRegisteredTimeByActivity(act) != null) {
				TimeRegister tR = developerForTimeReg.getRegisteredTimeByActivity(act);
				s = String.valueOf(tR.getTime());

			}
			timeForActivityLabel.setText(s);
		}
	}

	@FXML
	void continueToTimeRegClick(ActionEvent event) throws IOException {
		if (application.getDeveloperByInitials(userForTimeReg.getText()) != null) {
			developerForTimeReg = application.getDeveloperByInitials(userForTimeReg.getText());
			changeScene("/projectManagement/TimeRegisterWindow.fxml");
		}

	}

	@FXML
	void backToEnterUserInitials(ActionEvent event) throws IOException {
		changeScene("/projectManagement/enterUserForTimeRegWindow.fxml");
	}

	@FXML
	void addDevToActivityClick(ActionEvent event) throws IOException {
		application.getProjectById(selectedProjectID).getActivityByName(selectedActivity)
				.addDeveloperByInitials(initialToAddDevToActivity.getText());
		changeScene("/projectManagement/ManageActivity.fxml");
	}

	@FXML
	void askForHelpClick(ActionEvent event) {
		application.getProjectById(selectedProjectID).getActivityByName(selectedActivity).setNeedingHelp(true);
	}

	@FXML
	void backToManageProjectClick(ActionEvent event) throws IOException {
		Viewer.primaryStage.setTitle(selectedProjectIDWithName);
		selectedActivity = null;
		changeScene("/projectManagement/ProjectWindow.fxml");
	}

	@FXML
	void changeEndForActivityClick(ActionEvent event) throws IOException {
		int end = Integer.parseInt(weekForChangeEnd.getText());
		application.getProjectById(selectedProjectID).getActivityByName(selectedActivity).setEnd(end);
		changeScene("/projectManagement/ManageActivity.fxml");
	}

	@FXML
	void changeStartForAcvityClick(ActionEvent event) throws IOException {
		int start = Integer.parseInt(weekForChangeStart.getText());
		application.getProjectById(selectedProjectID).getActivityByName(selectedActivity).setStart(start);
		changeScene("/projectManagement/ManageActivity.fxml");
	}

	@FXML
	void endActivityClick(ActionEvent event) throws IOException {
		Project project = application.getProjectById(selectedProjectID);
		project.endActivityByName(selectedActivity);
		Viewer.primaryStage.setTitle(selectedProjectIDWithName);
		selectedActivity = null;
		changeScene("/projectManagement/ProjectWindow.fxml");

	}

	@FXML
	void removeDevClick(ActionEvent event) throws IOException {
		Project project = application.getProjectById(selectedProjectID);
		Activity activity = project.getActivityByName(selectedActivity);
		activity.removeDeveloperByInitials(devList.getSelectionModel().getSelectedItem());
		changeScene("/projectManagement/ManageActivity.fxml");
	}

	@FXML
	void onAddActivityClick(ActionEvent event) throws IOException {
		if (activityName != null && startWeekForActivity.getText() == "" && endWeekForActivity.getText() == "") {
			Activity newAct = new Activity(activityName.getText());
			application.getProjectById(selectedProjectID).addActivity(newAct);
			changeScene("/projectManagement/ProjectWindow.fxml");
		} else if (activityName != null && startWeekForActivity.getText() != "" && endWeekForActivity.getText() != "") {
			int start = Integer.parseInt(startWeekForActivity.getText());
			int end = Integer.parseInt(endWeekForActivity.getText());
			Activity newAct = new Activity(activityName.getText(), start, end);
			application.getProjectById(selectedProjectID).addActivity(newAct);
			changeScene("/projectManagement/ProjectWindow.fxml");
		}
	}

	@FXML
	void backToProjects(ActionEvent event) throws IOException {
		Viewer.primaryStage.setTitle("Manage Project");
		changeScene("/projectManagement/manageProjectWindow.fxml");
	}

	@FXML
	void onChangeProjectLeaderClick(ActionEvent event) throws IOException {
		if (application.getDeveloperByInitials(initialsForChangeLeader.getText()) != null) {
			application.getProjectById(selectedProjectID)
					.setProjectLeader(application.getDeveloperByInitials(initialsForChangeLeader.getText()));
			changeScene("/projectManagement/ProjectWindow.fxml");
		}

	}

	@FXML
	void onEditActivityClick(ActionEvent event) throws IOException {
		String selectedItem = activityList.getSelectionModel().getSelectedItem();
		if (selectedItem.length() > 12
				&& selectedItem.substring(selectedItem.length() - 12, selectedItem.length()).equals(" (Need help)")) {
			selectedActivity = selectedItem.substring(0, selectedItem.length() - 12);
		} else {
			selectedActivity = selectedItem;
		}
		if (selectedItem != null) {
			Viewer.primaryStage.setTitle(selectedActivity);
			changeScene("/projectManagement/ManageActivity.fxml");
		}
	}

	@FXML
	void onChangeProjectNameClick(ActionEvent event) throws IOException {
		if (!application.doesProjectExist(nameForChangeProjectName.getText())) {
			application.getProjectById(selectedProjectID).setName(nameForChangeProjectName.getText());
			selectedProjectIDWithName = selectedProjectID + ": " + nameForChangeProjectName.getText();
			Viewer.primaryStage.setTitle(selectedProjectIDWithName);
			changeScene("/projectManagement/ProjectWindow.fxml");

		}
	}

	@FXML
	void onEndProjectClick(ActionEvent event) throws IOException {
		application.endProject(application.getProjectById(selectedProjectID));
		selectedProjectID = null;
		selectedProjectIDWithName = null;
		Viewer.primaryStage.setTitle("Manage Projects");
		changeScene("/projectManagement/manageProjectWindow.fxml");

	}

	@FXML
	void onCreateProjectClick(ActionEvent event) throws Exception {
		if (!application.doesProjectExist(project_name_TF.getText())) {
			Project projectToAdd = new Project(project_name_TF.getText());
			application.addProject(projectToAdd);
			application.setProjectLeaderByInitials(projectToAdd, project_leader_TF.getText());
			changeScene("/projectManagement/mainMenu.fxml");
		}

	}

	@FXML
	void openManageProjectsClick(ActionEvent event) throws IOException {
		Viewer.primaryStage.setTitle("Manage Project");
		changeScene("/projectManagement/manageProjectWindow.fxml");
	}

	@FXML
	void openProjectWindowClick(ActionEvent event) throws IOException {
		Viewer.primaryStage.setTitle("Create Project");
		changeScene("/projectManagement/CreateProjectWindow.fxml");
	}

	@FXML
	void openRegisterTimeClick(ActionEvent event) throws IOException {
		changeScene("/projectManagement/enterUserForTimeRegWindow.fxml");

	}

	@FXML
	void backToMainMenuClick(ActionEvent event) throws IOException {
		Viewer.primaryStage.setTitle("Welcome!");
		changeScene("/projectManagement/mainMenu.fxml");
	}

	@FXML
	void manageProjectClick(ActionEvent event) throws IOException {
		selectedProjectIDWithName = list.getSelectionModel().getSelectedItem();
		selectedProjectID = list.getSelectionModel().getSelectedItem().substring(0, 6);
		Viewer.primaryStage.setTitle(selectedProjectIDWithName);
		changeScene("/projectManagement/ProjectWindow.fxml");

	}

	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		Scene scene = new Scene(pane);
		Viewer.primaryStage.setScene(scene);
	}

}