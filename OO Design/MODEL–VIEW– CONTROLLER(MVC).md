# MODEL–VIEW–CONTROLLER(MVC)
## MODEL
- Data + business rules
- Stores application data
- Contains business rules
- Provides functionality to the controller
## VIEW
- What the user sees
- Displays model data
- Defines how information appears
- Forwards user events
## CONTROLLER
- Responds to actions
- Handles user gestures
- Chooses actions for the model
- May trigger a view update
## How the parts communicate
![[Pasted image 20261103112451.png|531]]
## A familiar analogy 
### VIEW = MENU
- The menu is what the customer sees and interacts with.
### CONTROLLER = WAITER
- Takes the order and communicates what needs to happen.
### MODEL = KITCHEN
- Holds the ingredients and follows the rules to prepare the order.
## MVC can be implemented in different ways
-  APPROACH 1
	- Combine View + Controller as a UI Delegate.
	- The delegate updates the Model.
- APPROACH 2 
	- Keep View and Model separate.
	- A separate Controller synchronises them.

## UI Delegate approach. Diagram 1
![[Pasted image 20261103113822.png|458]]
### Approach 1: what is happening?
- UI DELEGATE
	- Contains the View and event-handling Controller together.
- Model 
	- Remains separate and owns the application data and rules.
- Flow 
	- User action → delegate/controller → Model → View refresh.
## Diagram 2
![[Pasted image 20261103114412.png|467]]
### Approach 2: separate all three responsibilities
- VIEW
	- UI only
- CONTROLLER
	- Behaviour
- MODEL
	- Data + rules