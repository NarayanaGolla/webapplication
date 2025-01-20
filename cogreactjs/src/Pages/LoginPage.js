import React, {
  useState,
  useRef,
  useEffect,
  Component,
  createRef,
} from "react";
//import '../css/style.css';

import { connect } from "react-redux";
import { login } from "../redux/customaction/registeraction";
import { useNavigate } from "react-router-dom";
import PopupBox from "../Pages/PopupBox";

class LoginPage extends Component {
  constructor(props) {
    super(props);
    console.log("Component constructor!");
    this.state = {
      username: "",
      password: "",
      isOpen: false,
      isPopupOpen: false,
      shouldNavigate: false,
      message: "",
      error: "",
    };

    this.form = createRef(); // To reference the form
    this.handleUsernameChange = this.handleUsernameChange.bind(this);
    this.handlePasswordChange = this.handlePasswordChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
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

  handlePasswordChange(e) {
    this.setState({ password: e.target.value });
    console.log("handlePasswordChange:", this.state.password);
  }

  handleSubmit = (e) => {
    e.preventDefault();

    const { username, password, isOpen, isPopupOpen, shouldNavigate } =
      this.state;
    console.log("Username:", username);
    console.log("Password:", password);

    this.props
      .dispatch(login(username, password))
      .then((response) => {
        console.log(response); // Log the entire response object
        if (response && response.accessToken) {
          if (!isOpen) {
            this.setState({
              isOpen: true,
            });
          }

          this.setState({
            isPopupOpen: true,
            shouldNavigate: true,
            message: `Login successful! Token: ${response.accessToken}`,
          });
          localStorage.setItem("token", response.accessToken);
        } else {
          this.setState({
            message: "Login successful, but no access token received.",
          });
        }
      })
      .catch((error) => {
        const errorMsg =
          error.response && error.response.data
            ? error.response.data.message || "Login failed. Please try again."
            : error.message || "Login failed. Please try again.";

        if (!isOpen) {
          this.setState({
            isOpen: true,
          });
        }
        this.setState({
          isPopupOpen: true,
          shouldNavigate: false,
          message: errorMsg,
        });
      });
  };

  handlePopupClose = () => {
    const { shouldNavigate } = this.state;
    this.setState({
      isPopupOpen: false,
    });
    if (shouldNavigate) {
      // navigate("/home"); // Navigate to the home page
    }
  };

  render() {
    console.log("Component render!");
    const { username, message } = this.state;
    return (
      <>
        <div class="wrapper">
          <div class="title">
            <span>Login Form</span>
          </div>
          <form onSubmit={this.handleSubmit} ref={this.form}>
            <div class="row">
              <i class="fas fa-user"></i>
              <input
                id="username"
                name="username"
                type="text"
                onChange={this.handleUsernameChange}
                placeholder="User Name"
                required
              />
            </div>
            <div class="row">
              <i class="fas fa-lock"></i>
              <input
                type="password"
                name="password"
                onChange={this.handlePasswordChange}
                placeholder="Password"
                required
              />
            </div>
            <div class="pass">
              <a href="#">Forgot password?</a>
            </div>
            <div class="row button">
              <input type="submit" value="Login" />
            </div>
            <div class="signup-link">
              Not a member? <a href="#">Signup now</a>
            </div>
          </form>

          <PopupBox
            open={this.state.isPopupOpen}
            onClose={this.handlePopupClose}
          >
            <div>{message}</div>
            <button onClick={this.handlePopupClose}>Close</button>
          </PopupBox>
        </div>
      </>
    );
  }
}

// Map state to props
const mapStateToProps = (state) => {
  return {
    register: state.register,
  };
};

// Map dispatch to props
const mapDispatchToProps = (dispatch) => ({
  dispatch, // This will make the dispatch function available in props
});

export default connect(mapStateToProps, mapDispatchToProps)(LoginPage);
