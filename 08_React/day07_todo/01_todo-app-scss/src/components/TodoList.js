import React from 'react';
import TodoListItem from './TodoListItem';

const TodoList = ({todos, onToggle, onRemove}) => {
    return (
        <div>
            {todos.map((todo) => {
                return (
                    <TodoListItem
                        key={todo.id}
                        todo={todo}
                        onToggle={onToggle}
                        onRemove={onRemove}
                    />
                )
            })}    
        </div>
    );
};

export default TodoList;