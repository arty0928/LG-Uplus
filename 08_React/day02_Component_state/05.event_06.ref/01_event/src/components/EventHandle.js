import React, { useState } from "react";

/**
 * [구현 퀴즈] : username, message를 한번에 입력받고 처리하도록 객체로 만들어보기 
 */
const EventHandle = () => {

  const [data, setData] = useState({ username: '', message: '' });
  
  const { username, message } = data;

  const handleChange = (e) => {
    console.log(e);
    // 변경하려는 state만 남고 다른 state는 모두 제거됨
    // setData({ [e.target.name]: e.target.value }); // 바로 바꾸면 안됨 (불변성)

    /* 
      불변성 유지하기 위해 새로운 객체 생성하고 해당 속성만 변경해야 한다.
        1. 기존 객체 복제
        2. 특정 state만 변경
    */
    const newForm = {
      ...data,  //기본 state를 복제
      [e.target.name]: e.target.value
    } //이벤트가 발생한 state만 변경하기
    setData(newForm);
  };
  
  
  const hanldeClick = () => {
    setData({ username: "", message: "" });
  };
  
  return (
    <div>
      <input
        type="text"
        value={username}
        onChange={handleChange}
        name="username"
        placeholder="user name"></input>
      
      <input
        type="text"
        value={message}
        onChange={handleChange}
        name="message"
        placeholder="message"></input>
      
      <button type="button" onClick={hanldeClick}>
        확인
      </button>

      <div>
        {username} {username !== "" && ":"}
        {message}
      </div>
    </div>
  );
};

export default EventHandle;
