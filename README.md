# Task Scheduling API

A Spring Boot application implementing a simple Task Scheduling system with CRUD operations, controlled status transitions, and soft-delete handling.  
This project uses an H2 in-memory database for persistence and demonstrates clean architecture, error handling, and documentation best practices.

---

## Features
- Create, read, update, and delete tasks
- Soft-delete support (tasks marked as deleted instead of removed)
- Controlled status transitions (e.g., `PENDING → IN_PROGRESS → COMPLETED`)
- Enum-based priority (`LOW`, `MEDIUM`, `HIGH`) and status (`PENDING`, `IN_PROGRESS`, `COMPLETED`)
- Global exception handling with consistent JSON error responses
- Preloaded sample data via `data.sql`
- H2 console enabled for easy database inspection

---

## Tech Stack
- **Spring Boot 3.2.5**
- **Spring Data JPA**
- **H2 Database**
- **Hibernate ORM**
- **Maven**

---

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/ras-hmi/demo1.git
   cd demo1
