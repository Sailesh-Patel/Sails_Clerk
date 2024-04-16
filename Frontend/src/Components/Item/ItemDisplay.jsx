import React from "react";
import PropTypes from "prop-types";
import ItemStructure from "./ItemStructure";

function ItemDisplay({ listItems }) {
  return (
    <div className="container">
      {listItems.map((item) => (
        <ItemStructure
          key={item.id}
          id={item.id}
          name={item.name}
          price={item.price}
          image={item.image}

          imageAlt={item.imageAlt}
          quantity={item.quantity}
          bulkSize={item.bulkSize}


        />
      ))}
    </div>
  );
}

ItemDisplay.propTypes = {
  listItems: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      name: PropTypes.string.isRequired,
      price: PropTypes.number.isRequired,
      image: PropTypes.string.isRequired,

      imageAlt: PropTypes.string.isRequired,
      quantity: PropTypes.number.isRequired,
      bulkSize: PropTypes.string.isRequired,


    })
  ).isRequired,
};

export default ItemDisplay;
