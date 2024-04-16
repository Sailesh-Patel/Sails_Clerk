import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";


<html lang="en"></html>


function Login() {

  const [name, setName] = useState("");
  const navigate = useNavigate();
  const [baskets, setBaskets] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8088/basket/get")
      .then((response) => setBaskets(response.data))
      .catch((error) => console.error(error));
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();

    axios
      .post("http://localhost:8088/basket/create", { name, items: [] })
      .then((response) => {
        setName("");

        navigate("/home");

      })
      .catch((err) => console.error(err));
  };

  const BasketExists = baskets.length > 0;

  return (
<div>

<h2 className="title" style={{ textAlign: "center" }}>Login Form</h2>
  <div class="d-flex justify-content-center" style={{ padding: "10px" }}>
    <div class="card border-dark mb-3" style={{ width: "17%" }}>
      
    <form className="container" onSubmit={handleSubmit}>
      <div className="context" id="CreateBasket">
        <div className="row">
          <div className="col">
            <div label htmlFor="name" className="form-label">
              <h3>Create your Username</h3>

            </div>
            <input
              type="text"
              placeholder="Enter your name"
              id="name"
              size="20"
              value={name}
              onChange={(e) => setName(e.target.value)}
              required
              disabled={BasketExists} 
            />
                 <br />
                    <br />
        <input type="password" placeholder="Password" />
        <br />
          </div>
        </div>
      </div>
      <br />
      <div>
        <button type="submit" id="SubmitCreateBasket" disabled={BasketExists} className="btn btn-primary" 
        style={{textAlign: "center"}}
        onSubmit={() => {

          navigate("/home");

        }}
        >
        Sign in
        </button>
      </div>
    </form>
    </div>
  </div>


    </div>
  );
}

export default Login;
