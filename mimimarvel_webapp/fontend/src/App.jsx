import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Header from "./components/header/header";
import Home from "./components/home/Home";
import Discount from "./components/discount/discount";
import OrderMethod from "./components/orderMethod/orderMethod";
import NewsLetter from "./components/newsLetter/newsLetter";
import Footer from "./components/footer/footer";
import SingleProduct from "./components/singelProduct/singleProduct";
function App() {
  return (
    <>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/singleProduct" element={<SingleProduct />} />
        </Routes>
        <Discount />
        <OrderMethod />
        <NewsLetter />
        <Footer />
      </BrowserRouter>
    </>
  );
}

export default App;
