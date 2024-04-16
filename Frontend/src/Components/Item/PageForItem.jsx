import { useEffect, useState } from "react";
import axios from "axios";
import ItemDisplay from "./ItemDisplay";
import "./PageForItem.css";

function PageForItem() {
  function getItems() {
    axios.get("http://localhost:8088/item/get")
      .then((response) => { setItems(response.data) })
      .catch(console.log);
  }

  useEffect(() => {
    getItems();
  }, []);

  const [items, setItems] = useState([]);

  return (
    <div>
      <h1 className="header">

        </h1>
      <div id="ItemDisplay">
        <ItemDisplay listItems={items} />
      </div>
    </div>
  );
}

export default PageForItem;
