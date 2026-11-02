package approaches;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import java.io.IO;

public class EventHandlingExamples extends HBox
{

	public EventHandlingExamples() {
        this.setStyle("-fx-font-size: 32px;");
        this.setSpacing(30);
        this.setPadding(new Insets(10,10,10,10));
		
        // BUTTON 1
        Button b1 = new Button("1");
        
        /* EXTERNAL SEPERATE TOP LEVEL CLASS */
        b1.setOnAction(new ButtonHandlerOne());
        
        //---------------      
        
        
        // BUTTON 2
        Button b2 = new Button("2");
        
        /* CALL TO NAMED INNER CLASS  - see below */
        b2.setOnAction(new ButtonHandlerTwo());
        
        //---------------
        
        
        //BUTTON 3
        Button b3 = new Button("3");
        
        /* ANONYMOUS INNER CLASS */
        b3.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
    			IO.println("Clicked button 3!...anonymous inner class");
    		}
        });

		//---------------
        
        
        //BUTTON 4
        Button b4 = new Button("4");
        
        /* LAMBDA EXPRESSION */
        /*b4.setOnAction((ActionEvent e) -> {
        	System.out.println("Clicked button 4!");
        });*/
        
        //short-hand version below where the parameter is inferred. Braces and semi-colon omitted as it's a single statement
        b4.setOnAction(e -> IO.println("Clicked button 4!...lambda expression"));
        
		//---------------
        
        //add buttons to the HBox
        this.getChildren().addAll(b1, b2, b3, b4);
	}
	
	
	//named inner class event handler
	private class ButtonHandlerTwo implements EventHandler<ActionEvent> {
		
		public void handle(ActionEvent e) {
			IO.println("Clicked button 2!...named inner class");
		}
	}

}
