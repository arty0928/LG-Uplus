import React, { useRef, useState } from 'react';

const ValidationSample_ = () => {
    
    const inputId = useRef(null);
    const inputPw = useRef(null);
    
    const [data, setData] = useState({
        id: '',
        password: '',
        clicked: false,
        validated : false
    })

    const validation = () => {

        if (data.password.length < 8) {
            alert('비밀번호를 8자리 이상 입력하세요');
            this.inputPw.current.focus();
            return false;
        }
        if (data.id === '') {
            alert('아이디를 입력하세요');
            this.inputId.current.focus()
            return false;
        } else {
            return true;
        }
    }
    
    
    const handleChange = (e) => {
        const newForm = {
            ...data,
            [e.target.id] : e.target.value
        }
        setData(newForm);
    };

    const handleClick = (e) => {
        const id = inputId.current.value;
        const pw = inputPw.current.value;
        inputId.current.value = ''
        inputPw.current.value = '';
        setData({
            ...data,
            [e.target.id]: ''
            
        })
    };

    return (
    
        <div>
        {/* JSX에서 label을 작성할 때 for가 아닌 htmlFor를 사용한다. */}
        <label htmlFor="id">
          아이디 :
                <input
                    type="text"
                    className={data.clicked ? (data.validated ? "success" : "failure"): ""}
                    id="id"
                    ref={inputId}
                    value={data.id}
                    onChange={handleChange} />
        </label>
        <label htmlFor="password">
          비밀번호 :
                <input
                    type="password"
                    id="password"
                    className={data.clicked ? (data.validated ? "success" : "failure") :""}
                    ref={inputPw}
                    value={data.password}
                    onChange={handleChange}
            />
        </label>
        <button onClick={handleClick}>검증하기</button>
      </div>
    );
};

export default ValidationSample_;