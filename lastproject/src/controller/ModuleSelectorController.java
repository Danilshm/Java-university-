package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.*;
import view.*;

import java.io.*;
import java.time.LocalDate;

public class ModuleSelectorController {

	private ModuleSelectorRootPane view;
	private StudentProfile model;

	private CreateStudentProfilePane cspp;
	private SelectModulesPane smp;
	private ReserveModulesPane rmp;
	private OverviewSelectionPane osp;
	private ModuleSelectorMenuBar msmb;

	public ModuleSelectorController(ModuleSelectorRootPane view, StudentProfile model) {
		this.view = view;
		this.model = model;

		cspp = view.getCreateStudentProfilePane();
		smp = view.getSelectModulesPane();
		rmp = view.getReserveModulesPane();
		osp = view.getOverviewSelectionPane();
		msmb = view.getModuleSelectorMenuBar();

		cspp.addCourseDataToComboBox(createModulesAndCourses());
		this.attachEventHandlers();
	}

	private void attachEventHandlers() {
		cspp.addCreateStudentProfileHandler(new CreateStudentProfileHandler());

		smp.getBtnAdd().setOnAction(e -> addBlock34Module());
		smp.getBtnRemove().setOnAction(e -> removeBlock34Module());
		smp.getBtnReset().setOnAction(e -> resetSelectModules());
		smp.getBtnSubmit().setOnAction(e -> submitModules());

		rmp.getBtnAdd().setOnAction(e -> addReserveModule());
		rmp.getBtnRemove().setOnAction(e -> removeReserveModule());
		rmp.getBtnConfirm().setOnAction(e -> confirmReserveModule());

		osp.getBtnSaveOverview().setOnAction(e -> saveOverviewToFile());

		msmb.addExitHandler(e -> System.exit(0));
		msmb.addSaveHandler(e -> saveStudentProfileBinary());
		msmb.addLoadHandler(e -> loadStudentProfileBinary());
		msmb.addAboutHandler(e -> showAboutDialog());
		view.getTabPane().getSelectionModel().selectedItemProperty().addListener((obs, oldTab, newTab) -> {
			if (newTab.getText().equals("Overview Selection")) {
				populateOverview();
			}
		});
	}

	private class CreateStudentProfileHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			String pNumber = cspp.getStudentPnumber().trim();
			String firstName = cspp.getFirstName().trim();
			String surname = cspp.getSurname().trim();
			String email = cspp.getEmail().trim();
			LocalDate date = cspp.getSubmissionDate();
			Course course = cspp.getSelectedCourse();

			if (pNumber.isEmpty() || firstName.isEmpty() || surname.isEmpty() || email.isEmpty() || course == null || date == null) {
				showAlert(AlertType.ERROR, "Validation Error", "All fields must be filled and a course must be selected.");
				return;
			}

			model.setStudentPnumber(pNumber);
			model.setStudentName(new Name(firstName, surname));
			model.setStudentEmail(email);
			model.setSubmissionDate(date);
			model.setStudentCourse(course);
			model.clearSelectedModules();
			model.clearReservedModules();

			smp.getLstSelectedBlock1().getItems().clear();
			smp.getLstSelectedBlock2().getItems().clear();
			smp.getLstUnselectedBlock34().getItems().clear();
			smp.getLstSelectedBlock34().getItems().clear();

			for (model.Module m : course.getAllModulesOnCourse()) {
				if (m.isMandatory()) {
					if (m.getRunPlan() == Block.BLOCK_1) {
						smp.getLstSelectedBlock1().getItems().add(m);
						model.addSelectedModule(m);
					} else if (m.getRunPlan() == Block.BLOCK_2) {
						smp.getLstSelectedBlock2().getItems().add(m);
						model.addSelectedModule(m);
					} else if (m.getRunPlan() == Block.BLOCK_3_4) {
						smp.getLstSelectedBlock34().getItems().add(m);
						model.addSelectedModule(m);
					}
				} else {
					if (m.getRunPlan() == Block.BLOCK_3_4) {
						smp.getLstUnselectedBlock34().getItems().add(m);
					}
				}
			}

