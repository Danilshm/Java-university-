package iogui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ApplicationLoader extends Application {

	private IOTextPane root;
	private Parent rootWithMenu;
	
	@Override
	public void init() {
		root = new IOTextPane();
		
		//adds root pane to center and menu bar to top. Menu passed a reference to the IOTextPane root for event-handling
		rootWithMenu = new BorderPane(root, new IOMenuBar(root), null, null, null);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("IO GUI");
		Scene scene = new Scene(rootWithMenu);
		scene.getStylesheets().add(this.getClass().getResource("styling.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}


}
