package main;

import controller.ModuleSelectorController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.StudentProfile;
import view.ModuleSelectorRootPane;

public class ApplicationLoader extends Application {

	@Override
	public void start(Stage primaryStage) {
		StudentProfile model = new StudentProfile();
		ModuleSelectorRootPane view = new ModuleSelectorRootPane();
		new ModuleSelectorController(view, model);

		Scene scene = new Scene(view, 800, 600);
		primaryStage.setTitle("Final Year Module Selection Tool");
		primaryStage.setScene(scene);
		primaryStage.setMinWidth(700);
		primaryStage.setMinHeight(500);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}


}