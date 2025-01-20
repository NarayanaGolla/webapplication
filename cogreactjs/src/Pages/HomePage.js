import React, {
  useState,
  useRef,
  useEffect,
  Component,
  createRef,
} from "react";
import "../css/style.css";

import Counter from "../components/Counter";
import CounterComponent from "../components/CounterComponent";

class HomePage extends Component {
  constructor(props) {
    super(props);
    console.log("Component constructor!");
    this.state = {
      message: "Welcome!",
      username: "",
    };

    this.form = createRef(); // To reference the form
    this.handleUsernameChange = this.handleUsernameChange.bind(this);
  }

  componentDidMount() {
    console.log("Component mounted!");
  }

  componentDidUpdate(prevProps, prevState) {
    console.log("Component updated!");
  }

  componentWillUnmount() {
    console.log("Component will unmount!");
  }

  // Event handler to update the state
  changeMessage = () => {
    this.setState({ message: "Thanks for clicking the button!" });
  };

  handleUsernameChange(e) {
    this.setState({ username: e.target.value });
  }

  render() {
    console.log("Component render!");
    const { username, message } = this.state;
    return (
      <>
        <CounterComponent />
        <div class="wrapper">
          <div class="title">
            <span>Login Form</span>
          </div>
          <form onSubmit={this.handleSubmit} ref={this.form}>
            <div class="row">
              <i class="fas fa-user"></i>
              <input
                id="username"
                type="text"
                value={username}
                onChange={this.handleUsernameChange}
                placeholder="Email or Phone"
                required
              />
            </div>
            <div class="row">
              <i class="fas fa-lock"></i>
              <input type="password" placeholder="Password" required />
            </div>
            <div class="pass">
              <a href="#">Forgot password?</a>
            </div>
            <div class="row button">
              <input type="submit" onClick={this.changeMessage} value="Login" />
            </div>

            <div class="signup-link">
              Not a member? <a href="#">Signup now</a>
            </div>
          </form>
        </div>
      </>
    );
  }
}

export default HomePage;
