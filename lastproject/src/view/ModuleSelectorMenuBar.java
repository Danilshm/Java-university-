package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class ModuleSelectorMenuBar extends MenuBar {
	private MenuItem loadData;
	private MenuItem saveData;
	private MenuItem exit;
	private MenuItem about;

	public ModuleSelectorMenuBar() {
		Menu fileMenu = new Menu("File");
		loadData = new MenuItem("Load Student Data");
		loadData.setAccelerator(new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN));

		saveData = new MenuItem("Save Student Data");
		saveData.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));

		exit = new MenuItem("Exit");
		exit.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));

		fileMenu.getItems().addAll(loadData, saveData, exit);

		Menu helpMenu = new Menu("Help");
		about = new MenuItem("About");
		helpMenu.getItems().add(about);

		this.getMenus().addAll(fileMenu, helpMenu);
	}

	public MenuItem getLoadDataMenu() { return loadData; }
	public MenuItem getSaveDataMenu() { return saveData; }
	public MenuItem getExitMenu() { return exit; }
	public MenuItem getAboutMenu() { return about; }

	public void addExitHandler(javafx.event.EventHandler<javafx.event.ActionEvent> handler) {
		exit.setOnAction(handler);
	}

	public void addLoadHandler(javafx.event.EventHandler<javafx.event.ActionEvent> handler) {
		loadData.setOnAction(handler);
	}

	public void addSaveHandler(javafx.event.EventHandler<javafx.event.ActionEvent> handler) {
		saveData.setOnAction(handler);
	}

	public void addAboutHandler(javafx.event.EventHandler<javafx.event.ActionEvent> handler) {
		about.setOnAction(handler);
	}
}