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
