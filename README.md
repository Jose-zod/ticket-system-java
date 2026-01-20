# # Support Ticket System – Java (Helpdesk / IT Support)

## Author
Jose Martin  
Java / IT Support / Systems Engineering

A simple **IT Support / Helpdesk Ticket System** built in **Java** using a **layered architecture**  
(UI → Service → Repository → Model).

The project focuses on **clean design**, **business rules**, and a **Round-Robin ticket assignment**
strategy, simulating a real-world IT Support / NOC workflow.

## Why this project?
This project was built to practice and demonstrate:
- Clean Java design and layered architecture
- Business logic separation from UI
- Safe handling of application state using enums and result objects
- Practical IT Support / Helpdesk scenarios

## Features
- Create support tickets (title, description, created by user)
- Assign tickets to agents using **Round-Robin**
- In-memory repository (no database)
- UI built with **JOptionPane** + strong input validation
- Clear **domain rules**:
  - Closed tickets cannot be assigned
  - A ticket cannot be closed more than once

## Architecture

This project follows a **clean layered design**:

- **Main (UI)**  
  Handles user interaction and input validation (JOptionPane)

- **TicketService (Service Layer)**  
  Contains business logic and Round-Robin assignment

- **TicketRepository (Repository Layer)**  
  In-memory storage using `Optional<Ticket>`

- **Model Layer**  
  Domain entities and enums:
  - `Ticket`, `User`
  - `TicketStatus`, `UserType`, `RoundRobinStatus`

- **RoundRobinResult**  
  Value object that returns:
  - Assignment status
  - Assigned agent (when successful)

## How to Run (Maven)

### Requirements
- Java 17+ (tested with Java 24)
- Maven

### Run from project root

```bash
mvn clean compile exec:java -Dexec.mainClass=com.jmartin.support.Main
