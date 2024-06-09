import Product from "./product/product";
import "./products.css";
import { useEffect, useState } from "react";
import axios from "axios";
import Category from "../category/category";
import NewArrival from "./newArrival";
import Discount from "../discount/discount";
import OrderMethod from "../orderMethod/orderMethod";

const Products = () => {
  window.scrollTo(0, 0);
  const [products, setProducts] = useState([]);

  useEffect(() => {
    loadProducts();
  }, []);

  const loadProducts = async () => {
    try {
      const res = await axios.get("http://localhost:8080/product/list");
      setProducts(res.data);
    } catch (error) {
      console.error("Error loading categories", error);
    }
  };

  // const loadProductsByCategory = async () => {
  //   try {
  //     const res = await axios.get(
  //       `http://localhost:8080/product/getByCategory/${categoryId}`
  //     );
  //     setProducts(res.data);
  //   } catch (error) {
  //     console.error("Error loading categories", error);
  //   }
  // };

  return (
    <>
      <div className="container gx-0 py-3">
        <Category />
        <h2 className="py-3 name-header">Tất cả sản phẩm</h2>
        <div className="row gx-0">
          <div className="col-md-12">
            <div className="products-main">
              {products.map((product, index) => (
                <Product
                  name={product.name}
                  image={product.image}
                  price={product.price}
                  id={product.id}
                  key={index}
                />
              ))}
            </div>
          </div>
        </div>
        <NewArrival />
        <Discount />
      </div>
      <OrderMethod />
    </>
  );
};

export default Products;
