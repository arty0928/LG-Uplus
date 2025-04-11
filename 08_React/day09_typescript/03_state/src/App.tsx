import React, { useState } from "react";
import Counter from "./Counter";

const App = () => {
  const [count, setCount] = useState(0);
  const increase = () => setCount(count + 1);
  const decrease = () => setCount(count - 1);
  return (
    <div>
      <Counter/>
    </div>
  );
};

export default App;
