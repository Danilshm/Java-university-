package jplanner;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/* A simple journey planning application which nicely 
 * demonstrates modularising and decomposing different
 * areas of the view to aid re-usability and maintenance.
 */
public class JourneyPlannerRootPane extends VBox {

	//by declaring certain UI nodes as fields, you can ensure
	//they are accessible through the public interface
	private ButtonPane bp;
	private JourneyInputPane outwardJourney; 
	private JourneyInputPane returnJourney;
	
	public JourneyPlannerRootPane() {
		//styling
		this.setStyle("-fx-background-color: #415D78;");
		this.setPadding(new Insets(10,10,10,10));
		this.setSpacing(20);
		this.setAlignment(Pos.CENTER);

		//create and add a new instance of each subcontainer
		bp = new ButtonPane();
		//note how two instances of JourneyInputPane are created
		outwardJourney = new JourneyInputPane("Outward Journey");
		returnJourney = new JourneyInputPane("Return Journey");

		this.getChildren().addAll(outwardJourney, returnJourney, bp);
	}

	/* These methods provide a public interface for the root pane
	 * that allows each of the sub-containers to be accessed. The
	 * benefit of this will become apparent when you start handling
	 * events and utilise the Model-View-Controller design pattern.
	 */
	public ButtonPane getButtonPane() {
		return bp;
	}

	public JourneyInputPane getOutwardPane() {
		return outwardJourney;
	}

	public JourneyInputPane getReturnPane() {
		return returnJourney;
	}
}
