// src/components/AddressForm.js
import React, { useState } from "react";

const AddressForm = ({ addAddress, closeModal }) => {
  const [address, setAddress] = useState({
    street: "",
    city: "",
    state: "",
    zip: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setAddress({ ...address, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    addAddress(address);
    setAddress({ street: "", city: "", state: "", zip: "" });
    closeModal();
  };

  return (
    <form class="row g-3 needs-validation" onSubmit={handleSubmit}>
      <div>
        <label>Street:</label>
        <input
          class="form-control w-50"
          type="text"
          name="street"
          value={address.street}
          onChange={handleChange}
          style={{ width: "200px" }}
        />
      </div>
      <div>
        <label>City:</label>
        <input
          type="text"
          name="city"
          value={address.city}
          onChange={handleChange}
          style={{ width: "200px" }}
        />
      </div>
      <div>
        <label>State:</label>
        <input
          type="text"
          name="state"
          value={address.state}
          onChange={handleChange}
          style={{ width: "200px" }}
        />
      </div>
      <div>
        <label>Zip:</label>
        <input
          type="text"
          name="zip"
          value={address.zip}
          onChange={handleChange}
          style={{ width: "200px" }}
        />
      </div>
      <button type="submit">Add Address</button>
    </form>
  );
};

export default AddressForm;
