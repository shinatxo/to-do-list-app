# To-Do List App

This is a full-stack **To-Do List Application** built with **Java (Spring Boot) for the backend** and **React (Vite) for the frontend**. It provides a simple and efficient way to manage tasks with full CRUD functionality.

---

## 🚀 Live Demo
- **Frontend:** [https://to-do-list-app-1-v3ji.onrender.com](https://to-do-list-app-1-v3ji.onrender.com)
- **Backend API Base URL:** [https://to-do-list-app-122e.onrender.com](https://to-do-list-app-122e.onrender.com)

---

## 🚀 Features
- RESTful API with full CRUD operations
- MongoDB for data storage
- Frontend built with React + Vite
- Tailwind CSS for styling
- Uses Postman for API testing
- Docker setup for containerization
- CORS enabled for frontend-backend communication
- **Deployed on Render**

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
- **Render** (Cloud deployment for both frontend and backend)
- **Docker & Docker Compose** (for containerized setup)

---

## 🏗️ Installation & Setup

### 1️⃣ Clone the Repository
```sh
git clone https://github.com/shinatxo/to-do-list-app.git
cd to-do-list-app
```

### 2️⃣ Backend Setup
Ensure you have **Java 17+** and **Maven** installed.
```sh
cd backend
mvn spring-boot:run
```
Backend will be running at **http://localhost:8080**.

### 3️⃣ Frontend Setup
Ensure you have **Node.js 18+** and **npm** installed.
```sh
cd frontend
npm install
npm run dev
```
Open **[http://localhost:5173](http://localhost:5173)** in your browser.

---

## 🌐 Environment Variables
### Frontend
Create a `.env.production` file in the `frontend` directory with:
```env
VITE_API_URL=https://to-do-list-app-122e.onrender.com
```

### Backend
No specific environment variables required, but you can configure MongoDB connection strings in `application.properties`.

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

## 🚀 Deployment on Render
This application is deployed on **Render** for both frontend and backend.

### Deployment Links
- **Frontend:** [https://to-do-list-app-1-v3ji.onrender.com](https://to-do-list-app-1-v3ji.onrender.com)
- **Backend:** [https://to-do-list-app-122e.onrender.com](https://to-do-list-app-122e.onrender.com)

### Redeployment Instructions
1. **Make changes locally** and push to your GitHub repository.
2. Go to Render Dashboard and find your **Web Service**.
3. Select **Manual Deploy** or enable **Auto Deploy** for the respective service.
4. **Frontend:** Navigate to Static Site and click **Deploy**.
5. **Backend:** Navigate to Web Service and click **Deploy**.

---

## 👥 Contributors
- **Shina Oguntoye**

Feel free to fork, contribute, or report issues!

---

## 📜 License
This project is licensed under the **MIT License**.

---

_💡 Built with love using Java, Spring Boot, React, and Tailwind CSS!_


