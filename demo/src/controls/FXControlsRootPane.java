package controls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.StringConverter;

/** A scene graph of examples of FX UI controls */
public class FXControlsRootPane extends FlowPane{

	public FXControlsRootPane() {
		/*
		 * This pane is a FlowPane with left to right layout (by default),
		 * and horizontal and vertical gaps between its children (set as
		 * parameters)
		 */
		//set this FlowPane's properties
		this.setHgap(20);
		this.setVgap(20);
		this.setPrefWrapLength(600);
		this.setPadding(new Insets(20)); // create a 20px margin between
											// flowpane and the window
		this.setBackground(new Background(new BackgroundFill(Color.BISQUE, null, null)));

		
		/*=== Create and add example UI control children to this pane======*/
		
		// --------Label------------------------------
		Label lb = new Label("Hello");
		lb.setFont(Font.font("Calibri", 24));
		lb.setTextFill(Color.BLUE);
		this.getChildren().add(lb);

		// --------TextField---------------------------
		TextField tf = new TextField();
		tf.setEditable(true); // try false
		tf.setText("Type in here");
		tf.setAlignment(Pos.CENTER_RIGHT);
		tf.setTooltip(new Tooltip("An editable text field"));
		this.getChildren().add(tf);

		// --------Button------------------------------
		Button btn = new Button("Big button");
		btn.setTooltip(new Tooltip("Press me"));
		btn.setPrefSize(100, 50);
		this.getChildren().add(btn);

		// ------A Pane with a Text field and a Button----------
		HBox hbox = new HBox(8); // spacing 8
		hbox.setPadding(new Insets(10));
		Tooltip.install(hbox, new Tooltip("A HBox pane with a Textfield and a Button"));
		
		//background fill
		hbox.setBackground(new Background(new BackgroundFill(Color.CYAN, new CornerRadii(10), null)));
		 // add a border
		hbox.setBorder(new Border(
				new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderStroke.MEDIUM)));
		
		hbox.getChildren().addAll(new TextField("A TextField in a Panel"), new Button("Button"));
		// ...to do...

		// --------ComboBox------------------------------
		ObservableList<String> choices 
			= FXCollections.observableArrayList (
					"A choice", "B choice", "C choice", "D choice", 
					"E choice", "F choice", "G choice", "H choice"
		);
		ComboBox<String> combo = new ComboBox<>(choices);
		// ...to do...

		// --------Slider------------------------------
		// ...to do...
		
		// --------ListView--------------------------------
//		ObservableList<String> planets 
//			= // instantiate an ObservableList (see ComboBox above)
		//...to do..

		// --------CheckBox------------------------------
		//...to do...
		
		// --------RadioButtons in a ToggleGroup-----------------
		//...to do...
		
		// --------TextArea----------------------------
		//...to do...
        
	}
}
