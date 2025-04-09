import React, { useReducer, useState } from 'react';
import './Todo.css';

const command = {
  ADD: "ADD",
  TOGGLE: "TOGGLE",
  REMOVE: "REMOVE",
};

//todo 상태를 위한 reducer 함수
const reducer = (state, action) => {
  switch (action.type) {
    case command.ADD:
      return [...state, { id: Date.now(), text: action.text, completed: false }]; //...state로 복제하고, {} 속성 하나 더 추가
    case command.TOGGLE:
      return state.map((todo) => 
        todo.id === action.id ? { ...todo, completed: !todo.completed } : todo
      );
    case command.REMOVE:
      return state.filter((todo) => todo.id !== action.id); // todo.id === action.id 인 애들을 뺄거니까
    default:
      return state;
  }
}


const Todo = () => {
  const [todos, dispatch] = useReducer(reducer, []);
  const [text, setText] = useState("");
  return (
     <div className="app">
      <div className="todo-container">
        <h2>📋 Todo List</h2>
        <div className="input-container">
          <input value={text}
          onChange={(e) => {
            setText(e.target.value);
            }}
          />
          <button onClick={() => {
            dispatch({ type: command.ADD, text }); //text:text 로 넣어도 되지만 속성과 값이 같으면 그냥 text만 해도 됨(ES6에 추가된 문법)
            setText("");
          }}>
            추가</button>
        </div>
        <ul className="todo-list">
          {todos.map((todo) => 
            <li className='todo-item'>
              <div className={`todo-text ${todo.completed ? "completed" : ""}`}>
                {todo.text}
                <button onClick={()=> dispatch({type:command.TOGGLE, id: todo.id })}>완료</button>
                <button onClick={()=> dispatch({type:command.REMOVE, id: todo.id })}>삭제</button>
              </div>
            </li>
          )}
        </ul>
      </div>
    </div>
  );
};

export default Todo;
   
