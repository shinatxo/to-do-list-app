# To-Do List App

This is a full-stack **To-Do List Application** built with **Java (Spring Boot) for the backend** and **React (Vite) for the frontend**. It provides a simple and efficient way to manage tasks with full CRUD functionality.

## 🚀 Features
- RESTful API with full CRUD operations
- MongoDB for data storage
- Frontend built with React + Vite
- Tailwind CSS for styling
- Uses Postman for API testing
- Docker setup for containerization
- CORS enabled for frontend-backend communication
- Deployment ready (to be determined)

---

## 🛠️ Tech Stack
### Backend:
- **Java 17**
- **Spring Boot 3.4.2**
- **Spring Data MongoDB**
- **Spring Security (configured for CORS & API access)**
- **JUnit for testing**

### Frontend:
- **React (Vite)**
- **Fetch API for API requests**
- **Tailwind CSS for modern styling**

### Deployment:
- **Docker & Docker Compose** (for containerized setup)
- **TBD - Cloud deployment options**

---

## 🏗️ Installation & Setup

### 1️⃣ Clone the Repository
```sh
git clone https://github.com/shinatxo/to-do-list-app.git
cd to-do-list-app
```

### 2️⃣ Run the Backend
Ensure you have **Java 17+** and **Maven** installed.
```sh
cd restful-api-project
mvn spring-boot:run
```
Backend will be running at **http://localhost:8080**.

### 3️⃣ Run the Frontend
Ensure you have **Node.js 18+** and **npm** installed.
```sh
cd todo-frontend
npm install
npm run dev
```
Open **[http://localhost:5173](http://localhost:5173)** in your browser.

---

## 📌 API Endpoints
| Method | Endpoint         | Description          |
|--------|-----------------|----------------------|
| GET    | `/api/tasks`    | Get all tasks       |
| POST   | `/api/tasks`    | Create a new task   |
| PUT    | `/api/tasks/{id}` | Update a task       |
| DELETE | `/api/tasks/{id}` | Delete a task       |
| DELETE | `/api/tasks/all` | Clear all tasks     |

Test the API using **Postman** or **cURL**.

---

## 🧪 Running Tests
To run backend unit tests:
```sh
mvn test
```

---

## 🐳 Docker Setup (Optional)
Build and run the application using Docker:
```sh
docker-compose up --build
```
This will start both the frontend and backend as containers.

---

## 🚀 Deployment (Coming Soon)
- The application is structured for **cloud deployment** (e.g., **Heroku, AWS, or Vercel**).
- More details will be added soon.

---

## 👥 Contributors
- **Shina Oguntoye**

Feel free to fork, contribute, or report issues!

---

## 📜 License
This project is licensed under the **MIT License**.

---

_💡 Built with love using Java, Spring Boot, React, and Tailwind CSS!_

