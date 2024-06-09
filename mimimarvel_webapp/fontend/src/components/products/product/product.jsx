// import img from "../../../assets/gundam1.png";
import "./product.css";
import PropTypes from "prop-types";
import { Link } from "react-router-dom";

const Product = ({ name, image, price, id }) => {
  const formatPrice = (price) => {
    // Chuyển đổi giá thành chuỗi và đảm bảo nó là số
    const formattedPrice = Number(price).toString();

    // Tách phần nguyên và phần thập phân
    const parts = formattedPrice.split(".");
    const integerPart = parts[0];
    const decimalPart = parts.length > 1 ? "." + parts[1] : "";

    // Thêm dấu chấm sau mỗi 3 số trong phần nguyên
    const regex = /\B(?=(\d{3})+(?!\d))/g;
    const formattedIntegerPart = integerPart.replace(regex, ".");

    // Thêm số 0 vào phần thập phân nếu cần
    let formattedDecimalPart = "";
    if (decimalPart) {
      formattedDecimalPart = decimalPart.padEnd(3, "0");
    } else {
      formattedDecimalPart = ".000";
    }

    // Kết hợp phần nguyên và phần thập phân để tạo giá trị hoàn chỉnh
    const formattedPriceWithDecimal =
      formattedIntegerPart + formattedDecimalPart;

    return formattedPriceWithDecimal;
  };
  return (
    <div className="product-main">
      <Link to={`/singleProduct/${id}`} className="product-link">
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
            <div className="product-price">{formatPrice(price)} VNĐ</div>
          </div>
        </div>
      </Link>
    </div>
  );
};

Product.propTypes = {
  name: PropTypes.string.isRequired,
  image: PropTypes.string.isRequired,
  price: PropTypes.number.isRequired,
  id: PropTypes.number.isRequired,
};

export default Product;
