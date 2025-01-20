import { useSelector, useDispatch } from "react-redux";

const CounterComponent = () => {
  const dispatch = useDispatch();

  const increment = () => {
    dispatch({ type: "INCREMENT" }); // Send an 'INCREMENT' action
  };

  const decrement = () => {
    dispatch({ type: "DECREMENT" }); // Send a 'DECREMENT' action
  };

  const count = useSelector((state) => state.customcounter.counter); // Access state

  return (
    <div>
      <h1>Counter: {count}</h1>
      <button onClick={increment}>Increment</button>
      <button onClick={decrement}>Decrement</button>
    </div>
  );
};

export default CounterComponent;
