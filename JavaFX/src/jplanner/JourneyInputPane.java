package jplanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.text.*;

/* A journey input pane that can be used for both
 *  outward and return journeys.
 */
public class JourneyInputPane extends VBox {

	//some controls declared as fields so they can be accessed
	//throughout the class during a later implementation
	private ComboBox<String> hourList;
	private ComboBox<String> minuteList;
	private RadioButton departButton;
	private RadioButton arriveButton;
	private Label journeyLabel;
	private String journeyType;

	public JourneyInputPane(String journeyType) {
		//styling
		this.setStyle("-fx-background-color: #EBF6FF;");
		this.setBorder(new Border(new BorderStroke(Color.web("#000000"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
		
		//---- create and set title label ----
		this.journeyType = journeyType;
		
		journeyLabel = new Label(journeyType);
		journeyLabel.setStyle("-fx-font-weight: bold;");
		
		
		Label time = new Label("Time: ");
		
		//---- create comboBox data models ----
		ObservableList<String> hours = FXCollections.observableArrayList();
		
		DecimalFormat formatter = new DecimalFormat("00"); // two digits

		//"00", "01", "02", .., "23"
		for (int i=0; i<24; i++) {
			hours.add(formatter.format(i));
		}
		
		ObservableList<String> minutes = FXCollections.observableArrayList("00", "15", "30", "45");

		//----create comboBox using the models-----
		hourList = new ComboBox<String>(hours);
		hourList.getSelectionModel().selectFirst();
		minuteList = new ComboBox<String>(minutes);
		minuteList.getSelectionModel().selectFirst();

		//----create buttons and a toggle group-----
		ToggleGroup group = new ToggleGroup();
		
		departButton = new RadioButton("Depart");
		departButton.setSelected(true);
		departButton.setToggleGroup(group);
		
		arriveButton = new RadioButton("Arrive");
		arriveButton.setToggleGroup(group);

		
		//use a combination of horizontal and vertical boxes
		//with spacing and padding to create a uniform layout
		HBox box1 = new HBox();
		box1.getChildren().add(journeyLabel);
		box1.setPadding(new Insets(6,0,0,10));
		
		HBox box2 = new HBox();
		box2.getChildren().addAll(time, hourList, minuteList);
		box2.setSpacing(10);
		box2.setPadding(new Insets(10,20,15,20));
		box2.setAlignment(Pos.CENTER);
		
		VBox box3 = new VBox();
		box3.getChildren().addAll(departButton, arriveButton);
		box3.setSpacing(10);
		box3.setPadding(new Insets(10, 20, 15, 0));
		
		HBox container = new HBox();
		container.getChildren().addAll(box2, box3);
		container.setPadding(new Insets(10, 20, 10, 20));
		
		this.getChildren().addAll(box1, container);
	}
	
	//update the journey type label
	public void setJourneyType(String journeyType) {
		this.journeyType = journeyType;
		journeyLabel.setText(journeyType);
	}

	public String getJourneyType() {
		return journeyType;
	}
	
}
