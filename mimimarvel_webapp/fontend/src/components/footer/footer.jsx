import "./footer.css";

function Footer() {
  return (
    <>
      <footer className="text-center text-lg-start text-muted">
        <div className="container">
          <hr />
          <div className="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
            <div className="me-5 d-none d-lg-block custom-footer-head">
              <span>Kết nối với tôi qua các mạng xã hội:</span>
            </div>
            <div>
              <a href="#" className="me-4 text-reset">
                <i className="fa-brands fa-facebook"></i>
              </a>
              <a href="#" className="me-4 text-reset">
                <i className="fa-brands fa-twitter"></i>
              </a>
              <a href="#" className="me-4 text-reset">
                <i className="fa-solid fa-envelope"></i>
              </a>
              <a href="#" className="me-4 text-reset">
                <i className="fa-brands fa-instagram"></i>
              </a>
            </div>
          </div>
        </div>
        <div className="container text-center text-md-start mt-5">
          <div className="row mt-3">
            <div className="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
              <h6 className="text-uppercase fw-bold mb-4">
                <i className="fas fa-gem me-3"></i>{" "}
                <span className="nameCompany">MINI MARVEL</span>
              </h6>
              <img
                src="../../../public/favicon.png"
                alt=""
                className="logoCompany"
              />
            </div>

            <div className="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
              <h6 className="text-uppercase fw-bold mb-4">Sản phẩm này</h6>
              <p>
                <a href="#!" className="text-reset">
                  React JS (Font-end)
                </a>
              </p>
              <p>
                <a href="#!" className="text-reset">
                  Spring Boot (Back-end)
                </a>
              </p>
              <p>
                <a href="#!" className="text-reset">
                  Bootstrap
                </a>
              </p>
              <p>
                <a href="#!" className="text-reset">
                  SQL Server
                </a>
              </p>
            </div>

            <div className="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
              <h6 className="text-uppercase fw-bold mb-4">Có thể bạn cần</h6>
              <p>
                <a href="#!" className="text-reset">
                  Giá sản phẩm
                </a>
              </p>
              <p>
                <a href="#!" className="text-reset">
                  Cài đặt
                </a>
              </p>
              <p>
                <a href="#!" className="text-reset">
                  Đặt hàng
                </a>
              </p>
              <p>
                <a href="#!" className="text-reset">
                  Hỗ trợ
                </a>
              </p>
            </div>

            <div className="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
              <h6 className="text-uppercase fw-bold mb-4">Liên Hệ</h6>
              <p>
                <i className="fas fa-home me-3"></i>FPT Polytechnic
              </p>
              <p>
                <i className="fas fa-envelope me-3"></i>
                tiendtdps32039@fpt.edu.vn
              </p>
              <p>
                <i className="fas fa-phone me-3"></i> + 84 123 456 789
              </p>
              <p>
                <i className="fas fa-print me-3"></i> + 84 123 456 789
              </p>
            </div>
          </div>
        </div>
        <div className="text-center p-4 custom-copyright">
          © 2024 Copyright:
          <a className="text-reset fw-bold" href="#">
            Duc Tien
          </a>
        </div>
      </footer>
    </>
  );
}

export default Footer;
