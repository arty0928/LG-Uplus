import React, { Component } from "react";

class MultiInput extends Component {
  state = {
    isGoing: true,      //check box는 true/false로 처리해야 한다.
    numberOfGuests:2,   //number input 양식은 숫자로 초기화
  };

  handleChange = (e) => {
    const { type, id } = e.target;
    
    // 이벤트가 발생한 대상이 checkbox인지 number인지에 따라 value값을 처리
    const value = type === 'checkbox' ? e.target.checked : e.target.value;
    this.setState({
      [id] : value,
    })
  };
  
  render() {
    return (
      <form>
        <label for="isGoing">
          Is going:
          <input id="isGoing"
            type="checkbox"
            checked={this.state.isGoing}
            onChange={this.handleChange} />
        </label>
        <br />
        <label for="numberOfGuests">
          Number of guests:
          <input
            id="numberOfGuests"
            type="number"
            value={this.state.numberOfGuests}
            onChange={this.handleChange}  
          />
        </label>
      </form>
    );
  }
}

export default MultiInput;
