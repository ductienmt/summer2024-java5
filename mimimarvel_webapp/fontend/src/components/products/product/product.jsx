// import img from "../../../assets/gundam1.png";
import "./product.css";
import PropTypes from "prop-types";

const Product = ({ name, image, price }) => {
  return (
    <div className="product-main">
      <a href="/singleProduct">
        <div className="card card-1 h-100">
          <div className="card-head">
            <img src={`../../../public/product/${image}`} alt="" />
          </div>
          <div className="card-body">
            <h5 className="product-name">{name} </h5>
            <div className="icons-star pb-2">
              <i className="fa-solid fa-star"></i>
              <i className="fa-solid fa-star"></i>
              <i className="fa-solid fa-star"></i>
              <i className="fa-solid fa-star"></i>
              <i className="fa-solid fa-star"></i>
            </div>
            <div className="product-price">{price} VNĐ</div>
          </div>
        </div>
      </a>
    </div>
  );
};

Product.propTypes = {
  name: PropTypes.string.isRequired,
  image: PropTypes.string.isRequired,
  price: PropTypes.number.isRequired,
};

export default Product;
