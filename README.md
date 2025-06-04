# 🛠 JobSter Backend

This is the backend codebase for **JobSter**, a full-featured job portal platform that enables recruiters to post jobs and candidates to apply with their profiles.

---

## 📁 Project Structure

```bash
job-portal-backend/
├── pom.xml                     # Maven configuration
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── jobportal/
│   │   │           ├── controller/        # REST controllers (Job, Authentication, Application)
│   │   │           ├── dto/               # Data Transfer Objects
│   │   │           ├── model/             # JPA entity classes
│   │   │           ├── exception/         # exception treatment
│   │   │           ├── repository/        # Spring Data JPA repositories
│   │   │           ├── service/           # Service layer
│   │   │           └── JobPortalApplication.java
│   │   └── resources/
│   │       ├── application.properties         # Main configuration
```

---

## ✅ Features

- RESTful APIs for:
  - Job management
  - Category management
  - Application handling
- PostgreSQL integration via JPA
- CORS config for frontend on `http://localhost:4200`
- Swagger API documentation
- DTO usage for request/response encapsulation
- Organized by clean architecture principles (Controller → Service → Repository)

---

## 🚀 Getting Started

### 🧰 Prerequisites

- Java 23
- Maven
- PostgreSQL

### ▶️ Run Locally

```bash
git clone https://github.com/xuliya000/job-portal-backend
cd job-portal-backend
mvn spring-boot:run
```

---

## ⚙️ Configuration

Example `application.properties`:

```properties
server.port=8080

spring.datasource.url=jdbc:postgresql://aws-0-eu-west-3.pooler.supabase.com:6543/postgres?prepareThreshold=0
spring.datasource.username=postgres.ddkhchvbbysgxbvdtobx
spring.datasource.password=WBOmpt5I5DdjUHZL

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


```

---

## 📚 API Documentation

Swagger UI available at:
```
http://localhost:8080/swagger-ui/index.html
```

---

## 👥 Authors

- Hongxiang LIN
- Liya XU

---

## 📌 Notes

- Use Swagger to test endpoints quickly
- All endpoints are versioned under `/v1`
- Remember to run PostgreSQL with Supabase for production
