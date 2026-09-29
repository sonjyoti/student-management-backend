# Student Management System

A web-based Student Management System for managing students, courses, departments, and academic information.

This project is being migrated from a PHP-based implementation to a **Spring Boot REST API** with a layered architecture and relational database.

### Previous Project: ``https://github.com/sonjyoti/Student-Management-System`` 

## 🚀 Project Overview

The Student Management System provides a centralized platform for managing student-related information.

The original application was developed using **PHP**, and this project focuses on migrating the backend to **Java Spring Boot** while improving the project structure, maintainability, and API design.

### Main Objectives

- Manage student information
- Manage courses and departments
- Create, update, view, and delete student records
- Associate students with courses
- Add urgent notices
- Provide REST APIs for frontend/client applications
- Separate business logic from database access
- Improve scalability and maintainability compared to the original PHP implementation

---

## 🏗️ Architecture

The Spring Boot version follows a layered architecture:

```text
Client / Frontend
       │
       ▼
   Controller
       │
       ▼
    Service
       │
       ▼
  Repository
       │
       ▼
    Database