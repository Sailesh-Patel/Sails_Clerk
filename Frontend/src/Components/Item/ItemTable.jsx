import axios from "axios";
import { useState, useEffect } from "react";

import { Link} from "react-router-dom";

import ItemStructure from "./ItemStructure";

function ItemTable(props) {


    const [items, setItems] = useState([]);

    function getItems() {

        axios.get("http://localhost:8088/item/get")
            .then((response) => setItems(response.data))
            .catch((error) => console.log(error))
    }
    useEffect(getItems, []);

    const itemComponents = []

    for (const item of items) {
        console.log("Items:", props.item);
        itemComponents.push(
            <ItemStructure
                key={item.id + "" + "" + item.name}
                id={item.id}
                name={item.name}
                price={item.price}
                quantity={item.quantity}

                bulkSize={item.bulkSize}
                image={item.image}
                imageAlt={item.imageAlt}


            />
        )
    }
    return (

        <div>
            <div>
                <br />

                <table className="table table-bordered">
                    <thead className="table-dark">
                        <tr>

                            <th scope="col">Name</th>
                            <th scope="col">Price</th>
                            <th scope="col">Quantity</th>

                            <th scope="col">Bulk Size</th>

                            <th scope="col">Update</th>
                            <th scope="col">Delete</th>
                        </tr>
                    </thead>
                    <tbody className="table-group-divider">

                        {
                            items.map((item, index) => (
                                <tr>
                                    <td>{item.name}</td>
                                    <td>{item.price}</td>
                                    <td>{item.quantity}</td>

                                    <td>{item.bulkSize}</td>

                                    <td> <Link className="btn btn-primary" type="submit" to={`/Item/update/${item.id}`}>Update</Link> </td>
                                    <td><button type="button" className="btn btn-danger" onClick={() => {
                                        axios.delete("http://localhost:8088/item/delete/" + item.id)
                                            .then(res => {
                                                getItems()
                                            })
                                            .catch(err => console.error(err));

                                    }}>DELETE</button></td>
                                </tr>
                            ))
                        }

                        <div></div>
            

                    </tbody>
                </table>
            </div>
        </div >



    );
}

export default ItemTable;