			updateCredits();
			view.getTabPane().getSelectionModel().select(1);
		}
	}

	private void addBlock34Module() {
		model.Module selected = smp.getLstUnselectedBlock34().getSelectionModel().getSelectedItem();
		if (selected != null) {
			smp.getLstUnselectedBlock34().getItems().remove(selected);
			smp.getLstSelectedBlock34().getItems().add(selected);
			updateCredits();
		}
	}

	private void removeBlock34Module() {
		model.Module selected = smp.getLstSelectedBlock34().getSelectionModel().getSelectedItem();
		if (selected != null) {
			if (selected.isMandatory()) {
				showAlert(AlertType.WARNING, "Action Denied", "Cannot remove mandatory modules.");
				return;
			}
			smp.getLstSelectedBlock34().getItems().remove(selected);
			smp.getLstUnselectedBlock34().getItems().add(selected);
			updateCredits();
		}
	}

	private void updateCredits() {
		int totalCredits = 0;
		for (model.Module m : smp.getLstSelectedBlock1().getItems()) {
			totalCredits += m.getModuleCredits();
		}
		for (model.Module m : smp.getLstSelectedBlock2().getItems()) {
			totalCredits += m.getModuleCredits();
		}
		for (model.Module m : smp.getLstSelectedBlock34().getItems()) {
			totalCredits += m.getModuleCredits();
		}
		smp.getTxtCredits().setText(String.valueOf(totalCredits));
	}

	private void resetSelectModules() {
		if (model.getStudentCourse() != null) {
			smp.getLstSelectedBlock1().getItems().clear();
			smp.getLstSelectedBlock2().getItems().clear();
			smp.getLstUnselectedBlock34().getItems().clear();
			smp.getLstSelectedBlock34().getItems().clear();
			model.clearSelectedModules();

			for (model.Module m : model.getStudentCourse().getAllModulesOnCourse()) {
				if (m.isMandatory()) {
					if (m.getRunPlan() == Block.BLOCK_1) {
						smp.getLstSelectedBlock1().getItems().add(m);
						model.addSelectedModule(m);
					} else if (m.getRunPlan() == Block.BLOCK_2) {
						smp.getLstSelectedBlock2().getItems().add(m);
						model.addSelectedModule(m);
					} else if (m.getRunPlan() == Block.BLOCK_3_4) {
						smp.getLstSelectedBlock34().getItems().add(m);
						model.addSelectedModule(m);
					}
				} else {
					if (m.getRunPlan() == Block.BLOCK_3_4) {
						smp.getLstUnselectedBlock34().getItems().add(m);
					}
				}
			}
			updateCredits();
		}
	}

	private void submitModules() {
		int totalCredits = Integer.parseInt(smp.getTxtCredits().getText());
		if (totalCredits != 120) {
			showAlert(AlertType.ERROR, "Invalid Credits", "You must select exactly 120 credits. Current credits: " + totalCredits);
			return;
		}

		model.clearSelectedModules();
		for (model.Module m : smp.getLstSelectedBlock1().getItems()) model.addSelectedModule(m);
		for (model.Module m : smp.getLstSelectedBlock2().getItems()) model.addSelectedModule(m);
		for (model.Module m : smp.getLstSelectedBlock34().getItems()) model.addSelectedModule(m);

		rmp.getLstUnselectedBlock34().getItems().clear();
		rmp.getLstReservedBlock34().getItems().clear();
		for (model.Module m : smp.getLstUnselectedBlock34().getItems()) {
			rmp.getLstUnselectedBlock34().getItems().add(m);
		}

		view.getTabPane().getSelectionModel().select(2);
	}

	private void addReserveModule() {
		model.Module selected = rmp.getLstUnselectedBlock34().getSelectionModel().getSelectedItem();
		if (selected != null) {
			if (!rmp.getLstReservedBlock34().getItems().isEmpty()) {
				showAlert(AlertType.WARNING, "Limit Reached", "You can only reserve one optional module.");
				return;
			}
			rmp.getLstUnselectedBlock34().getItems().remove(selected);
			rmp.getLstReservedBlock34().getItems().add(selected);
		}
	}

	private void removeReserveModule() {
		model.Module selected = rmp.getLstReservedBlock34().getSelectionModel().getSelectedItem();
		if (selected != null) {
			rmp.getLstReservedBlock34().getItems().remove(selected);
			rmp.getLstUnselectedBlock34().getItems().add(selected);
		}
	}

	private void confirmReserveModule() {
		if (rmp.getLstReservedBlock34().getItems().isEmpty()) {
			showAlert(AlertType.ERROR, "Missing Reserve", "You must reserve one optional module before confirming.");
			return;
		}

		model.clearReservedModules();
		for (model.Module m : rmp.getLstReservedBlock34().getItems()) {
			model.addReservedModule(m);
		}

		populateOverview();
		view.getTabPane().getSelectionModel().select(3);
	}

	private void populateOverview() {
		osp.getTxtProfile().setText(
				"Name: " + model.getStudentName().getFullName() + "\n" +
						"PNo: " + model.getStudentPnumber() + "\n" +
						"Email: " + model.getStudentEmail() + "\n" +
						"Date: " + model.getSubmissionDate() + "\n" +
						"Course: " + model.getStudentCourse().getCourseName()
		);

		StringBuilder selectedStr = new StringBuilder("Selected modules:\n=========\n");
		for (model.Module m : model.getAllSelectedModules()) {
			selectedStr.append("Module code: ").append(m.getModuleCode())
					.append(", Module name: ").append(m.getModuleName())
					.append(", Credits: ").append(m.getModuleCredits())
					.append(", Mandatory? ").append(m.isMandatory() ? "yes" : "no")
					.append(", Block: ").append(m.getRunPlan()).append("\n\n");
		}
		osp.getTxtSelectedModules().setText(selectedStr.toString());

		StringBuilder reservedStr = new StringBuilder("Reserved modules:\n=========\n");
		for (model.Module m : model.getAllReservedModules()) {
			reservedStr.append("Module code: ").append(m.getModuleCode())
					.append(", Module name: ").append(m.getModuleName())
					.append(", Credits: ").append(m.getModuleCredits())
					.append(", Block: ").append(m.getRunPlan()).append("\n\n");
		}
		osp.getTxtReservedModules().setText(reservedStr.toString());
	}

	private void saveOverviewToFile() {
		try (PrintWriter writer = new PrintWriter(new FileWriter("student_overview.txt"))) {
			writer.println(osp.getTxtProfile().getText());
			writer.println("\n-----------------------------------\n");
			writer.println(osp.getTxtSelectedModules().getText());
			writer.println("\n-----------------------------------\n");
			writer.println(osp.getTxtReservedModules().getText());
			showAlert(AlertType.INFORMATION, "Success", "Overview saved successfully to 'student_overview.txt'.");
		} catch (IOException e) {
			showAlert(AlertType.ERROR, "Save Error", "Could not save file: " + e.getMessage());
		}
	}

	private void saveStudentProfileBinary() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student_profile.dat"))) {
			oos.writeObject(model);
			showAlert(AlertType.INFORMATION, "Success", "Student profile saved successfully.");
		} catch (IOException e) {
			showAlert(AlertType.ERROR, "Save Error", "Could not save profile: " + e.getMessage());
		}
	}

	private void loadStudentProfileBinary() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student_profile.dat"))) {
			model = (StudentProfile) ois.readObject();

			cspp.setStudentDetails(
					model.getStudentPnumber(),
					model.getStudentName().getFirstName(),
					model.getStudentName().getFamilyName(),
					model.getStudentEmail(),
					model.getSubmissionDate(),
					model.getStudentCourse()
			);

			resetSelectModules();
			showAlert(AlertType.INFORMATION, "Success", "Student profile loaded successfully.");
			view.getTabPane().getSelectionModel().select(0);
		} catch (IOException | ClassNotFoundException e) {
			showAlert(AlertType.ERROR, "Load Error", "Could not load profile: " + e.getMessage());
		}
	}

	private void showAboutDialog() {
		showAlert(AlertType.INFORMATION, "About", "JavaFX Module Selector GUI\nDeveloped for CTEC2710 OO Design and Development.");
	}

	private void showAlert(AlertType type, String title, String content) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
		alert.showAndWait();
	}

	private Course[] createModulesAndCourses() {
		model.Module ctec3701 = new model.Module("CTEC3701", "Software Development: Methods & Standards", 30, true, Block.BLOCK_1);

		model.Module ctec3702 = new model.Module("CTEC3702", "Big Data and Machine Learning", 30, true, Block.BLOCK_2);
		model.Module ctec3703 = new model.Module("CTEC3703", "Mobile App Development and Big Data", 30, true, Block.BLOCK_2);

		model.Module ctec3451 = new model.Module("CTEC3451", "Development Project", 30, true, Block.BLOCK_3_4);

		model.Module ctec3704 = new model.Module("CTEC3704", "Functional Programming", 30, false, Block.BLOCK_3_4);
		model.Module ctec3705 = new model.Module("CTEC3705", "Advanced Web Development", 30, false, Block.BLOCK_3_4);

		model.Module imat3711 = new model.Module("IMAT3711", "Privacy and Data Protection", 30, false, Block.BLOCK_3_4);
		model.Module imat3722 = new model.Module("IMAT3722", "Fuzzy Logic and Inference Systems", 30, false, Block.BLOCK_3_4);

		model.Module ctec3706 = new model.Module("CTEC3706", "Embedded Systems and IoT", 30, false, Block.BLOCK_3_4);

		Course compSci = new Course("Computer Science");
		compSci.addModule(ctec3701);
		compSci.addModule(ctec3702);
		compSci.addModule(ctec3451);
		compSci.addModule(ctec3704);
		compSci.addModule(ctec3705);
		compSci.addModule(imat3711);
		compSci.addModule(imat3722);

		Course softEng = new Course("Software Engineering");
		softEng.addModule(ctec3701);
		softEng.addModule(ctec3703);
		softEng.addModule(ctec3451);
		softEng.addModule(ctec3704);
		softEng.addModule(ctec3705);
		softEng.addModule(ctec3706);

		Course[] courses = new Course[2];
		courses[0] = compSci;
		courses[1] = softEng;

		return courses;
	}
}