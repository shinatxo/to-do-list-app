# To-Do List App

This is a full-stack To-Do List application built using **Java (Spring Boot) for the backend** and **React (Vite) for the frontend**. It allows users to manage their tasks efficiently.

## Features
- RESTful API with CRUD operations
- MongoDB for data storage
- Frontend built with React + Vite
- Uses Postman for API testing
- Docker setup for containerization
- Deployed on GitHub

## Tech Stack
### Backend:
- Java 17
- Spring Boot 3.4.2
- Spring Data MongoDB
- JUnit for testing

### Frontend:
- React (Vite)
- Fetch API for API requests
- Tailwind CSS (optional for styling)

## Installation

### 1. Clone the Repository
```sh
git clone https://github.com/shinatxo/to-do-list-app.git
cd to-do-list-app
```

### 2. Run the Backend
Ensure you have **Java 17+** and **Maven** installed.
```sh
cd restful-api-project
mvn spring-boot:run
```

### 3. Run the Frontend
Ensure you have **Node.js 18+** and **npm** installed.
```sh
cd todo-frontend
npm install
npm run dev
```
Open [http://localhost:5173](http://localhost:5173) in your browser.

## API Endpoints
| Method | Endpoint        | Description          |
|--------|----------------|----------------------|
| GET    | /tasks         | Get all tasks       |
| POST   | /tasks         | Create a new task   |
| PUT    | /tasks/{id}    | Update a task       |
| DELETE | /tasks/{id}    | Delete a task       |

## Running Tests
To run the backend tests:
```sh
mvn test
```

## Docker Setup
Build and run the application using Docker:
```sh
docker-compose up --build
```

## Deployment
TBD (coming soon)

## Contributors
- **Shina Oguntoye**

## License
This project is licensed under the MIT License.

