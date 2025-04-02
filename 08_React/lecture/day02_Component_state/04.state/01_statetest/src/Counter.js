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
        const { count, increase, decrease } = this.props;
    return (
        <div>
            <h1>Parent Count : {count}</h1>
            <button onClick={increase}>+</button>
            <button onClick={decrease}>-</button>
            
            <hr />
            <h1>Child Count : {this.state.count}</h1>
            <button onClick={this.onIncrease}>+</button>
            <button onClick={this.onDecrease}>-</button>
        </div>
    )
  }
}
