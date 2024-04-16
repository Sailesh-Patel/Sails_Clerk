import './App.css';
import { Link, Route, Routes, BrowserRouter as Router } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import Home from './Components/Homepage/Home.jsx';
import PageForItem from './Components/Item/PageForItem.jsx';
import CreateItemPage from './Components/Item/CreateItemPage.jsx';
import BasketPage from './Components/Basket/BasketPage.jsx';
import Logo from './Business.png';
import React, { useState, useEffect } from "react";
import Login from './Components/Homepage/Login.jsx';
import ItemEdit from './Components/Item/ItemEdit.jsx';
import BasketEdit from './Components/Basket/BasketEdit.jsx';

import ShoppingBasketIcon from '@mui/icons-material/ShoppingBasket';
import CheckOut from './Components/Checkout/CheckOut.jsx';
import Support from './Components/Support/Support.jsx';



function App() {


  const [quantity, setQuantity] = useState(0);

  const calculateTotalQuantity = (items) => {
    if (!items || items.length === 0) {
      return 0;
    }

    return items.reduce((total, item) => total + item.quantity, 0);
  };


  return (


      <div class="p-3 mb-2 bg-warning text-dark" style={{ overflow: "auto" }}>



        <Router>
          <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#" aria-labelled="Navigation bar"></a>
            <Link to="/"
              aria-labelled='Navigation link to the login page'>
              <img src={Logo} alt='Logo Icon' className="navbar-brand" width="75px" />
            </Link>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
              <div className="navbar-nav">

     

<ul>

      {/* code held for testing */}

              {/* <li class="nav-item">
                <Link class="nav-item nav-link active" to="/"
                  aria-describedby='Navigation link to the login page'>Login</Link>
              </li> */}

                  <li class="nav-item">
                    <Link className="nav-item nav-link active" to='/home' 
                    aria-describedby='Navigation link to the home page'>Home</Link>
                  </li>



                  <li class="nav-item">
                    <Link className="nav-item nav-link active" to='/items' 
                  aria-describedby='Navigation link to the items page'>Items</Link>
              </li>




              <li class="nav-item">
                <Link className="nav-item nav-link active" to='/basket'
                  aria-describedby='Navigation link to the basket page'>
                      <ShoppingBasketIcon />

    
                    </Link>
                  </li>                  

              <li class="nav-item ">
                <Link className="nav-item nav-link active" to='/support'
                  aria-describedby='Navigation link to the support page'>Support</Link>
              </li>

      {/* code held for testing */}

              {/* <li class="nav-item ">
                <Link className="nav-item nav-link active" to='/createitems'
                  aria-describedby='Navigation link to the create items page'>Admin</Link>
              </li> */}
</ul>

              </div>
            </div>

          </nav>




          <div >
            <Routes>
              <Route path='/' element={<Login />} />
              <Route path='/home' element={<Home />} />
            <Route path='/basket' aria-describedby='Navigation link to the basket page' element={<BasketPage />} />
              <Route path='/items' element={<PageForItem />} />
              <Route path='/createitems' element={<CreateItemPage />} />
              <Route path='/item/update/:id' element={<ItemEdit />} />
              <Route path='/basket/update/:id' element={<BasketEdit />} />
              <Route path='/checkout' element={<CheckOut />} />
              <Route path='/support' element={<Support />} />
            </Routes>
          </div>


        </Router>

      </div>
      );

}

      export default App;