package layouts;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

//note extending JMenuBar
public class MyMenuBar extends MenuBar {

	public MyMenuBar() {      

		//temp vars for menus and menu items within this JMenuBar
		Menu menu;
		MenuItem menuItem;

		//----------Build the first menu on the menu bar.--------------------
		menu = new Menu("File");

		//create a group of JMenuItems
		//define and add the 'Open' menu item
		menuItem = new MenuItem("Open");
		menu.getItems().add(menuItem);

		//'Save' menu item
		menuItem = new MenuItem("Save");
		menu.getItems().add(menuItem);

		//...add a separator
		menu.getItems().add( new SeparatorMenuItem());

		//... add an 'Exit' item
		menu.getItems().add(new MenuItem("Exit")); //adding JMenuItem directly to menu

		this.getMenus().add(menu); //add the menu to this menubar;



		//-------- Build the second menu--------------------------------------
		//This shows that you can do this in a separate class.
		menu = new CustomMenu("Name processing");

		this.getMenus().add(menu); //add the menu to this menu bar


		/* -------- ADD THIRD MENU HERE --------- */
		//A menu called Help, that contains the menu item About.
	}
}
