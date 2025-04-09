import React, { useCallback, useState } from 'react';
import { MdAdd } from 'react-icons/md';
import './TodoInsert.scss';

// 부모 컴포넌트에서 onInsert 라는 이름의 props 넘겨줌
const TodoInsert = ({onInsert }) => {
    const [value, setValue] = useState("");

    const onChange = useCallback((e) => {
        setValue(e.target.value);
    }, [value]
    );

    const onClick = useCallback((e) => {
        e.preventDefault();
        console.log(value);
        if (value.trim() === "") return;

        onInsert(value);
        setValue("");
    }, [value]
    );

    return (
        <form className="TodoInsert">
        <input placeholder="할 일을 입력하세요" value={value} onChange={onChange} />
        <button  onClick={onClick}>
            <MdAdd />
        </button>
        </form>
    );
};

export default TodoInsert;