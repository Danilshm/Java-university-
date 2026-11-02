package register;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;

/* A pane to display a list of names added through the registration form */
public class ViewPane extends StackPane {

	private ListView<String> listView;
	private ObservableList<String> names;
	
	public ViewPane() {		
		names = FXCollections.observableArrayList();
		listView = new ListView<>(names);
		listView.setPrefSize(200, 150);
		
		//TO DO - enable multiple selection
		
		this.getChildren().add(listView);
	}
	
	//public interface of methods for this class
	public void addName(String name) {
		names.add(name);
	}
	
	public ObservableList<String> getContents() {
		return names;
	}
	
	public void removeSelectedName() {
		int index = listView.getSelectionModel().getSelectedIndex();
		
		if (index != -1) {
			names.remove(index);
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Selection Error");
			alert.setContentText("Please select an item to remove.");
			alert.showAndWait();
		}
	}
	
	//TO DO - further methods
	
}
