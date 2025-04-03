//rcc, est 클래스


import React, { Component } from 'react'

export default class IterationSample2 extends Component {
  
  constructor(props) {
    super(props);
    this.state = {
      inputText: '',
      nextId: 5,
      names : [
          { id: 1, text: "눈사람" },
          { id: 2, text: "얼음" },
          { id: 3, text: "바람" },
          { id: 4, text: "봄" }
      ]
    };
  }



  handleChange = (e) => {
    this.setState({ inputText: e.target.value });
  }

  handleRemove = (id) => {
    const newNameList = this.state.names.filter((name) => id != name.id);
    this.setState({names: newNameList})
  };

  handleClick = () => {
    const { names, inputText, nextId} = this.state;

    const newNames = this.state.names.concat({ id: nextId, text: inputText });
    this.setState({
      names: newNames,
      nextId: nextId + 1,
      inputText: ''
    });
  }
  

  render() {
    // 구조 분해 할당 : 이렇게 안하면 위의 내용 접근하기 위해서
    // 계속 this.state.names ~~ 이렇게 접근해야 하니까 불편
    const { names, inputText} = this.state;
    
    const nameList = names.map((name) =>
      <li
        key={name.id}
        onClick={() => {
          this.handleRemove(name.id);
        }}>
        {name.text}
      </li>
    
    );

    return (
      <div>
        <input type='text' value={inputText} onChange={this.handleChange}/>
        <button onClick={this.handleClick}>추가</button>
        <ul>{nameList}</ul>
      </div>
    )
  }
}
