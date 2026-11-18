package view;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class ModuleSelectorRootPane extends BorderPane {
	private ModuleSelectorMenuBar menuBar;
	private CreateStudentProfilePane createProfilePane;
	private SelectModulesPane selectModulesPane;
	private ReserveModulesPane reserveModulesPane;
	private OverviewSelectionPane overviewSelectionPane;
	private TabPane tabPane;

	public ModuleSelectorRootPane() {
		menuBar = new ModuleSelectorMenuBar();
		setTop(menuBar);

		createProfilePane = new CreateStudentProfilePane();
		selectModulesPane = new SelectModulesPane();
		reserveModulesPane = new ReserveModulesPane();
		overviewSelectionPane = new OverviewSelectionPane();

		tabPane = new TabPane();
		Tab t1 = new Tab("Create Profile", createProfilePane);
		Tab t2 = new Tab("Select Modules", selectModulesPane);
		Tab t3 = new Tab("Reserve Modules", reserveModulesPane);
		Tab t4 = new Tab("Overview Selection", overviewSelectionPane);

		t1.setClosable(false);
		t2.setClosable(false);
		t3.setClosable(false);
		t4.setClosable(false);

		tabPane.getTabs().addAll(t1, t2, t3, t4);
		setCenter(tabPane);
	}

	public ModuleSelectorMenuBar getModuleSelectorMenuBar() {
		return menuBar;
	}
	public CreateStudentProfilePane getCreateStudentProfilePane() { return createProfilePane; }
	public SelectModulesPane getSelectModulesPane() { return selectModulesPane; }
	public ReserveModulesPane getReserveModulesPane() { return reserveModulesPane; }
	public OverviewSelectionPane getOverviewSelectionPane() { return overviewSelectionPane; }
	public TabPane getTabPane() { return tabPane; }
}