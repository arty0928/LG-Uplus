import React, { useReducer, useState } from 'react';
import './Todo.css';

interface TodoItem{
  id: number,
  text: string,
  completed: boolean;
}

enum Command {
  ADD,
  TOGGLE,
  REMOVE,
}

type Action =
  | { type: Command.ADD, text: string }
  | { type: Command.TOGGLE, id: number }
  | { type: Command.REMOVE, id: number };

const reducer = (state: TodoItem[], action: Action) => {
  switch (action.type) {
    case Command.ADD: {
      return [...state, { id: Date.now(), text: action.text, completed: false }];
    }  
    case Command.TOGGLE: {
      // return state.map((todo : TodoItem) => {
        //reducer = (state: TodoItem[], action: Action)
        // ==> state가 TodoItem[] 타입이므로 map으로 오는 todo는 TodoItem으로 유추 가능하므로 선언 안해도 됨
        // -> 유추가능한 인자가 오면 '자료형 명시' 생략 가능
        return state.map((todo) => todo.id === action.id ? { ...todo, completed: !todo.completed } : todo);
    }    
    case Command.REMOVE: {
      return state.filter((todo) => todo.id !== action.id);  
    } 
    default:
      return state;
  }
};
    
const Todo = () => {
  //useReducer (상태변화처리함수, 초기값) : 상태변화처리함수에서 상태에 대한 타입을 정의했으므로
  //                                     추론이 가능해서 타입을 정의 X
  const [todos, dispatch] = useReducer(reducer, []);
  
  // useState<상태의타입>(초기값)         상태에 대한 추론할 곳이 없으므로 반드시 타입을 선언
  const [text, setText] = useState<string>("");

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setText(e.target.value);
  }

  const handleAdd = () => {
    dispatch({ type: Command.ADD, text });
    setText("");
  }

  const handleCompleted = () => {
    
  }
  

  return (
    <div className="app">
      <div className="todo-container">
        <h2>📋 Todo List</h2>
        <div className="input-container">
          <input value={text} onChange={handleChange} placeholder='할 일을 입력하세요'/>
          <button onClick={handleAdd}>추가</button>
        </div>
        <ul className="todo-list">
          {todos.map((todo) => (
            <li key={todo.id} className="todo-item">
              <div className={`todo-text ${todo.completed?"completed" : ""}`}>{todo.text}</div>
              <button onClick={() => {
                dispatch({type: Command.TOGGLE, id:todo.id})
              }}>완료</button>

              <button onClick={() => {
                dispatch({type: Command.REMOVE, id:todo.id})
              }}>삭제</button>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};



export default Todo;