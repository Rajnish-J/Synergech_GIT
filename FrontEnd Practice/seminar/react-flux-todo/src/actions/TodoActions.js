import AppDispatcher from "../dispatcher/AppDispatcher"; // Import the dispatcher

const TodoActions = {
  // Action to add a todo
  addTodo: (text) => {
    AppDispatcher.dispatch({
      type: "ADD_TODO", // Action type
      payload: { text }, // The todo text
    });
  },
};

export default TodoActions;
