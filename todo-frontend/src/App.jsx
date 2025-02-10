import { useEffect, useState } from 'react'

function App() {
  const [tasks, setTasks] = useState([]);
  const [newTask, setNewTask] = useState("");

  useEffect(() => {
    fetchTasks();
  }, []);

  const fetchTasks = () => {
    fetch("http://localhost:8080/api/tasks")
      .then((response) => response.json())
      .then((data) => setTasks(data))
      .catch((error) => console.error("Error fetching tasks:", error));
  };

  const addTask = () => {
    if (!newTask.trim()) return;

    fetch("http://localhost:8080/api/tasks", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ title: newTask, completed: false }),
    })
    .then(() => {
      setNewTask("");
      fetchTasks();
    })
    .catch((error) => console.error("Error adding task:", error));
  };

  const toggleCompletion = (id, completed) => {
    fetch(`http://localhost:8080/api/tasks/${id}`, { 
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ completed: !completed }),
    })
      .then(() => fetchTasks())
      .catch((error) => console.error("Error deleting task:", error));
  };

  const deleteTask = (id) => {
    fetch(`http://localhost:8080/api/tasks/${id}`, {
      method: "DELETE"
    })
      .then(() => fetchTasks())
      .catch((error) => console.error("Error deleting task:", error));
  };

  return ( 
    <div>
      <h1>To-Do List</h1>
      <div>
        <input
          type="text"
          value={newTask}
          onChange={(e) => setNewTask(e.target.value)}
          placeholder="Enter a new task..."
          />
          <button onClick={addTask}>Add Task</button>
      </div>
      <ul>
        {tasks.map((task) => (
          <li key={task.id} style={{ textDecoration: task.completed ? "line-through" : "none" }}>
            {task.title}
            <button onClick={() => toggleCompletion(task.id, task.completed)}>
              {task.completed ? "Mark as Incomplete" : "Mark as Complete"}
            </button>
            <button onClick={() => deleteTask(task.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
