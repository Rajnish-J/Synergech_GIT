import { EventEmitter } from "events"; // Import EventEmitter to emit changes
import AppDispatcher from "../dispatcher/AppDispatcher"; // Import the dispatcher

const TodoStore = Object.assign({}, EventEmitter.prototype, {
  todos: [], // Initial empty todos array

  // Get all todos
  getTodos() {
    return this.todos;
  },

  // Add a new todo to the list
  addTodo(text) {
    this.todos.push(text); // Add the new todo
    this.emit("change"); // Emit change event to notify listeners
  },

  // Handle actions dispatched from action creators
  handleActions(action) {
    switch (action.type) {
      case "ADD_TODO":
        this.addTodo(action.payload.text); // Handle the ADD_TODO action
        break;
      default:
        break;
    }
  },
});

// Register the store with the dispatcher
AppDispatcher.register(TodoStore.handleActions.bind(TodoStore));

export default TodoStore;
