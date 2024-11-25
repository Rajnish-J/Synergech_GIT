import React, { useState, useEffect } from "react";
import TodoStore from "../stores/TodoStore"; // Import TodoStore
import TodoActions from "../actions/TodoActions"; // Import TodoActions

const TodoApp = () => {
  const [todos, setTodos] = useState(TodoStore.getTodos()); // Initialize state with todos from store

  // Subscribe to store changes
  useEffect(() => {
    const onChange = () => {
      setTodos(TodoStore.getTodos()); // Update state when store changes
    };

    TodoStore.on("change", onChange); // Listen to the store's change event

    return () => {
      TodoStore.removeListener("change", onChange); // Clean up listener when the component is unmounted
    };
  }, []);

  // Handle adding a new todo
  const handleAddTodo = () => {
    const todoText = prompt("Enter a new Todo:"); // Prompt user to enter a new todo
    if (todoText) {
      TodoActions.addTodo(todoText); // Dispatch action to add the todo
    }
  };

  return (
    <div
      style={{
        padding: "20px",
        fontFamily: "Arial",
        maxWidth: "400px",
        margin: "0 auto",
      }}
    >
      <h1>Todo List</h1>
      <button
        onClick={handleAddTodo}
        style={{
          backgroundColor: "#007BFF",
          color: "#fff",
          border: "none",
          padding: "10px 20px",
          cursor: "pointer",
          marginBottom: "10px",
          borderRadius: "5px",
        }}
      >
        Add Todo
      </button>
      <ul style={{ listStyleType: "none", padding: 0 }}>
        {todos.map((todo, index) => (
          <li
            key={index}
            style={{
              background: "#f8f9fa",
              padding: "10px",
              border: "1px solid #ddd",
              marginBottom: "5px",
              borderRadius: "5px",
            }}
          >
            {todo} {/* Render todo text */}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TodoApp;
