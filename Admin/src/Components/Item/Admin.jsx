
import BasketsDisplay from "../Basket/BasketDisplay";
import BasketTable from "../Basket/BasketTable";
import CreateItem from "./CreateItem";
import ItemTable from "./ItemTable";

function Admin() {
    return (
        <div>
            <h1>Admin Portal</h1>
            <CreateItem/>
            <ItemTable/>
            <BasketsDisplay/>
            <BasketTable/>
        </div>
    )
}

export default Admin;