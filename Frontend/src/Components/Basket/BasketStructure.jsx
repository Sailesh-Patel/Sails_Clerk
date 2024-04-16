import React from "react";

function BasketStructure({ id, name, items }) {
  return (
    <div>
      <p>ID: {id}</p>
      <p>Name: {name}</p>
      {items && items.length > 0 && (
        <div>
          <strong>Items:</strong>
          <ul>
            {items.map((item) => (
              <li key={item.id}>
                {item.name}, Quantity: {item.quantity}, Price: £{item.price}
              </li>
            ))}
          </ul>
        </div>
      )}
    </div>
  );
}

export default BasketStructure;
