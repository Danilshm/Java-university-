package layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FXLayout extends Application {

	private Parent root; //root of the scene graph.
	
	private String title; //used for stage title
	
	//An array of nodes to place in the scene graph.  
	private StackPane[] buttonpanes;

	private void makeButtonPanes() {
		buttonpanes = new StackPane[5];
		for (int i = 0; i < buttonpanes.length; i++) {
			buttonpanes[i] = new StackPane();
			buttonpanes[i].setAlignment(Pos.CENTER);
			buttonpanes[i].setPrefSize(150, 100);
			//set a different shade of background fill for the stackpane
			buttonpanes[i].setBackground(new Background(new BackgroundFill(Color.rgb(i*30+100, i*20+50, i*10+20), null, null)));
			//add a button to the stackpane
			buttonpanes[i].getChildren().add(new Button("button " + i ));
		}
	}
	
	//FlowPane
	private Parent getFlowPane() {
		FlowPane flowpane = new FlowPane(20,20);
		flowpane.setPrefWrapLength(400);
		flowpane.getChildren().addAll(buttonpanes);
		return flowpane;
	}
	
	//HBox
	private Parent getHbox() {
		HBox hbox = new HBox(20);
		hbox.getChildren().addAll(buttonpanes);
		return hbox;
	}
	
	//VBox
	private Parent getVbox() {
		VBox vbox = new VBox(20);
		vbox.getChildren().addAll(buttonpanes);
		return vbox;
	}
	
	//GridPane
	private Parent getGridPane() {
		GridPane grid = new GridPane();
		grid.setHgap(20);
		grid.setVgap(20);
		grid.addRow(0, buttonpanes[0], buttonpanes[1]);
		grid.add(buttonpanes[2],0,1,2,1);
		grid.add(buttonpanes[3], 0,2,3,1);
		grid.add(buttonpanes[4],2,0,1,2);
		
		ColumnConstraints column0 = new ColumnConstraints(100,100,Double.MAX_VALUE);
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setHgrow(Priority.ALWAYS);
		grid.getColumnConstraints().addAll(column0, column1);
		
		return grid;
	}
	
	//TilePane
	private Parent getTilePane() {
		TilePane tp = new TilePane();
		tp.setHgap(20);
		tp.setVgap(20);
		tp.setPrefTileWidth(200);
		tp.setPrefColumns(3);
		tp.getChildren().addAll(buttonpanes);
		return tp;
	}

	//BorderPane
	private Parent getBorderPane() {
		BorderPane bp = new BorderPane();
		bp.setTop(buttonpanes[0]);
		bp.setLeft(buttonpanes[1]);
		bp.setCenter(buttonpanes[2]);
		bp.setRight(buttonpanes[3]);
		bp.setBottom(buttonpanes[4]);
		return bp;
	}
	
	//AnchorPane
	private Parent getAnchorPane() {
		AnchorPane anchor = new AnchorPane();
		anchor.setBackground(new Background(new BackgroundFill(Color.DARKSLATEGREY, null, null)));
		anchor.setPadding(new Insets(20));
		for (int i = 0; i < buttonpanes.length; i++) {
			AnchorPane.setTopAnchor(buttonpanes[i], i*75 + 50.0);
			AnchorPane.setLeftAnchor(buttonpanes[i], i*75 + 50.0);
		}
		anchor.getChildren().addAll(buttonpanes);
		return anchor;
	}
	
	//SplitPane (control)
	private Parent getSplitPane() {
		SplitPane sp = new SplitPane();
		sp.setDividerPositions(0.2f, 0.4f, 0.6f, 0.8f);
		sp.getItems().addAll(buttonpanes);
		return sp;
	}

	//Accordion (control)
	private Parent getAccordion() {
		Accordion accordion = new Accordion();
		TitledPane[] tp = new TitledPane[5];
		for (int i = 0; i < tp.length; i++) {
			tp[i] = new TitledPane("Button " + i, buttonpanes[i]);
		}
		accordion.getPanes().addAll(tp);
		accordion.setPrefHeight(200);
		return accordion;
	}

	//TabPane (control)
	private Parent getTabPane() {
		TabPane tabpane = new TabPane();
		Tab[] tab = new Tab[5];
		for (int i = 0; i < tab.length; i++) {
			tab[i] = new Tab("Button " + i, buttonpanes[i]);
		}
		tabpane.getTabs().addAll(tab);
		return tabpane;
	}
	
	/*======Override fx Application methods==========*/
	
	@Override
	public void init() {
		//instantiate the button panes  
		this.makeButtonPanes();
		
		//set the root to one of the layouts.
		//===Uncomment one of the following lines===
		root = getFlowPane(); title ="FlowPane";
//		root = getHbox();  title = "HBox";
//		root = getVbox(); title ="VBox";
//		root = getGridPane(); title ="GridPane";
//		root = getTilePane(); title ="TilePane";
//		root = getBorderPane(); title ="BorderPane";
//		root = getAnchorPane(); title ="AnchorPane";
//		root = getSplitPane(); title ="SplitPane";
//		root = getTabPane(); title ="TabPane";
//		root = getAccordion(); title ="Accordion";

	
	}

	
	@Override
	public void start(Stage stage) {
		//set the root of the scene and display on the stage.
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle(title);
		stage.show();
	}

	//======Main method to lauch the FX application============
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
