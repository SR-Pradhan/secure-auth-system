# 🔐 Secure Auth System

A **robust and secure authentication system** built using **Spring Boot, Spring Security, Thymeleaf, and MySQL**.
This project demonstrates industry-level practices for authentication, authorization, and session management.

---

## 🌟 Highlights

* 🔒 Secure authentication using Spring Security
* 🔑 Password encryption with BCrypt
* 👥 Role-based authorization (USER / ADMIN)
* 📊 Session management with protected routes
* 🎨 Responsive UI using Thymeleaf & Bootstrap
* ⚡ Clean MVC architecture

---

## 🚀 Features

* ✅ User Registration with validation
* ✅ Login & Logout functionality
* ✅ Encrypted password storage (BCrypt)
* ✅ Role-based access control
* ✅ Secure session handling
* ✅ Dashboard after login

---

## 🧠 System Architecture

```
Controller → Service → Repository → Database
```

* **Controller:** Handles incoming HTTP requests
* **Service:** Contains business logic
* **Repository:** Handles database operations using JPA
* **Security Config:** Manages authentication & authorization

---

## 🛠 Tech Stack

| Layer      | Technology                         |
| ---------- | ---------------------------------- |
| Backend    | Java, Spring Boot, Spring Security |
| Frontend   | Thymeleaf, HTML, CSS, Bootstrap    |
| Database   | MySQL                              |
| Build Tool | Maven                              |

---

## 📂 Project Structure

```
src/
 └── main/
     ├── java/com/sr/authsystem/
     │    ├── config/
     │    ├── controller/
     │    ├── model/
     │    ├── repository/
     │    ├── service/
     │
     └── resources/
          ├── templates/
          │    ├── index.html
          │    ├── login.html
          │    ├── registration.html
          │    └── dashboard.html
          └── application.properties
```

---

## ⚙️ Setup & Installation

### 🔹 1. Clone Repository

```bash
git clone https://github.com/SR-Pradhan/secure-auth-system.git
cd secure-auth-system
```

---

### 🔹 2. Configure MySQL Database

Create a database:

```sql
CREATE DATABASE secure_auth_db;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/secure_auth_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 🔹 3. Run Application

```bash
mvn spring-boot:run
```

---

### 🔹 4. Access Application

👉 http://localhost:8081

---

## 🔐 Authentication Workflow

```
[ Register ] → [ Encrypt Password ] → [ Store in DB ]
        ↓
[ Login ] → [ Validate Credentials ]
        ↓
[ Redirect to Dashboard ]
        ↓
[ Session Managed by Spring Security ]
```

---

## 🚀 Future Enhancements

* 📧 Email verification system
* 🔁 Forgot / Reset password
* 👤 User profile management
* 🧑‍💼 Admin dashboard
* 🔐 JWT-based authentication (for APIs)
* 🌐 REST API support

---

## 📌 Learning Outcomes

* Understanding of **Spring Security**
* Implementation of **authentication & authorization**
* Secure password handling using BCrypt
* Practical use of **MVC architecture**

---

## 👨‍💻 Author

**Sruti Ranjan Pradhan**

* 🔗 GitHub: https://github.com/SR-Pradhan
* 💼 Aspiring Full Stack Java Developer

---

## ⭐ Show Your Support

If you found this project useful:

* ⭐ Star this repository
* 🍴 Fork it
* 📢 Share with others

---

## 📄 License

This project is licensed under the MIT License.
