import "./discount.css";
import img from "../../assets/discount1.png";

const Discount = () => {
  return (
    <>
      <div className="container full-main-discount">
        <h2 className="discount-header">Voucher cho bạn</h2>
        <div className="row align-items-center discount-main">
          <div className="col-md-7">
            <h5 className="pb-3 main-text1">
              <i className="fa-solid fa-percent"></i> Deal hời dành cho bạn mới
            </h5>
            <h1>Bộ dụng cụ lắp ráp Gunpla cơ bản</h1>
            <p>
              Bạn sẽ nhận được bộ dụng cụ gần như là đầy đủ cho các bạn mới tập
              chơi. Gồm: kềm cắt part, dũa kim loại, dũa xốp có độ nhám nhỏ,
              nhíp gắp sticker hoặc part nhỏ, kẻ line, dao cắt chi tiết thừa,
              thước kẻ, dụng cụ dỡ part,... khi mua hàng có hóa đơn 1tr000
            </p>
          </div>

          <div className="col-md-5 align-items-center">
            <img src={img} alt="" className="img-fluid" />
          </div>
        </div>
      </div>
    </>
  );
};

export default Discount;
