# Our problem
- Clarify a presentation objective(a finished commercial product or should it focus on the academic and technical aspects of our project)
# Option 1: Technical & OO Architecture Focus (Academic Approach)
Best suited if we focus on <font color="#ff0000">Object-Oriented design</font>, class structures, and technical principles.
## Slide 1: Problem Definition & User Goal
- What real-world problem the app addresses and who the primary user is.
- The main goal the user needs to accomplish in a single workflow.
## Slide 2: Domain Model & Class Structure
- Overview of the core domain entities (User, Task, DailyTask, WeeklyTask).
- Separation of responsibilities across services and repositories (EvaluationService, TaskManager, TaskRepository).
## Slide 3: Object-Oriented Principles in Action
- Application of key OO concepts: Class inheritance (Task $\rightarrow$ DailyTask / WeeklyTask).
- Interface contracts (Evaluatable) and polymorphic behavior.
## Slide 4: MVP Scope & Project Boundaries
- Definition of Must-Have features vs. Nice-to-Have / Out-of-Scope items.
- Keeping the core workflow simple, demonstrable, and clear.
## Slide 5: Demonstration & Workflow Walkthrough
- Step-by-step walkthrough of the main success path.
- Code execution flow showing how objects interact.
# Option 2: Product & User Journey Focus (Product Pitch Approach)
- Best suited if the focus is on <font color="#ff0000">end-to-end functionality, user experience, and product scope</font>.
## Slide 1: User Persona & Pain Points
- Profile of the main user persona.
- The specific challenge or inconvenience the user faces.
## Slide 2: The Core User Journey
- The step-by-step user path: User registration $\rightarrow$ Task creation $\rightarrow$ Task completion $\rightarrow$ Rank & performance update.
## Slide 3: MVP Features (The 5-Minute Demo Scope)
- Showcase of essential functional features (Must-Haves).
- Demonstration of a clear success path without unnecessary complexity.
## Slide 4: High-Level System Architecture
- High-level overview of object interactions and data handling behind the scenes.
- How the data flows between models, services, and storage.
# Slide 5: Roadmap & Future Sprints
- Planned enhancements for subsequent checkpoints (File I/O persistence, GUI design, exception handling).
- Next steps for scaling the application.

# The goal: a working story, not just pretty screens 
1) Show
- A clear user problem
- realistic user journey
2) work
- Buttons do what they promise
- Forms accept valid input
1) Explain 
- Why you designed in this way
- What you tested
- What you would improve next
# First decision: what is your MVP
- Must have
	- Core user task works end to end
	- Essential screens and navigation
	- Clear feedback after actions
	- Demo data
- Nice to have
	- Decorative animation 
	- Extra settings and etc.
# Map the user journey before polishing UI
1) Enter(open app/ sign in)
2) Act(search, select or fill)
3) Review(check details)
4) Confirm(submit/save)
5) Feedback(success or clear error)
- Ask
	- Может ли юзер зайдя на сайт сразу всё понять 
# Screen checklist
- Orientation
	- Clear page tittle
	- Obvious primary action 
	- Consistent navigation 
- Input
	- Labels explain what to enter
	- Required fields marked
	- Useful examples
- Feedback
	- Success confirmation
- Consistency 
	- Same fonts, colours and spacing 
# Validation 
- Empty: What if a required field is blank
- Invalid: what if an email/ number is malformed
- and etc/
# Today goal(29.10.26)
- A complete vertical slice 
# Final
- Your final presentation should tell a story
	- Problem: Who is the user? What need are you solving?
	- Solution: Show the interface and explain design choices.
	- Live demo: Complete the main journey from start to result.
	- Evidence: Show tests performed and one issue you fixed.
	- next step: Name one limitation and a realistic improvement.
## GUI Test Suite — Vertical Slice Milestone

| Test Case           | Input / Action                                                 | Expected Result                                                                     | Pass? |
| :------------------ | :------------------------------------------------------------- | :---------------------------------------------------------------------------------- | :---: |
| **Happy path**      | Enter "Read Chapter 4" into the input field and click Add Task | Task "Read Chapter 4 [In Progress] " appears in the list view                       | PASS  |
| **Missing field**   | Leave text field blank and click Add Task                      | Error alert (Validation Error) pops up with a clear message; list remains unchanged | PASS  |
| **Selection check** | Click Mark Completed without selecting any item in the list    | Warning alert (Selection Error) prompts user to select a task first                 | PASS  |
| **Update record**   | Select a task from the list and click Mark Completed           | Task title status updates to -> COMPLETED! in real time                             | PASS  |
