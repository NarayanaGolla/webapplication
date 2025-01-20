import axios from "axios";

// actions.js
import {
  FETCH_DATA_REQUEST,
  FETCH_DATA_SUCCESS,
  FETCH_DATA_FAILURE,
} from "./actionTypes";

const API_URL = "http://localhost:8100/app";

const fetchDataRequest = () => ({
  type: FETCH_DATA_REQUEST,
});

const fetchDataSuccess = (data) => ({
  type: FETCH_DATA_SUCCESS,
  payload: data,
});

const fetchDataFailure = (error) => ({
  type: FETCH_DATA_FAILURE,
  payload: error,
});

export const userregister = (username, password) => {
  return async (dispatch) => {
    dispatch(fetchDataRequest());
    var res = "";
    try {
      // Simulate API response

      const jwtResponseDTO = {
        //  token: 'your-jwt-token',
        username: username,
        password: password,
      };

      const response = await axios.post(API_URL + "/register", jwtResponseDTO);

      // const response = await axios.post(API_URL + "/users", {
      //   id: 23,
      //   name: userName,
      // });

      // Log the success response
      console.log("Success:", response.data);

      // Extract the relevant data from response
      const res = response.data;

      // Dispatch success action with the response data
      dispatch(fetchDataSuccess(res));

      // Return the response data
      return res;
    } catch (error) {
      // Handle any errors that occur
      console.error(
        "Error:",
        error.response ? error.response.data : error.message
      );

      dispatch(fetchDataFailure(error.message));
      throw error; // Reject the promise with the error
    }
  };
};

export const login = (userName, password) => {
  return async (dispatch) => {
    dispatch(fetchDataRequest());
    var res = "";
    var isActive = false;
    try {
      // Simulate API response

      const jwtResponseDTO = {
        //  token: 'your-jwt-token',
        username: userName,
        password: password,
      };

      // Perform the API call
      const response = await axios.post(API_URL + "/login", jwtResponseDTO, {
        headers: {
          "Content-Type": "application/json",
        },
      });

      // Log the success response
      console.log("Success:", response.data);

      // Extract the relevant data from response
      const res = response.data;

      // Dispatch success action with the response data
      dispatch(fetchDataSuccess(res));

      // Return the response data
      return res;
    } catch (error) {
      // Handle any errors that occur
      console.error(
        "Error:",
        error.response ? error.response.data : error.message
      );

      dispatch(fetchDataFailure(error.message));
      throw error; // Reject the promise with the error
    }
  };
};
