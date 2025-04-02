import React, { Component } from "react";

export default class EventHandle extends Component {
  //바벨이 생성자 내부에 만드는 코드로 변환한다.
  state = {
    message: "",
    username: "",
  };

  render() {
    return (
      <div>
        <input type="text" name="username" placeholder="user name"></input>
        <input type="text" name="message" placeholder="message"></input>
        <button type="button" onClick="">
          확인
        </button>
        <div></div>
      </div>
    );
  }
}
