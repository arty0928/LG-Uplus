import React, { useState } from 'react';
import Counter from './Counter';
import Say from './Say';

const App = () => {
    const [count, setCount] = useState(0);
    const increase = () => setCount(count + 1);
    const decrease = () => setCount(count + 1);
    
    return (
        <div>
            <Counter
                count={count}
                    increase={() => setCount(count + 1)}
                    decrease = {() => setCount(count - 1)}
            />
            <Say />
        </div>
    );
};

export default App;     