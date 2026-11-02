package controls;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FXControlsEventsRootPane extends BorderPane {

	//declared as a field so it can be accessed throughout the class, i.e. in the named inner-class event handlers
	private Label status;

	public FXControlsEventsRootPane() {
		//Pane for status messages
		status = new Label("Placeholder for status messages");
		status.setPadding(new Insets(10, 0, 10, 0));
		status.setFont(Font.font(16));
		StackPane sp = new StackPane();
		sp.getChildren().add(status);


		//Everything else is added to the a FlowPane
		FlowPane flowpane = new FlowPane();
		//set the FlowPane's properties
		flowpane.setHgap(20);
		flowpane.setVgap(20);
		flowpane.setPrefWrapLength(600);
		flowpane.setPadding(new Insets(20));
		flowpane.setBackground(new Background(new BackgroundFill(Color.BISQUE, null, null)));

		//Add the message pane and flow pane to this border pane
		this.setCenter(flowpane);
		this.setBottom(sp);


		/*=== Create and add example UI control children to flowpane pane======*/

		// --------Label------------------------------
		Label lb = new Label("Hello");
		lb.setFont(Font.font("Calibri", 24));
		lb.setTextFill(Color.BLUE);
		flowpane.getChildren().add(lb);

		lb.setOnMouseEntered(e -> status.setText("Mouse entered " + lb.getText() + "(" + e.getX() + "," + e.getY() + ")"));

		lb.setOnMouseExited(e -> {
			status.setText("Mouse exited " + lb.getText() + "(" + e.getX() + "," + e.getY() + ")");
		});

		// --------TextField---------------------------
		TextField tf = new TextField();
		tf.setEditable(true); // try false
		tf.setText("Type in here");
		tf.setAlignment(Pos.CENTER_RIGHT);
		tf.setTooltip(new Tooltip("An editable text field"));
		flowpane.getChildren().add(tf);

		//TO DO - add an event handler to text field by defining a named inner-class towards the bottom of this class called TextFieldHandler() then uncomment line below
		//tf.setOnAction(new TextFieldHandler()); //this will be triggered by hitting the return key when focused inside the textfield)

		// --------Button------------------------------
		Button btn = new Button("Big button");
		btn.setTooltip(new Tooltip("Press me"));
		btn.setPrefSize(100, 50);
		flowpane.getChildren().add(btn);
		
		btn.setOnAction(new BigButtonHandler()); //this attaches a named inner-class event handler defined towards the bottom of this class


		// ------A Pane with a Text field and a Button----------
		HBox hbox = new HBox(8); // spacing 8
		hbox.setPadding(new Insets(10));
		Tooltip.install(hbox, new Tooltip("A HBox pane with a Textfield and a Button"));
		hbox.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderStroke.MEDIUM)));
		hbox.setBackground(new Background(new BackgroundFill(Color.CYAN, new CornerRadii(10), null)));

		//TO DO - pass an event handler to the setOnMousePressed method of the HBox (this can be done in a similar way to the handled mouse events above) 
		

		TextField tf1 = new TextField("A TextField in a Panel");
		Button btn1 = new Button("Button");
		hbox.getChildren().addAll(tf1, btn1);
		flowpane.getChildren().add(hbox);

		tf1.textProperty().addListener((observable, oldValue, newValue) -> status.setText("Text now: " + tf1.getText())); //example of a change listener

		//TO DO - add an event handler to the button using the setOnAction method


		// --------ComboBox------------------------------
		ObservableList<String> choices = FXCollections.observableArrayList ("A choice", "B choice", "C choice",
				"D choice", "E choice", "F choice", "G choice", "H choice");
		ComboBox<String> combo = new ComboBox<>(choices);
		combo.setTooltip(new Tooltip("Select an item"));
		combo.getSelectionModel().select(2);
		combo.setVisibleRowCount(5);
		flowpane.getChildren().add(combo);
		
		combo.valueProperty().addListener((observable, oldValue, newValue) -> status.setText("Old value was " + oldValue + ". New value now " + newValue));

		//TO DO - comment out above listener and attach an event handler using the setOnAction method of the ComboBox. You can output the selected item using combo.getSelectionModel().getSelectedItem()


		// --------Slider------------------------------
		Slider slider = new Slider();
		slider.setOrientation(Orientation.VERTICAL);
		slider.setMax(212);
		slider.setMin(-32);
		slider.setMajorTickUnit(50);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setPrefHeight(120);// .setPrefSize(20, 100);
		slider.setMaxHeight(Control.USE_PREF_SIZE);
		slider.setValue(100);
		flowpane.getChildren().add(slider);

		//TO DO - add a change listener to the valueProperty() and output the new value


		// --------ListView--------------------------------
		ObservableList<String> names = FXCollections.observableArrayList("Mercury", "Venus", "Earth",
				"Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto");
		ListView<String> listView = new ListView<>(names);
		listView.setPrefSize(80, 100);
		listView.setMaxHeight(Control.USE_PREF_SIZE);
		listView.getSelectionModel().select(4);
		listView.scrollTo(5);
		flowpane.getChildren().add(listView);

		//TO DO - add a change listener to the selection model's selectedItemProperty() and output the newly selected item
		

		// --------CheckBox------------------------------
		CheckBox one = new CheckBox("one");
		CheckBox two = new CheckBox("two");
		one.setSelected(true);
		two.setIndeterminate(true);
		HBox hbox1 = new HBox(10);
		hbox1.setAlignment(Pos.CENTER);
		hbox1.getChildren().add(one);
		hbox1.getChildren().add(two);
		flowpane.getChildren().add(hbox1);

		//the named inner-class event handler CheckBoxHandler() (defined towards the bottom of this class) is attached to both checkboxes
		one.setOnAction(new CheckBoxHandler());
		two.setOnAction(new CheckBoxHandler());

		
		// --------RadioButtons in a ToggleGroup-----------------
		RadioButton small= new RadioButton("small");
		small.setUserData("SMALL");
		RadioButton medium= new RadioButton("medium");
		medium.setUserData("MEDIUM");
		RadioButton large= new RadioButton("large");
		large.setUserData("LARGE");

		ToggleGroup group = new ToggleGroup();
		small.setToggleGroup(group);
		medium.setToggleGroup(group);
		large.setToggleGroup(group);
		medium.setSelected(true);

		//The userData set above for each radio button can be accessed via newValue.getUserData().toString()
		group.selectedToggleProperty().addListener((observable, oldToggle, newToggle) -> status.setText(newToggle.getUserData().toString()));
		
		
		VBox vbox = new VBox(8); // spacing 8
		vbox.setPadding(new Insets(10));
		Tooltip.install(vbox, new Tooltip("Select Size"));

		vbox.setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));

		vbox.getChildren().addAll(small, medium, large);
		vbox.setPrefHeight(100);
		vbox.setMaxHeight(Control.USE_PREF_SIZE);

		TitledPane tpane = new TitledPane("Size", vbox);
		tpane.setCollapsible(false);
		tpane.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null, null)));

		flowpane.getChildren().add(tpane);

		// --------TextArea----------------------------
		TextArea textarea = new TextArea("Type\nin\nhere");
		textarea.setPrefColumnCount(15);
		textarea.setPrefHeight(100);
		flowpane.getChildren().add(textarea);

		//TO DO - add a change listener to the textProperty() - you can use the example above shown for the TextField tf1
		
		//TO DO - add a change listener to the focusedProperty() - try and output when focus is gained and lost (hint: the newValue associated with this change listener is a boolean)

	}


	private class BigButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			status.setText(((Button) e.getSource()).getText() + " pressed");
		}
	}
	
	private class CheckBoxHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			CheckBox chk = (CheckBox) e.getSource();
			if (chk.isSelected()) {
				status.setText("Selected " + chk.getText());
			} else {
				status.setText("Unselected " + chk.getText());
			}
		}
	}
	
	//TO DO - inner-class TextFieldHandler (will be very similar to BigButtonHandler as it handles an ActionEvent associated with the TextField)


}
