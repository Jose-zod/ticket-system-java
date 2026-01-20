# # Support Ticket System – Java (Helpdesk / IT Support)

## Author
Jose Martin  
Java / IT Support / Systems Engineering

A simple **IT Support / Helpdesk Ticket System** built in **Java** using a **layered architecture** (UI → Service → Repository → Model).
Includes **Round-Robin** ticket assignment and basic **domain rules** for ticket state transitions.


## Why this project?
This project was built to practice and demonstrate:
- Clean Java design and layered architecture
- Business logic separation from UI
- Safe handling of application state using enums and result objects
- Practical IT Support / Helpdesk scenarios

## Features
- Create tickets (title, description, createdBy)
- Assign tickets to agents using **Round-Robin**
- In-memory repository (no database)
- UI with **JOptionPane** + input validation
- Domain rules:
    - Closed tickets cannot be assigned
    - A ticket cannot be closed twice

## Project Structure
- `Main` (UI): menu + validation (JOptionPane)
- `TicketService` (Service): business rules + round-robin assignment
- `TicketRepository` (Repository): in-memory storage + `Optional<Ticket>`
- `Ticket` / `User` (Model): domain objects and enums
- `RoundRobinResult` (Service): returns **status + assigned agent**

## How to Run

### Using Maven
From the project root:
```bash
mvn clean compile exec:java -Dexec.mainClass="com.jmartin.support.Main"
