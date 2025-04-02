import React from "react";

const EventHandle = () => {
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
};

export default EventHandle;
