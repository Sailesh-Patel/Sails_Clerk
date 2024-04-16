import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function CreateBasket() {
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
        navigate("/items");
      })
      .catch((err) => console.error(err));
  };

  const BasketExists = baskets.length > 0;

  return (
  <div className="card-group d-inline-flex padding" style={{ padding: "10px" }}>
    <div class="card border-dark mb-3" style={{ width: "17%" }}>
      
    <form onSubmit={handleSubmit}>
      <div className="container" id="CreateBasket">
        <div className="row">
          <div className="col">
            <div label htmlFor="name" className="form-label">
              <h4>Create your basket</h4>
            </div>
            <input
              type="text"
              placeholder="Enter basket name here"
              id="name"
              size="20"
              value={name}
              onChange={(e) => setName(e.target.value)}
              required
              disabled={BasketExists} 
            />
          </div>
        </div>
      </div>
      <br />
      <div>
        <button type="submit" id="SubmitCreateBasket" disabled={BasketExists} className="btn btn-success" style={{textAlign: "center"}}>
          Submit
        </button>
      </div>
    </form>
    </div>
  </div>
  );
}

export default CreateBasket;
