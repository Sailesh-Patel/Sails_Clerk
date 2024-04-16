import axios from "axios";
import { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";

function ItemEdit() {

        const [id, setId] = useState("")
        const [name, setName] = useState("")
        const [price, setPrice] = useState("")
        const [quantity, setQuantity] = useState("")
        const [image, setImage] = useState("")
        const [imageAlt, setImageAlt] = useState("")
        const navigate = useNavigate();
        const params = useParams();
        const [items, setItems] = useState("")
        const [bulkSize, setBulkSize] = useState("")



        useEffect(function getItems() {

            axios.get("http://localhost:8088/item/get/" + params.id)
                .then((response) => {
                    console.log(response.data);
                    setName(response.data.name);
                    setPrice(response.data.price);
                    setQuantity(response.data.quantity);
                    setImage(response.data.image);

                    setImageAlt(response.data.imageAlt);
                    setBulkSize(response.data.bulkSize);

                })
                .catch((error) => console.log(error));
        }, []);

        function editItem() {

            axios.patch("http://localhost:8088/item/update/" + params.id,

                { name, price, quantity, image, imageAlt, bulkSize })

                .then(() => {
                    navigate(-1);
                }).catch(err => console.error(err))
        }


        return (

            <form onSubmit={editItem}>
                <label htmlFor="Name">Name</label>
                <br /><input className="form-control border-2 border-secondary rounded" style={{ width: "250px", height: "31px" }}
                    id="Name"
                    type="text"
                    value={name}
                    onChange={event => setName(event.target.value)}
                    required
                />
                <br /><label htmlFor="price">Price</label>
                <br /><input className="form-control border-2 border-secondary rounded" style={{ width: "250px", height: "31px" }}
                    id="price"
                    type="double"
                    value={price}
                    onChange={event => setPrice(event.target.value)}
                    required
                />

                <br /><label htmlFor="quantity">Quantity</label>
                <br /><input className="form-control border-2 border-secondary rounded" style={{ width: "250px", height: "31px" }}
                    id="quantity"
                    type="number"
                    value={quantity}
                    onChange={event => setQuantity(event.target.value)}
                    required
                />



                <br /><label htmlFor="quantity">Bulk Size</label>
                <br /><input className="form-control border-2 border-secondary rounded" style={{ width: "250px", height: "31px" }}
                    id="bulkSize"
                    type="text"
                    value={bulkSize}
                    onChange={event => setBulkSize(event.target.value)}
                    required
                />



                <br /><label htmlFor="image">Image</label>
                <br /><input className="form-control border-2 border-secondary rounded" style={{ width: "250px", height: "31px" }}
                    size=""
                    id="image"
                    type="src"
                    value={image}
                    onChange={event => setImage(event.target.value)}
                    required
                />



                <br /><label htmlFor="imageAlt">Image Alt</label>
                <br /><input className="form-control border-2 border-secondary rounded" style={{ width: "250px", height: "31px" }}
                    size=""
                    id="imageAlt"
                    type="src"
                    value={imageAlt}
                    onChange={event => setImageAlt(event.target.value)}
                    required
                />


                <div className="mt-2">
                    <button className="btn btn-secondary" type="submit">Submit</button>
                </div>
            </form>

        );
    }

    export default ItemEdit;