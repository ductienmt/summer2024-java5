import Category from "../../category/category";
import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import axios from "axios";
import Product from "../product/product";
import NewArrival from "../newArrival";
import Discount from "../../discount/discount";
import OrderMethod from "../../orderMethod/orderMethod";

function ProductByCa() {
  window.scrollTo(0, 0);
  const { categoryId } = useParams();
  const [products, setProducts] = useState([]);
  const [category, setCategory] = useState([]);

  useEffect(() => {
    loadProductsByCategory();
  }, [categoryId]);

  const loadProductsByCategory = async () => {
    try {
      const res = await axios.get(
        `http://localhost:8080/product/getByCategory/${categoryId}`
      );
      const categoryRes = await axios.get(
        `http://localhost:8080/categories/get/${categoryId}`
      );
      setProducts(res.data);
      setCategory(categoryRes.data);
    } catch (error) {
      console.error("Error loading categories", error);
    }
  };

  return (
    <>
      <div className="container gx-0 py-3">
        <Category />
        <h2 className="py-3 name-header">
          Tất cả sản phẩm của {category.name}
        </h2>
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
}

export default ProductByCa;
