import { useEffect, useState } from 'react';

function App() {
  const [tasks, setTasks] = useState([]);
  const [newTask, setNewTask] = useState("");

  useEffect(() => {
    fetch("http://localhost:8080/api/tasks")
      .then((response) => response.json())
      .then((data) => setTasks(data))
      .catch((error) => console.error("Error fetching tasks:", error));
  }, []);

  const addTask = () => {
    if (!newTask.trim()) return;

    fetch("http://localhost:8080/api/tasks", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ title: newTask, completed: false }),
    })
      .then(response => response.json())
      .then(data => {
        setTasks([...tasks, data]);
        setNewTask("");
      })
      .catch(error => console.error("Error adding task:", error));
  };

  const toggleCompletion = (task) => {
    fetch(`http://localhost:8080/api/tasks/${task.id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ ...task, completed: !task.completed }),
    })
    .then(response => response.json())
    .then(updatedTask => {
      setTasks(tasks.map(t => (t.id === updatedTask.id ? updatedTask : t)));
    })
    .catch(error => console.error("Error updating task:", error));
  };

  const deleteTask = (id) => {
    console.log("Deleting task with id:", id);
    fetch(`http://localhost:8080/api/tasks/${id}`, {
      method: "DELETE"
    })
      .then(() => setTasks(tasks.filter(task => task.id !== id)))
      .catch(error => console.error("Error deleting task:", error));
  };

  return (
    <div>
      <h1>To-Do List</h1>

      {/* Input field for new task */}
      <input
        type="text"
        value={newTask}
        onChange={(e) => setNewTask(e.target.value)}
        onKeyDown={(e) => e.key === "Enter" & addTask()}
        placeholder="Enter a new task"
      />
      <button onClick={addTask}>Add Task</button>

      <ul>
        {tasks.map((task) => (
          <li key={task.id}>
            {task.title} - {task.completed ? "Completed ✅" : "Not Completed ❌"}
            <button onClick={() => toggleCompletion(task)}>Toggle</button>
            <button onClick={() => deleteTask(task.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
