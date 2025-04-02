import React, { Component } from 'react'

export default class Counter extends Component {
    constructor(props) {
        super(props);
        this.state = { count: 0 };
    }

    onIncrease = () => {
        this.setState({ count: this.state.count + 1 });
    };
    
    onDecrease = () => {
        this.setState({ count: this.state.count - 1 });
    };

    render() {
    return (
      <div>
            <h1>Class Count : {this.state.count}</h1>
            <button onClick={this.onIncrease}>+</button>
            <button onClick={this.onDecrease}>-</button>
        </div>
    )
  }
}
