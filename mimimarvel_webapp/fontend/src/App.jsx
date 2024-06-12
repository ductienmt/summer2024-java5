import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "../node_modules/bootstrap/dist/js/bootstrap.bundle";
import { BrowserRouter, Routes, Route, useLocation } from "react-router-dom";
import Header from "./components/header/header";
import Home from "./components/home/Home";
import NewsLetter from "./components/newsLetter/newsLetter";
import Footer from "./components/footer/footer";
import SingleProduct from "./components/singelProduct/singleProduct";
import About from "./components/about/about";
import Contact from "./components/contact/contact";
import Products from "./components/products/products";
import ProductByCa from "./components/products/productByCategory/productByCa";
import Login from "./components/login/login";
import Signup from "./components/login/signup";
import { CartProvider } from "./CartContext";
import Profile from "./components/profile/profile";
import InvoiceSection from "./components/myorder/InvoiceSection";
import LoginAdmin from "./components/admin/login/loginAdmin";
import AdminInterface from "./components/admin/AdminInterface";

function MainApp() {
  const location = useLocation();

  if (location.pathname.startsWith("/admin")) {
    return (
      <Routes>
        <Route path="/admin/home" element={<AdminInterface />} />
        <Route path="/admin" element={<LoginAdmin />} />
        {/* Add more admin routes here */}
      </Routes>
    );
  }

  return (
    <>
      <CartProvider>
        <Header />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/singleProduct/:id" element={<SingleProduct />} />
          <Route path="/about" element={<About />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/products/" element={<Products />} />
          <Route
            path="/products/category/:categoryId"
            element={<ProductByCa />}
          />
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="/profile" element={<Profile />} />
          <Route path="/myorder" element={<InvoiceSection />} />
        </Routes>
        <NewsLetter />
        <Footer />
      </CartProvider>
    </>
  );
}

function App() {
  return (
    <BrowserRouter>
      <MainApp />
    </BrowserRouter>
  );
}

export default App;
