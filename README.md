# To-Do List API

This is a RESTful API for a To-Do List application, built using **Spring Boot** and **MongoDB**.

## Features
- Create, update, delete, and list tasks
- Uses MongoDB as a NoSQL database
- RESTful API endpoints

## Prerequisites
- Java 17+
- Maven
- Docker (for containerization)

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/todo-list-api.git
   cd todo-list-api
   ```
2. Build the project using Maven:
   ```sh
   mvn clean install
   ```
3. Run the application:
   ```sh
   mvn spring-boot:run
   ```

## Running with Docker

1. **Build the Docker image:**
   ```sh
   docker build -t todo-list-api .
   ```
2. **Run the container:**
   ```sh
   docker run -p 8080:8080 todo-list-api
   ```

## Running with Docker Compose (MongoDB included)

Create a `docker-compose.yml` file with the following content:

```yaml
version: '3.8'
services:
  mongo:
    image: mongo:latest
    container_name: mongodb
    ports:
      - "27017:27017"
    environment:
      MONGO_INITDB_DATABASE: tododb
  app:
    build: .
    container_name: todo-app
    ports:
      - "8080:8080"
    depends_on:
      - mongo
```

Then run:
```sh
docker-compose up --build
```

## API Endpoints

| Method | Endpoint        | Description        |
|--------|---------------|--------------------|
| GET    | /tasks        | Get all tasks      |
| POST   | /tasks        | Create a new task |
| PUT    | /tasks/{id}   | Update a task     |
| DELETE | /tasks/{id}   | Delete a task     |

## Testing with Postman

You can use Postman to interact with the API. Example request:

- **Create a task:**
  ```json
  {
    "title": "Learn Docker",
    "completed": false
  }
  ```

## Contributing
Feel free to fork the repository and submit pull requests!

## License
This project is licensed under the MIT License.

