import "./orderMethod.css";
import mt1 from "../../assets/free-shipping.png";
import mt2 from "../../assets/credit-card.png";
import mt3 from "../../assets/customer-service.png";

const OrderMethod = () => {
  return (
    <>
      <div className="order-method py-3">
        <div className="container gx-0">
          <div className="row gx-0">
            <div className="col-md-4">
              <div className="order-col1">
                <img src={mt1} alt="" />
                <h5 className="oder-name-header py-3">Miễn phí giao hàng</h5>
                <p>
                  Lorem ipsum dolor sit, amet consectetur adipisicing elit.
                  Distinctio cumque illum temporibus cupiditate, eius dolore
                  accusamus tempore incidunt enim ipsam.
                </p>
              </div>
            </div>
            <div className="col-md-4">
              <div className="order-col1">
                <img src={mt2} alt="" />
                <h5 className="oder-name-header py-3">ATM, MoMo, mã QR</h5>
                <p>
                  Lorem ipsum dolor sit, amet consectetur adipisicing elit.
                  Distinctio cumque illum temporibus cupiditate, eius dolore
                  accusamus tempore incidunt enim ipsam.
                </p>
              </div>
            </div>
            <div className="col-md-4">
              <div className="order-col1">
                <img src={mt3} alt="" />
                <h5 className="oder-name-header py-3">Hỗ trợ 24/7</h5>
                <p>
                  Lorem ipsum dolor sit, amet consectetur adipisicing elit.
                  Distinctio cumque illum temporibus cupiditate, eius dolore
                  accusamus tempore incidunt enim ipsam.
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default OrderMethod;
