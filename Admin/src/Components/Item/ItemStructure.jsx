import React, { useState} from "react";
import PropTypes from "prop-types";
import { useNavigate } from "react-router";
import axios from "axios";
import "./ItemStructure.css";

function ItemStructure(props) {
  const navigate = useNavigate();



  const handleAddToBasket = () => {
    axios
      .patch(`http://localhost:8088/item/add/${props.id}/1`)
      .then(() => {
        navigate("/items");
      })
      .catch((error) => alert('Item has already been added to the basket '));
  };



  return (
    <div id="itemCard" className="card-group d-inline-flex padding" style={{padding: "20px"}}>
      <div class="card border-dark mb-3" style={{width: "17%"}}>
        <ul class="list-group list-group-flush">
           <img src={props.image} alt="props.alt" width="120px"></img>         
          <li class="list-group-item">Name: {props.name} </li>
          <li class="list-group-item">Price: £{props.price} </li>




<li class="list-group-item">Bulk Size: {props.bulkSize}</li>
        </ul>
      <button type="button" onClick={handleAddToBasket} className="btn btn-success ">
        Add to basket
      </button>
  
      </div>
    </div>
  );
}

ItemStructure.propTypes = {
  name: PropTypes.string.isRequired,
  quantity: PropTypes.number.isRequired,
  bulkSize: PropTypes.string.isRequired,
  price: PropTypes.number.isRequired,
  image: PropTypes.string.isRequired,
  imageAlt: PropTypes.string.isRequired,
  id: PropTypes.number.isRequired,
};

export default ItemStructure;