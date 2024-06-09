import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import "./newArrival.css";

const NewArrival = () => {
  const [newProduct, setNewProduct] = useState([]);
  const [firstProduct, setFirstProduct] = useState(null);

  useEffect(() => {
    loadNewProducts();
  }, []);

  const loadNewProducts = async () => {
    try {
      const res = await axios.get(
        "http://localhost:8080/product/getNewProduct"
      );
      setNewProduct(res.data);
      if (res.data && res.data.length > 0) {
        setFirstProduct(res.data[0]);
      }
      console.log(res.data);
    } catch (error) {
      console.error("Error loading categories", error);
    }
  };

  const formatPrice = (price) => {
    const formattedPrice = Number(price).toString();
    const parts = formattedPrice.split(".");
    const integerPart = parts[0];
    const decimalPart = parts.length > 1 ? "." + parts[1] : "";

    const regex = /\B(?=(\d{3})+(?!\d))/g;
    const formattedIntegerPart = integerPart.replace(regex, ".");

    let formattedDecimalPart = "";
    if (decimalPart) {
      formattedDecimalPart = decimalPart.padEnd(3, "0");
    } else {
      formattedDecimalPart = ".000";
    }

    const formattedPriceWithDecimal =
      formattedIntegerPart + formattedDecimalPart;

    return formattedPriceWithDecimal;
  };

  return (
    <div className="container gx-0">
      <div className="d-flex justify-content-between py-3 mt-4">
        <div className="col-header">
          <h2 className="name-header py-3">Sản phẩm mới</h2>
        </div>
        <div className="header-btn">
          <Link to="/products" className="btn btn-primary">
            <span>Tất cả sản phẩm</span>{" "}
            <i className="fa-solid fa-arrow-right"></i>
          </Link>
        </div>
      </div>
      <div className="row gx-0">
        <div className="col-md-6">
          <div className="newArrival-col1">
            {firstProduct && (
              <>
                <h3 className="product-name-new">{firstProduct.name}</h3>
                <div className="banner-btns py-3 ">
                  <Link
                    to={`/singleProduct/${firstProduct.id}`}
                    className="product-link"
                  >
                    <button className="main-btn">Mua ngay !</button>
                  </Link>
                </div>
                <img
                  src={`../../../public/product/${firstProduct.image}`}
                  alt={firstProduct.name}
                />
              </>
            )}
          </div>
        </div>
        <div className="col-md-6 d-flex flex-column justify-content-between">
          {newProduct.map((product, index) => (
            <div className="newArrival-col2" key={index}>
              <Link
                to={`/singleProduct/${product.id}`}
                className="product-link"
              >
                <div className="row h-100">
                  <div className="col-4 py-3">
                    <img
                      src={`../../../public/product/${product.image}`}
                      alt={product.name}
                    />
                  </div>
                  <div className="col-8 py-3">
                    <h5 className="product-name text-dark">{product.name}</h5>
                    <div className="icons-star pb-2">
                      <i className="fa-solid fa-star"></i>
                      <i className="fa-solid fa-star"></i>
                      <i className="fa-solid fa-star"></i>
                      <i className="fa-solid fa-star"></i>
                      <i className="fa-solid fa-star"></i>
                    </div>
                    <div className="product-price text-dark">
                      {formatPrice(product.price)} VNĐ
                    </div>
                  </div>
                </div>
              </Link>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default NewArrival;
