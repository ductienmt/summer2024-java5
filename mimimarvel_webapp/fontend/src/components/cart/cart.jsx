import "./cart.css";
import { useContext, useState, useEffect } from "react";
import { CartContext } from "../../CartContext";
import PropTypes from "prop-types";
import axios from "axios";

const Cart = () => {
  const [phone, setPhone] = useState("");
  const { cartItems, removeItem, incrementQuantity, decrementQuantity } =
    useContext(CartContext);
  // Add a new state variable for the shipping address
  const [shippingAddress, setShippingAddress] = useState("");

  // Add a handler for the input field
  const handleShippingAddressChange = (event) => {
    setShippingAddress(event.target.value);
  };

  // Add the onChange event to the input field
  <input
    type="text"
    className="your-input-class"
    value={shippingAddress}
    onChange={handleShippingAddressChange}
  />;

  useEffect(() => {
    const phoneLo = localStorage.getItem("phone");
    if (phoneLo != null) {
      setPhone(phoneLo);
    }
    getTotalPrice();
  }, [cartItems]);

  const userId = localStorage.getItem("id");

  const getTotalPrice = () => {
    return cartItems.reduce(
      (total, item) => total + item.price * item.quantity,
      0
    );
  };

  const getTotalItems = () => {
    return cartItems.reduce((total, item) => total + item.quantity, 0);
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

  const getDate = () => {
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, "0");
    var mm = String(today.getMonth() + 1).padStart(2, "0"); //January is 0!
    var yyyy = today.getFullYear();
    return yyyy + "-" + mm + "-" + dd;
  };

  // Lặp qua từng item trong cartItems và gửi yêu cầu POST cho từng item
  const sendPurchaseDetails = async (cartItems) => {
    for (const item of cartItems) {
      const purchaseDetail = {
        id: null, // Assuming the server will generate this
        purchaseId: null, // This will be filled in by the server
        productId: item.id,
        quantity: item.quantity,
        unitPrice: item.price,
        totalPrice: item.price * item.quantity,
      };

      try {
        const responseD = await axios.post(
          "http://localhost:8080/purchase/createDetail",
          purchaseDetail
        );

        if (responseD.status === 200) {
          // Handle successful order for this item
          console.log(`Đặt hàng thành công cho sản phẩm ${item.id}!`);
        } else {
          // Handle unsuccessful order for this item
          console.log(`Đặt hàng thất bại cho sản phẩm ${item.id}!`);
        }
      } catch (error) {
        // Handle error for this item
        console.error(
          `An error occurred while placing the order for product ${item.id}:`,
          error
        );
      }
    }
  };

  const handleOrder = async () => {
    // Create the purchase object
    const purchase = {
      id: null, // Assuming the server will generate this
      userId: Number(userId),
      totalPrice: getTotalPrice(),
      payment: "tienmat", // Assuming this is the default payment method
      notes: "", // Assuming no notes for now
      purchaseDate: getDate(),
      shippingAddress: shippingAddress, // Assuming no shipping address for now
      orderStatus: "pending", // Assuming the order status is pending initially
      servicesId: "null", // Assuming no servicesId for now
      voucherId: "null", // Assuming no voucherId for now
    };

    // Send the POST request
    try {
      const response = await axios.post(
        "http://localhost:8080/purchase/create",
        purchase
      );

      if (response.status === 200) {
        // Handle successful order
        alert("Đặt hàng thành công !");
      } else {
        // Handle unsuccessful order
        alert("Đặt hàng thất bại !");
      }
    } catch (error) {
      // Handle error
      console.error("An error occurred while placing the order:", error);
    }

    sendPurchaseDetails(cartItems);
  };

  return (
    <>
      <div className="card card-registration card-registration-2">
        <div className="card-body p-0">
          <div className="row g-0">
            <div className="col-lg-8">
              <div className="p-5">
                <div className="d-flex justify-content-between align-items-center mb-5">
                  <h1 className="fw-bold mb-0">Giỏ hàng</h1>
                  <h6 className="mb-0 text-muted">
                    {getTotalItems()} sản phẩm
                  </h6>
                </div>
                <hr className="my-4" />

                <div className="cart-items">
                  {cartItems.map((item, index) => (
                    <div
                      className="row mb-4 d-flex justify-content-between align-items-center"
                      key={index}
                    >
                      <div className="col-md-2 col-lg-2 col-xl-2">
                        <img
                          // src={item.image}
                          src={`../../../public/product/${item.image}`}
                          className="img-fluid rounded-3"
                          alt={item.name}
                        />
                      </div>
                      <div className="col-md-3 col-lg-3 col-xl-3">
                        <h6 className="text-muted">{item.category}</h6>
                        <h6 className="text-black mb-0">{item.name}</h6>
                      </div>
                      <div className="col-md-3 col-lg-3 col-xl-2 d-flex">
                        <a
                          className="btn btn-link px-2"
                          onClick={() => decrementQuantity(index)}
                        >
                          <i className="fas fa-minus"></i>
                        </a>

                        <input
                          min="1"
                          name="quantity"
                          type="number"
                          value={item.quantity}
                          className="form-control-custom"
                          readOnly
                        />

                        <a
                          className="btn btn-link btn-white px-2"
                          onClick={() => incrementQuantity(index)}
                        >
                          <i className="fas fa-plus"></i>
                        </a>
                      </div>
                      <div className="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                        <h6 className="mb-0" readOnly>
                          {formatPrice(item.price * item.quantity)}
                        </h6>
                      </div>
                      <div className="col-md-1 col-lg-1 col-xl-1 text-end">
                        <a
                          href="#!"
                          className="text-muted"
                          onClick={() => removeItem(index)}
                        >
                          <i className="fas fa-times"></i>
                        </a>
                      </div>
                      <hr className="my-4" />
                    </div>
                  ))}
                </div>

                <div className="pt-5">
                  <h6 className="mb-0">
                    <a href="#!" className="text-body" data-bs-dismiss="modal">
                      <i className="fas fa-long-arrow-alt-left me-2"></i>
                      Quay lại shop
                    </a>
                  </h6>
                </div>
              </div>
            </div>
            <div className="col-lg-4">
              <div className="p-5">
                <h3 className="fw-bold mb-5 mt-2 pt-1">Thanh toán</h3>
                <hr className="my-4" />

                <div className="d-flex justify-content-between mb-4">
                  <h5 className="text-uppercase">{getTotalItems()} sản phẩm</h5>
                  <h5>{formatPrice(getTotalPrice())} VNĐ</h5>
                </div>

                <h5 className="text-uppercase mb-3">Thanh toán bằng</h5>

                <div className="mb-4 pb-2">
                  <select
                    data-mdb-select-init
                    className="form-control form-control-lg"
                    name="payment"
                  >
                    <option value="tienmat">Thanh toán tiền mặt</option>
                    {/* <option value="vnpay">Thanh toán VNPAY</option> */}
                  </select>
                </div>

                <h5 className="text-uppercase mb-3">Địa chỉ giao hàng</h5>

                <div className="mb-2">
                  <div data-mdb-input-init className="form-outline">
                    <input
                      type="text"
                      name="phone"
                      className="form-control form-control-lg"
                      placeholder="Nhập số điện thoại"
                      value={phone}
                      onChange={(e) => setPhone(e.target.value)}
                      required
                    />
                  </div>
                </div>
                <div className="mb-5">
                  <div data-mdb-input-init className="form-outline">
                    <input
                      type="text"
                      name="shippingAddress"
                      className="form-control form-control-lg"
                      placeholder="Nhập địa chỉ giao hàng"
                      value={shippingAddress}
                      onChange={handleShippingAddressChange}
                      required
                    />
                  </div>
                </div>

                <hr className="my-4" />

                <div className="d-flex justify-content-between mb-5">
                  <h5 className="text-uppercase">Tổng tiền</h5>
                  <h5>{formatPrice(getTotalPrice())} VNĐ</h5>
                </div>

                <button
                  type="button"
                  data-mdb-button-init
                  data-mdb-ripple-init
                  className="btn btn-dark btn-block btn-lg col-12"
                  data-mdb-ripple-color="dark"
                  disabled={!cartItems || cartItems.length === 0}
                  onClick={handleOrder}
                >
                  Đặt hàng
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

Cart.propTypes = {
  cart: PropTypes.arrayOf(
    PropTypes.shape({
      name: PropTypes.string.isRequired,
      category: PropTypes.string.isRequired,
      image: PropTypes.string.isRequired,
      price: PropTypes.number.isRequired,
      quantity: PropTypes.number.isRequired,
    })
  ),
  incrementQuantity: PropTypes.func.isRequired,
  decrementQuantity: PropTypes.func.isRequired,
};

export default Cart;
