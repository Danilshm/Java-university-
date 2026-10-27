package layouts;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

//note extending JMenu
public class CustomMenu extends Menu {

	public CustomMenu(String name) {
		//set the name for this menu
		this.setText(name);
		
		//temp vars for submenus within this JMenu
		Menu menu, submenu; 
        
		//menu within this menu
        menu = new Menu("Write names");
        
        menu.getItems().add(new MenuItem("Entire list"));
        menu.getItems().add(new MenuItem("Individually"));
        
        this.getItems().add(menu); //add to this menu      
        
        
        //another menu within this menu
        menu = new Menu("Read names");
        
        //create submenu within "Read names" menu
        submenu = new Menu("Entire list"); 
        menu.getItems().add(submenu);
        
        //create another submenu within "Read names" menu
        submenu = new Menu("Individually");
        menu.getItems().add(submenu);
        
        this.getItems().add(menu); //add to this menu
        			
	}
	
}
