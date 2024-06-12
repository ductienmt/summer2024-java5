import "./singleProduct.css";
import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import axios from "axios";
import NewArrival from "../products/newArrival";
import OrderMethod from "../orderMethod/orderMethod";
import Discount from "../discount/discount";
import { useContext } from "react";
import PropTypes from "prop-types";
import { CartContext } from "../../CartContext";

const SingleProduct = () => {
  window.scrollTo(0, 0);
  const { addToCart } = useContext(CartContext);

  const { id } = useParams();
  const productId = parseInt(id, 10);

  const [singleProduct, setSingleProduct] = useState({});
  const [category, setCategory] = useState({});
  const [brand, setBrand] = useState({});
  const [quantity, setQuantity] = useState(1);

  useEffect(() => {
    loadSingleProduct();
    handleIncrease();
    handleDecrease();
  }, [productId]);

  const handleAddToCart = () => {
    const username = localStorage.getItem("username");
    if (username == null) {
      alert("Vui lòng đăng nhập để mua hàng");
      return;
    } else {
      addToCart({ ...singleProduct, quantity: quantity });
      alert("Đã thêm vào giỏ hàng");
    }
  };

  const handleIncrease = () => {
    setQuantity((prevQuantity) => prevQuantity + 1);
  };

  const handleDecrease = () => {
    setQuantity((prevQuantity) => (prevQuantity > 1 ? prevQuantity - 1 : 1));
  };

  const loadSingleProduct = async () => {
    try {
      const productRes = await axios.get(
        `http://localhost:8080/product/get/${productId}`
      );

      // console.log(productRes.data.categoryId);
      try {
        const categoryRes = await axios.get(
          `http://localhost:8080/categories/get/${productRes.data.categoryId}`
        );
        setCategory(categoryRes.data);
        const brandRes = await axios.get(
          `http://localhost:8080/brand/get/${productRes.data.brandId}`
        );
        setBrand(brandRes.data);
      } catch (error) {
        console.error("Error loading category", error);
      }
      // console.log(productRes.data.brandId);
      setSingleProduct(productRes.data);
      setQuantity(1);
    } catch (error) {
      console.error("Error loading product", error);
    }
  };

  const formatPrice = (price) => {
    // Chuyển đổi giá thành chuỗi và đảm bảo nó là số
    const formattedPrice = Number(price).toString();

    // Thêm dấu chấm sau mỗi 3 số
    const regex = /\B(?=(\d{3})+(?!\d))/g;
    const priceWithComma = formattedPrice.replace(regex, ".");

    // Thêm 3 số 0 đằng sau
    const priceWithCommaAndZeros = priceWithComma.split(".")[1]
      ? priceWithComma + ".000"
      : priceWithComma + ".000";

    return priceWithCommaAndZeros;
  };

  return (
    <>
      <div className="container gx-0 py-4">
        <div className="category-title"></div>
        <div className="row gx-0 py-2 align-items-center">
          <div className="col-md-6">
            <div className="single-product1">
              <img
                src={`../../../public/product/${singleProduct.image}`}
                className="img-fluid"
                alt=""
              />
            </div>
          </div>
          <div className="col-md-6">
            <div className="single-product2">
              <h1 className="single-product-title">{singleProduct.name}</h1>
              <h3 className="single-product-price mt-3">
                {formatPrice(singleProduct.price)} VNĐ
              </h3>

              <p className="single-product-description mt-3">
                {singleProduct.description}
              </p>
              {/* <div></div> Thêm size */}

              <div className="carts-button-quantity">
                <div className="quantity-buttons my-4 py-3 d-flex align-items-center">
                  <button
                    className="btn btn-outline-secondary me-2"
                    onClick={handleDecrease}
                  >
                    -
                  </button>
                  <span className="mx-2">{quantity}</span>
                  <button
                    className="btn btn-outline-secondary ms-2"
                    onClick={handleIncrease}
                  >
                    +
                  </button>
                </div>
                <h6 className="mb-4">
                  Kích thước:{" "}
                  <button className="btn btn-outline-secondary">
                    {singleProduct.size}
                  </button>
                </h6>
                <div className="d-flex">
                  <button
                    className="btn btn-primary me-3 custom-text-singleProduct"
                    onClick={handleAddToCart}
                  >
                    Thêm vào giỏ hàng
                  </button>
                  <button className="btn btn-warning custom-text-singleProduct">
                    Mua ngay
                  </button>
                </div>
              </div>
              <hr />
              <h5>Nhãn hàng: {brand.name}</h5>
              <h5>Danh mục: {category.name}</h5>
              <div className="share-single-product mt-3">
                <span className="me-2 custom-text-singleProduct">Chia sẻ:</span>
                <i className="fa-brands fa-facebook text-primary me-2"></i>
                <i className="fa-brands fa-twitter text-primary me-2"></i>
                <i className="fa-brands fa-instagram text-primary me-2"></i>
                <i className="fa-brands fa-facebook-messenger text-primary"></i>
              </div>
            </div>
          </div>
        </div>
        <NewArrival></NewArrival>
        <Discount />
      </div>
      <OrderMethod></OrderMethod>
    </>
  );
};

SingleProduct.propTypes = {
  product: PropTypes.shape({
    name: PropTypes.string.isRequired,
    category: PropTypes.string.isRequired,
    image: PropTypes.string.isRequired,
    price: PropTypes.number.isRequired,
  }).isRequired,
};

export default SingleProduct;
