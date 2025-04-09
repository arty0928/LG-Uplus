import React from 'react';
import Welcome from './Welcome';

const style = {
    backgroundColor: "gray",
    color: "pink",
    fontSize: "30px",
    fontWeoght: "bold",
    padding: 6,
};

const App = () => {
    return (
        <div>
            <Welcome style = {style}>class</Welcome>
            <Welcome name = "React Component">ureca</Welcome>
            <Welcome name={ 2}>ureca</Welcome>
        </div>
    );
};

export default App;