package tutorials;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Login extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25));
        Text welcomeText = new Text("Welcome");
        grid.add(welcomeText, 0, 0, 2, 1);
        Label userLabel = new Label("User Name:");
        grid.add(userLabel, 0, 1);
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);
        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 2);
        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 2);
        Button btn = new Button("Sign in");
        grid.add(btn, 1, 4);
        Text actionTarget = new Text();
        grid.add(actionTarget, 1, 6);
        btn.setOnAction(e -> {
            actionTarget.setFill(Color.FIREBRICK);
            actionTarget.setText("Button pressed");
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setTitle("JavaFX Welcome");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}