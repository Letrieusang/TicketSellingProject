


import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom"
import Home from "./pages/Home"
import Cart from "./pages/Cart";
import ProductDetail from "./component/ProductDetail";
function App() {
  return (
    <Router>
      <Routes>
       <Route path="/" element={<Navigate to="/home" replace />} />
        <Route path="/home" element={<Home/>}/>
        <Route path="/cart" element={<Cart/>}/>
        <Route path="/home/detail/:id" element={<ProductDetail/>}/>

      </Routes>
    </Router>
  );
}

export default App;
