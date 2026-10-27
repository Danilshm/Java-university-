package jplanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationLoader extends Application {

	private JourneyPlannerRootPane root;
	
	public void init() {
		root = new JourneyPlannerRootPane();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		// set up the stage and scene for the view.
		stage.setTitle("Journey Planner");
		stage.setScene(new Scene(root));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
