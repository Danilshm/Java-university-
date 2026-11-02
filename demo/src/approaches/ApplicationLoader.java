package approaches;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationLoader extends Application {

	private Parent root;

	@Override
	/* Build the scene graph in this method */
	public void init() throws Exception {
		root = new EventHandlingExamples();
	}

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(root);
		stage.setTitle("JavaFX Event Handling Examples");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

