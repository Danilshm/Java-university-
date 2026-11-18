package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.Course;
import java.time.LocalDate;

public class CreateStudentProfilePane extends GridPane {
	private ComboBox<Course> comboCourse = new ComboBox<>();
	private TextField txtPnumber;
	private TextField txtFirstName;
	private TextField txtSurname;
	private TextField txtEmail;
	private DatePicker datePicker;
	private Button btnCreateProfile;

	public CreateStudentProfilePane() {
		setAlignment(Pos.CENTER);
		setHgap(15);
		setVgap(15);
		setPadding(new Insets(20));

		Label lblCourse = new Label("Select course:");
		comboCourse = new ComboBox<>();
		comboCourse.setPrefWidth(200);

		Label lblPnumber = new Label("Input P number:");
		txtPnumber = new TextField();

		Label lblFirstName = new Label("Input first name:");
		txtFirstName = new TextField();

		Label lblSurname = new Label("Input surname:");
		txtSurname = new TextField();

		Label lblEmail = new Label("Input email:");
		txtEmail = new TextField();

		Label lblDate = new Label("Input date:");
		datePicker = new DatePicker(LocalDate.now());

		btnCreateProfile = new Button("Create Profile");

		add(lblCourse, 0, 0);
		add(comboCourse, 1, 0);
		add(lblPnumber, 0, 1);
		add(txtPnumber, 1, 1);
		add(lblFirstName, 0, 2);
		add(txtFirstName, 1, 2);
		add(lblSurname, 0, 3);
		add(txtSurname, 1, 3);
		add(lblEmail, 0, 4);
		add(txtEmail, 1, 4);
		add(lblDate, 0, 5);
		add(datePicker, 1, 5);
		add(btnCreateProfile, 1, 6);
	}
	public void addCourseDataToComboBox(Course[] courses) {
		comboCourse.getItems().addAll(courses);
	}

	public void addCreateStudentProfileHandler(javafx.event.EventHandler<javafx.event.ActionEvent> handler) {
		btnCreateProfile.setOnAction(handler);
	}
	public Course getSelectedCourse() { return comboCourse.getValue(); }
	public ComboBox<Course> getComboCourse() { return comboCourse; }
	public String getStudentPnumber() { return txtPnumber.getText(); }
	public String getFirstName() { return txtFirstName.getText(); }
	public String getSurname() { return txtSurname.getText(); }
	public String getEmail() { return txtEmail.getText(); }
	public LocalDate getSubmissionDate() { return datePicker.getValue(); }
	public Button getBtnCreateProfile() { return btnCreateProfile; }

	public void setStudentDetails(String pnumber, String first, String last, String email, LocalDate date, Course course) {
		txtPnumber.setText(pnumber);
		txtFirstName.setText(first);
		txtSurname.setText(last);
		txtEmail.setText(email);
		if (date != null) datePicker.setValue(date);
		if (course != null) comboCourse.setValue(course);
	}


}