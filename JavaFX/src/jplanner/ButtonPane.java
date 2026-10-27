package jplanner;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/* A simple button pane, which could have event handlers
 * attached at a later point in time.
 */
public class ButtonPane extends HBox {

	public ButtonPane() {
		//styling
		this.setStyle("-fx-background-color: #D6D6D6;");	
		this.setAlignment(Pos.CENTER_RIGHT);
		this.setSpacing(15);
		this.setPadding(new Insets(10, 20, 10, 0));
		
		//create buttons and set their preferred size
		Button clear = new Button("Clear");
		clear.setPrefSize(70, 30);
	    Button submit = new Button("Submit");
	    submit.setPrefSize(70, 30);
	    
		this.getChildren().addAll(clear, submit);
		
	}

}
