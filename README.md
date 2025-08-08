# 🛍️ ShoeStore Backend

Backend developed in **Java 21** with **Spring Boot** for the comprehensive management of a shoe store.  
The system implements a **Hexagonal** architecture (Ports & Adapters) with a **modular structure** for each domain: Product, Customer, Employee, Purchasing, Sales, and Suppliers.

---

## 📌 Main features

- Full CRUD for main entities.
- Stock management and purchase/sales records.
- Customer, employee, and supplier management.
- Hexagonal architecture to decouple domain, application, and infrastructure.
- Validations with **Jakarta Validation**.
- API documentation with **Swagger / OpenAPI 3**.
- Centralized exception handling.
- Integration with **MariaDB** using **Spring Data JPA**.
- Configuration ready for deployment in local and cloud environments.

---

## 🚀Run project

### 🛠️ Prerequisites

Before running the project, make sure you have the following installed:

- **Java 21** or higher
- **Maven 3.9+**
- **MariaDB** (or MySQL compatible) running
- **Recommended IDE**: IntelliJ IDEA or Eclipse
- **Postman** (optional, for endpoint testing)

### 1️⃣ Clone the repository

```bash
    git clone https://github.com/TomCab98/shoestore-backend.git
    cd shoestore-backend
```

### 2️⃣ Run docker

```bash
    docker-compose up
```

### 3️⃣ Install dependencies

```
    mvn spring-boot:install
```

### 4️⃣ Execute project

```bash
    mvn spring-boot:run
```

### 5️⃣ Access the Swagger documentation
Once running, the API will be available at:

### [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### 6️⃣ Import Postman collection (Optional)

- Open Postman
- Go to Collections, you will see it in the left sidebar
- Select **Import**
- Chose the [shoestore-postman-collection.json](shoestore-postman-collection.json)
- Now you have all requests collection you need to test the project

--- 

## 📂 Project structure

```
src
 └── main
     ├── java
     │   └── com.project.shoestore
     │       ├── client
     │       │   ├── adapters       # Adapters and ports for controller and repositories
     │       │   ├── domain         # Use cases and models of business
     │       │   └── infrastructure # Controllers, entities, persistence and configurations
     │       ├── core
     │       ├── employee
     │       ├── order
     │       ├── product
     │       ├── provider
     │       └── sale
     └── resources
         ├── application.yml
         └── data.sql (Initial database data)
```

---

## 🏗️ Architecture used

The project implements Hexagonal Architecture, separating the code into:

- Adapters → Adapters, communication between domain and infrastructure.
- Domain → Use cases, models and ports.
- Infrastructure → Specific implementations, REST controllers, persistence (JPA), framework configurations.

This approach allows for:

- Framework independence.
- Replacing adapters without touching the business logic.

Simplified diagram:

```
       [ Infrastructure ]   # Controllers, repositories, configurations
               ↑
          [ Adapters ]      # Adapters and mappers
               ↑
           [ Domain ]       # Use cases and models of domain
```

---

## 📦 Key dependencies
- Spring Boot Starter Web → REST API.
- Spring Boot Starter Data JPA → ORM with Hibernate.
- MariaDB Driver → Database connection.
- Spring Boot Starter Validation → Input validations.
- Springdoc-openapi-ui → Swagger documentation.
- Lombok → Reduction of boilerplate code.

---

## ⚠️ Error handling

A [ExceptionManagerService](src/main/java/com/project/shoestore/core/infrastructure/configurations/exceptions/ExceptionManagerService.java) is implemented with @ControllerAdvice to return a standard format:

```json
    {
      "timestamp": "2025-08-06T10:00:00Z",
      "status": 404,
      "error": "Not Found",
      "message": "Product with ID '123' not found",
      "path": "/api/products/123"
    }
```

---

