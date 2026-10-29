import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainFxApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Nexus Task Manager");

        Label titleLabel = new Label("Task List:");
        ListView<String> taskList = new ListView<>();

        taskList.getItems().add("Complete Java Assignment");
        taskList.getItems().add("Prepare Team Presentation");

        TextField inputField = new TextField();
        inputField.setPromptText("Enter a new task...");

        Button addButton = new Button("Add Task");
        Button completeButton = new Button("Mark Completed");

        addButton.setOnAction(e -> {
            String text = inputField.getText().trim();

            if (text.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Validation Error");
                alert.setHeaderText(null);
                alert.setContentText("Task title cannot be empty!");
                alert.showAndWait();
                return;
            }

            taskList.getItems().add(text + " [In Progress]");
            inputField.clear();
        });

        completeButton.setOnAction(e -> {
            int selectedIndex = taskList.getSelectionModel().getSelectedIndex();

            if (selectedIndex == -1) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Selection Error");
                alert.setHeaderText(null);
                alert.setContentText("Please select a task from the list first!");
                alert.showAndWait();
                return;
            }

            String oldTask = taskList.getItems().get(selectedIndex);
            taskList.getItems().set(selectedIndex, oldTask + " -> COMPLETED!");
        });

        HBox controlsBox = new HBox(10, inputField, addButton, completeButton);
        VBox rootBox = new VBox(15, titleLabel, taskList, controlsBox);
        rootBox.setPadding(new Insets(20));

        Scene scene = new Scene(rootBox, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}