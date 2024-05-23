import "./newsLetter.css";

const NewsLetter = () => {
  return (
    <>
      <div className="newsletter">
        <div className="container gx-0">
          <div className="row gx-0">
            <div className="col-md-6">
              <div className="newsletter-col1">
                <h1>Tham gia và nhận ưu đãi</h1>
                <p>
                  Đăng ký để nhận thông tin về sản phẩm mới và các ưu đãi dành
                  riêng cho bạn
                </p>
              </div>
            </div>
            <div className="col-md-6">
              <div className="newsletter-col2">
                <form action="#">
                  <div className="form-input d-flex">
                    <input
                      type="email"
                      className="form-control mx-3"
                      placeholder="Nhập email của bạn..."
                    />
                    <a
                      href="#"
                      className="email-button-footer btn btn-primary rounded-5"
                    >
                      Tham gia
                    </a>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>{" "}
    </>
  );
};

export default NewsLetter;
