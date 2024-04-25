import React, { useState, useEffect } from "react";
import axios from "axios";


<html lang="en"></html>


function Reporting() {

  const [contact, setContact] = useState("");
  const [message, setMessage] = useState("");


  const handleSubmit = (e) => {
    e.preventDefault();

    axios
      .post("http://localhost:8088/reporting/create", { contact, message })
      .then((response) => {
        setContact("");
        setMessage("");

        

      })
      .catch((err) => console.error(err));
  };


  return (
<div>

<h2 className="title" style={{ textAlign: "center" }}>Error Reporting:</h2>
  <div class="d-flex justify-content-center" style={{ padding: "10px" }}>
    <div class="card border-dark mb-3" style={{ width: "55%" }}>
      
    <form className="container" onSubmit={handleSubmit}>
      <div className="context" id="CreateBasket">
        <div className="row">
          <div className="col">
            <div label htmlFor="name" className="form-label">
              <h3>If you have identified an issue with the site. Please let us know</h3>

            </div>
            <input
              type="text"
              placeholder="Enter your name/E-mail"
              id="contact name"
              size="20"
              value={contact}
              onChange={(e) => setContact(e.target.value)}
              required
              
            />
                 <br />
                    <br />
        <textarea
        id="error message"
        value = {message} 
        onChange={(e) => setMessage(e.target.value)}
        cols="50"
        rows="8"
        overflow-y="scroll"
        style = {{height:"40px"}}
        placeholder="Report error here" >
        </textarea>
        
        <br />
          </div>
        </div>
      </div>
      <br />
      <div>
        <button type="submit" id="SubmitMessage"  className="btn btn-primary" 
        style={{textAlign: "center"}}
        onSubmit={() => {

    

        }}
        >
        Submit Error Message
        </button>
      </div>
    </form>
    </div>
  </div>


    </div>
  );
}

export default Reporting;
