import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "../node_modules/bootstrap/dist/js/bootstrap.bundle";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Header from "./components/header/header";
import Home from "./components/home/Home";
import NewsLetter from "./components/newsLetter/newsLetter";
import Footer from "./components/footer/footer";
import SingleProduct from "./components/singelProduct/singleProduct";
import About from "./components/about/about";
import Contact from "./components/contact/contact";
import PopularProduct from "./components/products/popular_product/popularProduct";
function App() {
  return (
    <>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/singleProduct" element={<SingleProduct />} />
          <Route path="/about" element={<About />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/products" element={<PopularProduct />} />
        </Routes>
        <NewsLetter />
        <Footer />
      </BrowserRouter>
    </>
  );
}

export default App;
