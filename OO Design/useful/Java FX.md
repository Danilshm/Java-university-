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
# Lists and data models
- ComboBox
	- A compact drop-down list 
	- Useful for choosing a course, country or category 
- ListView
	- Shows multiple list items at once
	- Useful for displaying available options or selected records 
# Menus: a small hierarchy
- MenyBar
	- The menu strip at the top of a window 
- Menu 
	- A category, such as File or Help
- MenuItem
	- An action, such as About or Exit
# Why create custom panes?
- Without structure 
	- One large class contains every control and layout
	- It becomes harder to read and change 
- Without custom panes 
	- A RegistrationFormPane contains the form 
	- A ButtonPane contains related buttons
	- Reuse and maintain each part more easily 
# CSS: control the look and feel
- Padding 
	- Space inside the pane around its content
- Spacing
	- The gap between neighbouring controls 
- Border + Color 
	- Help separate sections and create visual hierarchy
- Java code = structure '' CSS = visual style
# ВОт бы он ее джахнул аккуратненько не спеша черемша и будет его жизнь прекрасна. Потом возьмет ее в жены и будет счастлив всю свою жизнь
# CSS example : read the rule 
```
.button {
-fx-font-size:18px
.....
}
```
