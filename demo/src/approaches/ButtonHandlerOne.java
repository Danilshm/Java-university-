package approaches;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

//external top-level class event handler
public class ButtonHandlerOne implements EventHandler<ActionEvent> {

	public void handle(ActionEvent e) {
		IO.println("Clicked button 1!...external top-level class");
	}
	
}
