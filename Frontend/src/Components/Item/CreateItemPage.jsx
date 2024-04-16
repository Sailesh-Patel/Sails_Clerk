
import BasketsDisplay from "../Basket/BasketDisplay";
import BasketTable from "../Basket/BasketTable";
import CreateItem from "./CreateItem";
import ItemDisplay from "./ItemDisplay";
import ItemTable from "./ItemTable";

function CreateItemPage() {
    return (
        <div>

            <h1 class="d-flex justify-content-center">Create items</h1>

            <CreateItem/>
            <ItemTable/>
            <BasketsDisplay/>
            <BasketTable/>
        </div>
    )
}

export default CreateItemPage;