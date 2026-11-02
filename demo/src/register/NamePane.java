package register;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

/* A pane that provides an input form for names */
public class NamePane extends GridPane {

	private ComboBox<String> cboTitle;
	private TextField txtSurname, txtFirstName;

	public NamePane() {
		//styling
		this.setPadding(new Insets(20, 20, 20, 20));
		this.setVgap(15);
		this.setHgap(20);
		this.setStyle("-fx-background-color: #EBF6FF;");
		this.setBorder(new Border(new BorderStroke(Color.web("#DADADA"), BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
		this.setAlignment(Pos.CENTER);

		ColumnConstraints column0 = new ColumnConstraints();
		column0.setHalignment(HPos.RIGHT); // right aligns all elements in 1st column

		ColumnConstraints column1 = new ColumnConstraints();
		column1.setHgrow(Priority.ALWAYS); // grows all elements in 2nd column

		//adds the constraints to the GridPane (i.e. this), the first argument applies to the first column, second to the second column, etc
		this.getColumnConstraints().addAll(column0, column1);
		
				
		/* Using ColumnConstraints above is the simplest way of setting an alignment for an entire column.
		 * There are however other approaches. Simply setting the alignment of the Label does nothing, e.g.
		 * 		lblTitle.setAlignment(Pos.CENTER_RIGHT);
		 * This is because by default the label's preferred size is only as big as it requires to display its text.
		 * You can see this by setting a border, e.g.
		 * 		lblTitle.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
		 * You can set the preferred width to a value larger than its default and this will then allow alignment, e.g.
		 * 		lblTitle.setPrefWidth(150);
		 * This is not ideal, as you are having to hardcode the values and this is restrictive.
		 * 
		 * Another approach is to create a HBox containing the Label and set the alignment of the box - this will align
		 * its children (i.e. the label), and the HBox uses the entire space of the GridPane's cell that it is added to, e.g.
		 * 		HBox box = new HBox(lblTitle);
		 * 		box.setAlignment(Pos.CENTER_RIGHT);
		 * 		box.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
		 * A border allows you to see the actual size of the box. This approach is better but still requires you to add each
		 * label to a box and then add the box to the GridPane when setting the cells below.
		 * 
		 * The final option is to use the GridPane's setHalignment method that requires you to pass it the control you are
		 * going to add to the grid and the alignment type:
		 * 		GridPane.setHalignment(lblTitle, HPos.RIGHT);
		 * This would still be required for each Label, therefore it's clear that using ColumnConstraints is the most elegant
		 * solution in this case, but it's useful to appreciate the other options and how alignment generally works.
		 */
		
		
		//create labels
		Label lblTitle = new Label("Title");
		Label lblFirstName = new Label("First name");
		Label lblSurname = new Label("Surname");
	
		// setup combobox
		ObservableList<String> titles = FXCollections.observableArrayList("Mr", "Mrs", "Miss", "Ms", "Dr");
		cboTitle = new ComboBox<String>(titles);
		cboTitle.getSelectionModel().select(0);

		// setup text fields
		txtFirstName = new TextField();
		txtSurname = new TextField();

		//add controls and labels to container
		this.add(lblTitle, 0, 0);
		this.add(cboTitle, 1, 0);
		
		this.add(lblFirstName, 0, 1);
		this.add(txtFirstName, 1, 1);
		
		this.add(txtSurname, 1, 2);
		this.add(lblSurname, 0, 2);
	}

	// clear the input fields
	public void clear() {
		cboTitle.getSelectionModel().selectFirst();
		txtFirstName.setText("");
		txtSurname.setText("");
	}
	
	//returns a string based on the name input fields
	public String getNameInput() {
		String name = "";
		name += cboTitle.getSelectionModel().getSelectedItem();
		name += " " + txtFirstName.getText();
		name += " " + txtSurname.getText();
		return name;
	}

}
