package register;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/* A loader for the registration form */
public class ApplicationLoader extends Application {

	private RegisterRootPane root;
	
	@Override
	public void init() {
		root = new RegisterRootPane(); //initialise the root pane
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		// set up the stage and scene for the view.
		stage.setTitle("Registration Form - Events");
		stage.setScene(new Scene(root));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
