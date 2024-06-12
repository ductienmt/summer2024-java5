import React, { useEffect, useState } from "react";
import "./invoice.css"; // Ensure to create this stylesheet or import relevant styles
import axios from "axios";

const InvoiceSection = () => {
  window.scrollTo(0, 0);
  const [purchase, setPurchase] = useState([]);
  const [cancel, setCancel] = useState("");
  useEffect(() => {
    loadPurchase();
  }, []);

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

  const cancelInvoice = async (id) => {
    try {
      const res = await axios.post(
        `http://localhost:8080/purchase/update/${id}?orderStatus=cancel`
      );
      alert("Hủy đơn hàng thành công!");
      window.location.reload();
    } catch (error) {
      console.error("Error cancelling invoice", error);
    }
  };

  const loadPurchase = async () => {
    try {
      const userId = localStorage.getItem("id");
      const res = await axios.get(
        `http://localhost:8080/purchase/getByUser/${userId}`
      );
      setPurchase(res.data);
    } catch (error) {
      console.error("Error loading purchase", error);
    }
  };
  return (
    <section className="vh-100" style={{ backgroundColor: "#8c9eff" }}>
      <div className="container py-5">
        <h1 className="py-5 text-white custom-text-invoice">
          {purchase.length} đơn hàng
        </h1>
        <div className="row d-flex justify-content-center custom-container-invoice">
          {purchase.map((item) => (
            <div className="col-12 py-3" key={item.id}>
              <div
                className="card card-stepper"
                style={{ borderRadius: "16px" }}
              >
                <div className="card-body p-5">
                  <div className="d-flex justify-content-between align-items-center mb-5">
                    <div>
                      <h5 className="mb-0">
                        ĐƠN HÀNG{" "}
                        <span className="text-primary font-weight-bold">
                          #Y34XDHR{item.id}{" "}
                        </span>
                        {item.orderStatus === "cancel" && (
                          <span className="btn btn-danger text-white text-uppercase">
                            {" "}
                            cancelling
                          </span>
                        )}
                      </h5>
                    </div>
                    <div className="text-end">
                      <p className="mb-0">
                        Ngày đặt hàng <span>{item.purchaseDate}</span>
                      </p>
                      <p className="mb-0">
                        Tổng tiền{" "}
                        <span className="font-weight-bold">
                          {formatPrice(item.totalPrice)} VNĐ
                        </span>
                      </p>
                    </div>
                  </div>

                  <ul
                    id="progressbar-2"
                    className="d-flex justify-content-between mx-0 mt-0 mb-5 px-0 pt-0 pb-2"
                  >
                    <li
                      className={`step0 ${
                        item.orderStatus === "pending" ||
                        item.orderStatus === "delivery" ||
                        item.orderStatus === "progress" ||
                        item.orderStatus === "complete"
                          ? "active"
                          : ""
                      } text-center`}
                      id="step1"
                    ></li>
                    <li
                      className={`step0 ${
                        item.orderStatus === "delivery" ||
                        item.orderStatus === "progress" ||
                        item.orderStatus === "complete"
                          ? "active"
                          : ""
                      } text-center`}
                      id="step2"
                    ></li>
                    <li
                      className={`step0 ${
                        item.orderStatus === "progress" ||
                        item.orderStatus === "complete"
                          ? "active"
                          : ""
                      } text-center`}
                      id="step3"
                    ></li>
                    <li
                      className={`step0 ${
                        item.orderStatus === "complete" ? "active" : ""
                      } text-muted text-end`}
                      id="step4"
                    ></li>
                  </ul>

                  <div className="d-flex justify-content-between">
                    <div className="d-lg-flex align-items-center">
                      <i className="fas fa-clipboard-list fa-3x me-lg-4 mb-3 mb-lg-0"></i>
                      <div>
                        <p className="fw-bold mb-1">Đặt hàng</p>
                        <p className="fw-bold mb-0">thành công</p>
                      </div>
                    </div>
                    <div className="d-lg-flex align-items-center">
                      <i className="fas fa-box-open fa-3x me-lg-4 mb-3 mb-lg-0"></i>
                      <div>
                        <p className="fw-bold mb-1">Chuyển giao</p>
                        <p className="fw-bold mb-0">đơn vị vận chuyển</p>
                      </div>
                    </div>
                    <div className="d-lg-flex align-items-center">
                      <i className="fas fa-shipping-fast fa-3x me-lg-4 mb-3 mb-lg-0"></i>
                      <div>
                        <p className="fw-bold mb-1">Đang</p>
                        <p className="fw-bold mb-0">vận chuyển</p>
                      </div>
                    </div>
                    <div className="d-lg-flex align-items-center">
                      <i className="fas fa-home fa-3x me-lg-4 mb-3 mb-lg-0"></i>
                      <div>
                        <p className="fw-bold mb-1">Thành công</p>
                        <p className="fw-bold mb-0">đơn hàng</p>
                      </div>
                    </div>
                  </div>
                </div>
                <div className="py-3 px-3 d-flex justify-content-end">
                  {item.orderStatus != "cancel" &&
                    item.orderStatus == "pending" && (
                      <button
                        className="btn btn-warning text-white"
                        onClick={() => cancelInvoice(item.id)}
                      >
                        Cancel
                      </button>
                    )}
                </div>
              </div>
              54
            </div>
          ))}
        </div>
      </div>
    </section>
  );
};

export default InvoiceSection;
