package register;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/* A pane forming the root of the scene graph for this FX application that
 * builds, adds and displays each of the subcontainers */
public class RegisterRootPane extends BorderPane {

	//by declaring these as fields, they are accessible throughout the class, 
	//e.g. we can write 'get' methods that return a reference to them - see towards end of class
	private ButtonPane bp;
	private NamePane np;
	private ViewPane vp;
	private RegisterMenuBar rmb;

	public RegisterRootPane() {
		this.setStyle("-fx-background-color: #415D78;"); //background

		np = new NamePane(); //initialise subcontainers
		vp = new ViewPane();

		/* NOTE - this bit is crucial. Notice how references to the 
		 * NamePane and ViewPane are both passed into the ButtonPane. 
		 * This gives the ButtonPanel access to their methods to 
		 * assist with event handling. */
		bp = new ButtonPane(np, vp);
		
		/* The RegisterMenuBar needs a reference to the ViewPane
		 * for event handling. */
		rmb = new RegisterMenuBar(vp);

		
		VBox topContainer = new VBox(np, bp);
		topContainer.setSpacing(20); //spacing between np and bp
		topContainer.setPadding(new Insets(0,0,20,0)); //bottom padding between this container and vp
		
		BorderPane rootContainer = new BorderPane();
		rootContainer.setTop(topContainer);
		rootContainer.setCenter(vp);
		rootContainer.setPadding(new Insets(20,20,20,20)); //padding around the entire root container
		
		this.setTop(rmb);
		this.setCenter(rootContainer);
	}

	//external references can be acquired for each of the subcontainers
	//this will become important when we move onto MVC design later in the module
	//and separate the UI (view) from the event handling (controller)
	public ButtonPane getButtonPane() {
		return bp;
	}

	public NamePane getNamePane() {
		return np;
	}

	public ViewPane getViewPane() {
		return vp;
	}

	public RegisterMenuBar getMenuBar() {
		return rmb;
	}
}
