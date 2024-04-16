import axios from "axios";
import { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";

function BasketEdit() {

    const [id, setId] = useState("")
    const [name, setName] = useState("")
    const navigate = useNavigate();
    const params = useParams();
    const [basket, setBasket] = useState("")


    useEffect(function getBasket() {

        axios.get("http://localhost:8088/basket/get/" + params.id)
            .then((response) => {
                console.log(response.data);
                setName(response.data.name);
            })
            .catch((error) => console.log(error));
    }, []);

    function editBasket() {

        axios.patch("http://localhost:8088/basket/update/" + params.id,
            { name })
            .then(() => {
                navigate(-1);
            }).catch(err => console.error(err))
    }

    return (

        <form onSubmit={editBasket}>
            <label htmlFor="Name">Name</label>
            <br /><input className="form-control border-2 border-secondary rounded" style={{ width: "250px", height: "31px" }}
                id="Name"
                type="text"
                value={name}
                onChange={event => setName(event.target.value)}
                required
            />

            <div className="mt-2">
                <button className="btn btn-secondary" type="submit">Submit</button>
            </div>
        </form>

    );
}

export default BasketEdit;

