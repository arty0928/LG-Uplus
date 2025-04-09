import { MdCheckBoxOutlineBlank, MdCheckBox, MdRemoveCircleOutline } from "react-icons/md";
import cn from "classnames";
import React from 'react';
import './TodoListItem.scss';

const TodoListItem = ({ todo, onToggle, onRemove }) => {
    const { id, text, checked } = todo;

    return (
        <div className="TodoListItem">
            <div className={cn("checkbox", { checked })}
                onClick={() => onToggle(id)}
            >
                {checked ? <MdCheckBox /> : <MdCheckBoxOutlineBlank />}
                <div className={cn("text", { checked })}>{text}</div>
        </div>
        <div className="remove" onClick={() => onRemove(id)} >
            <MdRemoveCircleOutline />
        </div>
        </div>
    );
};

export default TodoListItem;
