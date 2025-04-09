import React, { useCallback, useState } from 'react';
import { MdAdd } from 'react-icons/md';



const TodoInsert = () => {
    const [value, setValue] = useState("");

    const onChange = useCallback((e) => {
        setValue(e.target.value);
    }, [value]
    );

    const onClick = useCallback((e) => {
        e.preventDefault();
        console.log(value);
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