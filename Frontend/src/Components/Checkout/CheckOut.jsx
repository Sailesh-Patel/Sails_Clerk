import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function CheckOut() {
  const [phone, setPhone] = useState("");
  const [email, setEmail] = useState("");
  const navigate = useNavigate();
  const [baskets, setBaskets] = useState([]);



  const handleSubmit = (e) => {
    e.preventDefault();

    axios
      .post("http://localhost:8088/checkout/create", { phone, email })
      .then((response) => {
        setPhone("");
        setEmail("");
        navigate("/home");
      })
      .catch((err) => console.error(err));
  };

  const BasketExists = baskets.length > 0;
return (
  <div>

<div className="card-group d-inline-flex padding" style={{ padding: "10px" }}>
    <div class="card border-dark mb-3" style={{ width: "17%" }}>
          <form className="App" onSubmit={handleSubmit}>
    <div className="container" id="CreateBasket">
      <div className="row">
        <div className="col">
          <div label htmlFor="name" className="form-label">
            <h4>Check Out</h4>
          </div>
          <input
            type="text"
            placeholder="Enter Phone Number"
            id="phone number"
            size="20"
            value={phone}
            onChange={(e) => setPhone(e.target.value)}
            required

          />
               <br />
                  <br />
      <input type="Email Address" 
      placeholder="Enter Email Address" 
      id="email"
      size="30"
      value={email}
      onChange={(e) => setEmail(e.target.value)}
      required
      
      />
      <br />
        </div>
      </div>
    </div>
    <br />
    <div>
      <button type="submit" id="SubmitCreateBasket"  className="btn btn-primary" 
      style={{textAlign: "center"}}
      onSubmit={() => {
        navigate("/home");
      }}
      >
      Submit
      </button>
    </div>
  </form>



          <div>
          <p> Thank you for shopping with us  </p>
          <p>A member of our team will contact you shortly to take payment</p>
             
        
          </div>
          </div>
</div>
  </div>
)
}

export default CheckOut
