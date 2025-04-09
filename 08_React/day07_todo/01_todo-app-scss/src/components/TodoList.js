import React from 'react';

const TodoList = ({todos}) => {
    return (
        <div>
            {todos.map((todo) => {
                return (
                    <div key={todo.id}>
                        <button></button>
                        {todo.text}
                        <button>삭제</button>
                </div>

                )
            })}    
        </div>
    );
};

export default TodoList;