package register;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/* A pane to hold the buttons that operate the registration form */
public class ButtonPane extends HBox {

	private NamePane np; //holds references to the name and view panes
	private ViewPane vp;
	
	public ButtonPane(NamePane np, ViewPane vp) {
		
		this.np = np; //initialises name and view panes
		this.vp = vp;
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(15);

		Button addBtn = new Button("Add");
		//TO DO - add button handler
		
		Button clearBtn = new Button("Clear");
		//TO DO - clear button handler
		
		Button removeBtn = new Button("Remove"); 
		//TO DO - remove button handler
		
		Button submitBtn = new Button("Submit");
		//attaches an event handler that retrieves the contents of the ListView, then iterates and prints them
		submitBtn.setOnAction(e -> vp.getContents().forEach(IO::println));
		
		this.getChildren().addAll(addBtn, clearBtn, removeBtn, submitBtn);
		
		for (Node n : this.getChildren()) {
			((Button) n).setPrefSize(70, 30); //set preferred size for each button
		}
		
	}

}
