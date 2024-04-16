import axios from "axios";
import { useState, useEffect } from "react";
import { Link, Navigate } from "react-router-dom";
import BasketStructure from "./BasketStructure";

function BasketTable(props) {

    const [name, setName] = useState("")
    const [baskets, setBaskets] = useState([]);

    function getBaskets() {

        axios.get("http://localhost:8088/basket/get")
            .then((response) => setBaskets(response.data))
            .catch((error) => console.log(error))
    }
    useEffect(getBaskets, []);

    const basketComponents = []

    for (const basket of baskets) {
        console.log("Basket:", props.basket);
        basketComponents.push(
            <BasketStructure
                key={basket.id + "" + "" + basket.name}
                id={basket.id}
                name={basket.name}
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
                            <th scope="col">Update</th>



                        </tr>
                    </thead>
                    <tbody className="table-group-divider">

                        {
                            baskets.map((basket, index) => (
                                <tr>
                                    <td>{basket.name}</td>
                                    <td> <Link className="btn btn-primary" type="submit" to={`/Basket/update/${basket.id}`}>Update</Link> </td>

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

export default BasketTable;