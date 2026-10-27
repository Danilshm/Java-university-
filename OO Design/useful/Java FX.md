# Stage
- is the top-level window. The Scene is the content displayed inside it
# Scene 
- The container holding the GUI content 
# Nodes 
- Items in the scene graph: panes, buttons, fields,and more 

# One Stage displays one Scene at a time. The Scene contains a tree of Nodes.
# Root pane
-> Form pane 
- Label+ TextField
-> Button pane 
- Save + cancel
-> Menu pane 
- File + Help
Branch nodes contain children. Leaf nodes, such as buttons and txt fields, do not contain children.
# Layout panes: choose the arrangement 
- HBox
	- Place items horizontally 
- VBox
	- Stacks items vertically
- FlowPane 
	- Flow and wrap to fit
- GridPane
	- Arrange in rows and columns
- BorderPane
	- Top, bottom, left, right, centre
- StackPane
	- Place node on top of each other 
## Combine panes to make real interfaces
- A pane can contain other panes. This is how a larger interface stays organised.
### Example
- Top Section 
	- VBox
- Form section 
	- GridPane
- Action Section
	- HBox
# JacaFX application lifecycle 
1) launch()
- Starts the JavaFX application
2) init()
- Can prepare the scene graph
3) start(stage)
- Build the Scene, set it on Stage, show it
4) stop()
- Called as the application shuts down 