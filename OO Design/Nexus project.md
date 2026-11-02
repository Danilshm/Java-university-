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
# Final
- Your final presentation should tell a story
	- Problem: Who is the user? What need are you solving?
	- Solution: Show the interface and explain design choices.
	- Live demo: Complete the main journey from start to result.
	- Evidence: Show tests performed and one issue you fixed.
	- next step: Name one limitation and a realistic improvement.
1.	Problem: Who is the user and what need are you solving?
- Primary User
	- Who: University students and academic project team members managing multiple concurrent coursework deadlines, group deliverables, and daily routines.
- Need Being Solved
	- Core Problem: Existing task management tools are often overcomplicated or fragmented, making it hard for students to quickly log and verify daily academic priorities without friction.
	2.	Solution: Show the interface and explain the design choices behind it.
	3.	Live demo: Walk through the main journey from start to result.
	4.	Evidence: Show the tests you ran and one issue you found and fixed. The test table has four cases, all marked PASS.
	5.	Next step: Name one limitation and a realistic improvement. Data is not saved between runs (File I/O persistence is in the plan), so the next step is saving to a file.
## GUI Test Suite — Vertical Slice Milestone

| Test Case           | Input / Action                                                 | Expected Result                                                                     | Pass? |
| :------------------ | :------------------------------------------------------------- | :---------------------------------------------------------------------------------- | :---: |
| **Happy path**      | Enter "Read Chapter 4" into the input field and click Add Task | Task "Read Chapter 4 [In Progress] " appears in the list view                       | PASS  |
| **Missing field**   | Leave text field blank and click Add Task                      | Error alert (Validation Error) pops up with a clear message; list remains unchanged | PASS  |
| **Selection check** | Click Mark Completed without selecting any item in the list    | Warning alert (Selection Error) prompts user to select a task first                 | PASS  |
| **Update record**   | Select a task from the list and click Mark Completed           | Task title status updates to -> COMPLETED! in real time                             | PASS  |
