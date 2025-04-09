import React , {useRef, useState } from "react";
import TodoTemplate from "./components/TodoTemplate";
import TodoInsert from "./components/TodoInsert";
import TodoList from "./components/TodoList";
import './App.css';

const App = () => {
  const [todos, setTodos] = useState([
    {
      id: 1,
      text: "리액트의 기초 알아보기",
      checked: true,
    },
    {
      id: 2,
      text: "컴포넌트 스타일링해 보기",
      checked: true,
    },
    {
      id: 3,
      text: "일정 관리 앱 만들어 보기",
      checked: false,
    },
  ]);

  const nextId = useRef(4);

  const handleInsert = (text) => {
    const newTodo = { id: nextId.current, text, checked: false };
    setTodos([...todos, newTodo]);

    nextId.current += 1;
  }
  
  const handleToggle = (id) => {
    setTodos(
      todos.map((todo) =>
        todo.id === id ? { ...todo, checked: !todo.checked } : todo
      )
    );
  }

  const onRemove = (id) => {
    setTodos(
      todos.filter((todo) => {
        return todo.id !== id;
      }
      )
    );
  }
  
  

  return (
    <div className="App">
      <div className="container">
        <TodoTemplate>
          <TodoInsert onInsert = {handleInsert} />
          <TodoList todos={todos} onToggle={handleToggle} onRemove={onRemove} />
        </TodoTemplate>
      </div>
    </div>
  );
};

export default App;
