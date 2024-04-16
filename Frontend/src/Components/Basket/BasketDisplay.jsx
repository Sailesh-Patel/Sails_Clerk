import React, { useState, useEffect } from "react";
import axios from "axios";

import { useNavigate } from "react-router-dom"


function BasketsDisplay() {
  const navigate = useNavigate();
  const [baskets, setBaskets] = useState([]);
  const [quantity, setQuantity] = useState();


  useEffect(() => {
    axios.get("http://localhost:8088/basket/get")
      .then(response => setBaskets(response.data))
      .catch(error => console.error(error));
  }, []);

  const deleteBasket = () => {
    axios
    .delete(`http://localhost:8088/basket/delete/1`)
    .then(() => {
    })
  };


  const calculateTotalPrice = (items) => {
    if (!items || items.length === 0) {
      return 0;
    }

  
  const totalPrice = items.reduce((total, item) => total + item.price, 0);
  
  return Math.round(totalPrice * 100) / 100; // Round to 2 decimal places
};



    const calculateTotalQuantity = (items) => {
      if (!items || items.length === 0) {
        return 0;
      }

      return items.reduce((total, item) => total + item.quantity, 0);
    };


  return (
    <div>
      <div class="d-flex justify-content-center" style={{ padding: "10px" }}>
        <div class="card border-dark mb-3" style={{ width: "17%", textAlign: "center" }}>
          <div class="card-body"></div>
          {baskets.map(basket => (
            <div key={basket.id}>
              <h3>Basket Name: {basket.name}</h3>
              <div>
                {basket.items.map(basketItem => (
                  <div key={basketItem.id}>
                    {basketItem.name} 
                    <div> 
                    Price: £{basketItem.price} 
                    </div>

                    
          {/* Code held for future sprint */}

                    {/* <div className="quantity"> 
                    Quantity:  */}
                    {/* <button onClick={() => setQuantity(quantity - 1)}  className="decrement" class="bi bi-dash-lg">-</button>  */}
                    {/* <div id="quantityChange" className="quantity">{basketItem.quantity}</div> */}
                   {/* <button onClick={() => setQuantity(quantity + 1)} className="increment" class="bi bi-plus-lg">+</button> */}
                    {/* {basketItem.quantity} */}
                    {/* </div> */}

                    
                    <br></br>

                  </div>
                ))}
                <br/>
              </div>
              <p>Total Price: £{calculateTotalPrice(basket.items)}</p>
              <p>Total Quantity:{calculateTotalQuantity(basket.items)}</p>
            </div>
          ))}
<div>
  <button className="btn btn-primary"  onClick={() => {
        navigate("/checkout");
      }} >Checkout</button>
</div>

        </div>
      </div>
    </div>

  );
}

export default BasketsDisplay;
