import './App.css';
import { Link, Route, Routes, BrowserRouter as Router } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import Logo from './Business.png';
import React from 'react';
import ItemEdit from './Components/Item/ItemEdit.jsx';
import BasketEdit from './Components/Basket/BasketEdit.jsx';
import Admin from './Components/Item/Admin.jsx';


function App() {
  return (
  <div class="p-3 mb-2 bg-warning text-dark" style={{ overflow: "auto" }}>
    <Router>
      <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        {/* <a class="navbar-brand" href="."></a> */}
        <Link to="/">
            <img src={Logo} alt='Logo Icon' className="navbar-brand" width="75px" />
          </Link>


      </nav>
      <div >
        <Routes>
          <Route path='/item/update/:id' element={<ItemEdit/>} />
          <Route path='/basket/update/:id' element={<BasketEdit/>} />
          <Route path='/' element={<Admin/>} />
        </Routes>
      </div>

    </Router>
  </div>
  );
}

export default App;