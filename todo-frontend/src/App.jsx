import { useEffect, useState } from 'react';

const apiUrl = import.meta.env.VITE_API_URL;
fetch(`${apiUrl}/your-endpoint`)
  .then(response => response.json())
  .then(data => console.log(data));


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
    const updatedTask = {...task, completed: !task.completed};
  
    fetch(`http://localhost:8080/api/tasks/${task.id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(updatedTask),
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

  const clearTasks = () => {
    fetch("http://localhost:8080/api/tasks/all", {
      method: "DELETE"
    })
      .then(() => setTasks([]))
      .catch(error => console.error("Error clearing tasks:", error));
  };

  return (
    <div className="max-w-lg mx-auto p-4 bg-gray-100 rounded-lg shadow-lg">
      <h1 className="text-2xl font-bold text-center mb-4">To-Do List</h1>

      <div className="flex gap-2 mb-4">
        <input
          type="text"
          value={newTask}
          onChange={(e) => setNewTask(e.target.value)}
          onKeyDown={(e) => {
            if (e.key === "Enter") {
              addTask();
            }
          }}
          placeholder="Enter a new task"
          className="flex-1 p-2 border rounded"
      />
      <button 
        onClick={addTask}
        className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
      >
        Add Task
      </button>
    </div>

      <ul className="space-y-2">
        {tasks.map((task) => (
          <li 
            key={task.id}
            className="flex justify-between items-center p-2 bg-white rounded shadow"  
          >
            <span>
              {task.title} - {task.completed ? "Completed ✅" : "Not Completed ❌"}
            </span>
            <div className="space-x-2">
              <button 
                onClick={() => toggleCompletion(task)}
                className="bg-green-500 text-white px-3 py-1 rounded hover:bg-green-600"  
              >
                Toggle
              </button>
              <button 
                onClick={() => deleteTask(task.id)}
                className="bg-red-500 text-white px-3 py-1 rounded hover:bg-red-600"
              >
                Delete
              </button>
            </div>
          </li>
        ))}
      </ul>

      <button
        onClick={clearTasks}
        className="mt-4 w-full bg-gray-500 text-white px-4 py-2 rounded hover:bg-gray-600"
      >
        Clear All Tasks
      </button>
    </div>
  );
}

export default App;
