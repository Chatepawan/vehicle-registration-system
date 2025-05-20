# Vehicle Registration System

A simple Spring Boot web application for vehicle registration using Maven, Thymeleaf (HTML/CSS), Hibernate (JPA), and MySQL. Built and run using Visual Studio Code.

---

## 🔧 Tech Stack

- Java 8+
- Spring Boot
- Spring MVC + Thymeleaf
- Hibernate (Spring Data JPA)
- MySQL
- HTML/CSS
- VS Code + Maven

---

## 📦 Setup Instructions

1. **Clone or Create Project**
   - Use Spring Initializr (https://start.spring.io/) with dependencies:
     - Spring Web, Spring Data JPA, MySQL Driver, Thymeleaf
2. **Configure `application.properties`**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/vehicledb
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
3.run the commands on terminal for building the project
   - mvn clean install
   - mvn spring-boot:run
4. Open the url on browser
   - localhost:8080
