import React, {
  useState,
  useRef,
  useEffect,
  Component,
  createRef,
} from "react";

import "../cms/css/style.css";
import signupImg from "../cms/images/signup-img.jpg";

import { connect } from "react-redux";
import { userregister } from "../redux/customaction/registeraction";

import Modal from "react-modal";
import AddressForm from "../Pages/AddressForm";

class RegistrationPage extends Component {
  constructor(props) {
    super(props);
    console.log("Component constructor!");
    this.state = {
      username: "",
      password: "",
      addresses: [],
      modalIsOpen: false,
    };

    this.form = createRef(); // To reference the form
    this.handleUsernameChange = this.handleUsernameChange.bind(this);
    this.handlePasswordChange = this.handlePasswordChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);

    this.addAddress = this.addAddress.bind(this);
    this.openModal = this.openModal.bind(this);
    this.closeModal = this.closeModal.bind(this);
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
    console.log("handleUsernameChange:", this.state.username);
  }

  handlePasswordChange(e) {
    this.setState({ password: e.target.value });
    console.log("handlePasswordChange:", this.state.password);
  }

  // open start

  addAddress(address) {
    this.setState((prevState) => ({
      addresses: [...prevState.addresses, address],
    }));
  }

  openModal() {
    this.setState({ modalIsOpen: true });
  }

  closeModal() {
    this.setState({ modalIsOpen: false });
  }

  //open stop

  handleSubmit(e) {
    e.preventDefault();
    const { username, password, addresses } = this.state;
    console.log("Username:", username);
    console.log("password:", password);
    // this.props.userregister(username); // Call the dispatch function from props

    // Dispatch an action
    this.props.dispatch(userregister(username, password));
  }

  render() {
    console.log("Component render!");
    console.log(this.props.register.loading);
    const { modalIsOpen } = this.state;
    return (
      <>
        <div class="main">
          <div class="container">
            <div className="signup-content">
              <div class="signup-img">
                <img src={signupImg} alt="Signup" />
              </div>
              <div class="signup-form">
                <form
                  onSubmit={this.handleSubmit}
                  ref={this.form}
                  class="register-form"
                  id="register-form"
                >
                  <h2>Candidate Registration Page</h2>
                  <div class="form-row">
                    <div class="form-group">
                      <label for="username">Name :</label>
                      <input
                        type="text"
                        name="username"
                        id="username"
                        onChange={this.handleUsernameChange}
                        required
                      />
                    </div>
                    <div class="form-group">
                      <label for="father_name">Father Name :</label>
                      <input
                        type="text"
                        name="father_name"
                        id="father_name"
                        required
                      />
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="Password">Password:</label>
                    <input
                      type="password"
                      style={{ width: "200px", height: "30px" }}
                      onChange={this.handlePasswordChange}
                      placeholder="Password"
                      required
                    />
                  </div>

                  <div className="form-group">
                    <label htmlFor="username">Home Address:</label>
                    <button onClick={this.openModal}>Home Address</button>
                    <Modal
                      isOpen={modalIsOpen}
                      onRequestClose={this.closeModal}
                      contentLabel="Add Address"
                      style={{
                        content: {
                          width: "400px", // Set custom width
                          height: "300px", // Set custom height
                          margin: "auto", // Center modal
                          padding: "20px",
                        },
                        overlay: {
                          backgroundColor: "rgba(0, 0, 0, 0.5)", // Optional: semi-transparent background
                        },
                      }}
                    >
                      <h2>Add New Address</h2>
                      <AddressForm
                        addAddress={this.addAddress}
                        closeModal={this.closeModal}
                      />
                      <button onClick={this.closeModal}>Close</button>
                    </Modal>
                  </div>
                  <div class="form-submit">
                    <input
                      type="submit"
                      value="Reset All"
                      class="submit"
                      name="reset"
                      id="reset"
                    />
                    <input
                      type="submit"
                      value="Submit Form"
                      class="submit"
                      name="submit"
                      id="submit"
                    />
                  </div>
                </form>
              </div>
            </div>
          </div>
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
// const mapDispatchToProps = (dispatch) => {
//   return {
//     userregister: (username) => dispatch(userregister(username)),
//   };
// };

// Map dispatch to props
const mapDispatchToProps = (dispatch) => ({
  dispatch, // This will make the dispatch function available in props
});

export default connect(mapStateToProps, mapDispatchToProps)(RegistrationPage);
