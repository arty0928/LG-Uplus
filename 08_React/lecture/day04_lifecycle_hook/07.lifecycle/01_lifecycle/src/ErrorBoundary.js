import React, { Component } from 'react'

export default class ErrorBoundary extends Component {
  
  state = {
    error: false,
  };
  
  componentDidCatch(error, info) {
    console.log({ error, info });
    this.setState({ error: true });
  }
  
  render() {

    if (this.state.error) {
      return <div>에러가 발생했습니다. </div>;
    } else {
      // this.props.children  : 컴포넌트의 body 
      return this.props.children; //자식 컴포넌트 보이게 함.
    }
  }
}
