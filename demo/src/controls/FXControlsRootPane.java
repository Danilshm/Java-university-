package controls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
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
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/** A scene graph of examples of FX UI controls */
public class FXControlsRootPane extends FlowPane {

	public FXControlsRootPane() {
		this.setHgap(20);
		this.setVgap(20);
		this.setPrefWrapLength(600);
		this.setPadding(new Insets(20));
		this.setBackground(new Background(new BackgroundFill(Color.BISQUE, null, null)));

		Label lb = new Label("Hello");
		lb.setFont(Font.font("Calibri", 24));
		lb.setTextFill(Color.BLUE);
		this.getChildren().add(lb);

		TextField tf = new TextField();
		tf.setEditable(true);
		tf.setText("Type in here");
		tf.setAlignment(Pos.CENTER_RIGHT);
		tf.setTooltip(new Tooltip("An editable text field"));
		this.getChildren().add(tf);

		Button btn = new Button("Big button");
		btn.setTooltip(new Tooltip("Press me"));
		btn.setPrefSize(100, 50);
		this.getChildren().add(btn);
		HBox hbox = new HBox(8);
		hbox.setPadding(new Insets(10));
		Tooltip.install(hbox, new Tooltip("A HBox pane with a Textfield and a Button"));
		hbox.setBackground(new Background(new BackgroundFill(Color.CYAN, new CornerRadii(10), null)));
		hbox.setBorder(new Border(
				new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderStroke.MEDIUM)));
		hbox.getChildren().addAll(new TextField("A TextField in a Panel"), new Button("Button"));
		this.getChildren().add(hbox);
		ObservableList<String> choices = FXCollections.observableArrayList(
				"A choice", "B choice", "C choice", "D choice",
				"E choice", "F choice", "G choice", "H choice"
		);
		ComboBox<String> combo = new ComboBox<>(choices);
		combo.setTooltip(new Tooltip("Select an item"));
		combo.getSelectionModel().select(2);
		combo.setVisibleRowCount(5);
		this.getChildren().add(combo);
		Slider slider = new Slider(-32, 212, 100);
		slider.setOrientation(Orientation.VERTICAL);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(50);
		slider.setPrefHeight(140);
		this.getChildren().add(slider);
		ObservableList<String> planets = FXCollections.observableArrayList(
				"Mars", "Jupiter", "Saturn", "Uranus"
		);
		ListView<String> listView = new ListView<>(planets);
		listView.setPrefSize(110, 130);
		this.getChildren().add(listView);

		CheckBox cbOne = new CheckBox("one");
		cbOne.setSelected(true);
		CheckBox cbTwo = new CheckBox("two");
		HBox cbBox = new HBox(10, cbOne, cbTwo);
		cbBox.setAlignment(Pos.CENTER);
		this.getChildren().add(cbBox);

		RadioButton rbSmall = new RadioButton("small");
		RadioButton rbMedium = new RadioButton("medium");
		rbMedium.setSelected(true);
		RadioButton rbLarge = new RadioButton("large");

		ToggleGroup sizeGroup = new ToggleGroup();
		rbSmall.setToggleGroup(sizeGroup);
		rbMedium.setToggleGroup(sizeGroup);
		rbLarge.setToggleGroup(sizeGroup);

		VBox radioBox = new VBox(8, rbSmall, rbMedium, rbLarge);
		radioBox.setPadding(new Insets(10));

		TitledPane titledPane = new TitledPane("Size", radioBox);
		titledPane.setCollapsible(false);
		titledPane.setPrefWidth(120);
		this.getChildren().add(titledPane);

		TextArea textArea = new TextArea("Type\nin\nhere");
		textArea.setPrefSize(90, 100);
		this.getChildren().add(textArea);
	}
}