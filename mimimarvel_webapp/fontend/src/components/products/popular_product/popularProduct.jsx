import { useEffect, useState } from "react";
import "./popularProduct.css";
import axios from "axios";
import Product from "../product/product";

const PopularProduct = () => {
  window.scrollTo(0, 0);
  const [products, setProducts] = useState([]);

  useEffect(() => {
    loadProducts();
  }, []);

  const loadProducts = async () => {
    try {
      const res = await axios.get(
        "http://localhost:8080/product/getPopularProduct"
      );
      setProducts(res.data);
    } catch (error) {
      console.error("Error loading categories", error);
    }
  };
  return (
    <>
      <div className="container gx-0 py-3">
        <h2 className="py-3 name-header">Sản phẩm phổ biến</h2>
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
      </div>
    </>
  );
};

export default PopularProduct;
