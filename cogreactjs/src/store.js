import { configureStore } from "@reduxjs/toolkit";
import counterReducer from "./counterSlice"; // Example slice
import customReducer from "./redux/customreducer/counterReducer"; // Example slice
import dataProcessReducer from "./redux/customreducer/dataprocessreducer";

const store = configureStore({
  reducer: {
    counter: counterReducer,
    customcounter: customReducer,
    register: dataProcessReducer, // Add reducers here
  },
});

export default store;
