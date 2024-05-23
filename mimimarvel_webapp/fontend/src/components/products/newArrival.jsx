import ct2 from "../../assets/category2.png";
import "./newArrival.css";

const NewArrival = () => {
  return (
    <>
      <div className="container gx-0">
        <div className="d-flex justify-content-between py-3 mt-4">
          <div className="col-header">
            <h2 className="name-header py-3">Sản phẩm mới</h2>
          </div>
          <div className="header-btn">
            <a className="btn btn-primary">
              <span>Tất cả sản phẩm</span>{" "}
              <i className="fa-solid fa-arrow-right"></i>
            </a>
          </div>
        </div>
        <div className="row gx-0">
          <div className="col-md-6">
            <div className="newArrival-col1">
              <h3 className="product-name-new">Tanjiro Figure 1/50</h3>
              <div className="banner-btns py-3 ">
                <a href="/singleProduct">
                  <button className="main-btn">Mua ngay !</button>
                </a>
              </div>
              <img src={ct2} alt="" />
            </div>
          </div>
          <div className="col-md-6 d-flex flex-column justify-content-between">
            <div className="newArrival-col2">
              <a href="/singleProduct">
                <div className="row h-100 ">
                  <div className="col-4 py-3">
                    <img src={ct2} alt="" />
                  </div>
                  <div className="col-8 py-3">
                    <h5 className="product-name">Star Build Strike</h5>
                    <div className="icons-star pb-2">
                      <i className="fa-solid fa-star"></i>
                      <i className="fa-solid fa-star"></i>
                      <i className="fa-solid fa-star"></i>
                      <i className="fa-solid fa-star"></i>
                      <i className="fa-solid fa-star"></i>
                    </div>
                    <div className="product-price">400.000 VNĐ</div>
                  </div>
                </div>
              </a>
            </div>
            <div className="newArrival-col2">
              <div className="row h-100 ">
                <div className="col-4 py-3">
                  <img src={ct2} alt="" />
                </div>
                <div className="col-8 py-3">
                  <h5 className="product-name">Star Build Strike</h5>
                  <div className="icons-star pb-2">
                    <i className="fa-solid fa-star"></i>
                    <i className="fa-solid fa-star"></i>
                    <i className="fa-solid fa-star"></i>
                    <i className="fa-solid fa-star"></i>
                    <i className="fa-solid fa-star"></i>
                  </div>
                  <div className="product-price">400.000 VNĐ</div>
                </div>
              </div>
            </div>
            <div className="newArrival-col2">
              <div className="row h-100 ">
                <div className="col-4 py-3">
                  <img src={ct2} alt="" />
                </div>
                <div className="col-8 py-3">
                  <h5 className="product-name">Star Build Strike</h5>
                  <div className="icons-star pb-2">
                    <i className="fa-solid fa-star"></i>
                    <i className="fa-solid fa-star"></i>
                    <i className="fa-solid fa-star"></i>
                    <i className="fa-solid fa-star"></i>
                    <i className="fa-solid fa-star"></i>
                  </div>
                  <div className="product-price">400.000 VNĐ</div>
                </div>
              </div>
            </div>
            <div className="newArrival-col2">
              <div className="row h-100 ">
                <div className="col-4 py-3">
                  <img src={ct2} alt="" />
                </div>
                <div className="col-8 py-3">
                  <h5 className="product-name">Star Build Strike</h5>
                  <div className="icons-star pb-2">
                    <i className="fa-solid fa-star"></i>
                    <i className="fa-solid fa-star"></i>
                    <i className="fa-solid fa-star"></i>
                    <i className="fa-solid fa-star"></i>
                    <i className="fa-solid fa-star"></i>
                  </div>
                  <div className="product-price">400.000 VNĐ</div>
                </div>
              </div>
            </div>

            <div className="newArrival-col2">
              <div className="row h-100 ">
                <div className="col-4 py-3">
                  <img src={ct2} alt="" />
                </div>
                <div className="col-8 py-3">
                  <h5 className="product-name">Star Build Strike</h5>
                  <div className="icons-star pb-2">
                    <i className="fa-solid fa-star"></i>
                    <i className="fa-solid fa-star"></i>
                    <i className="fa-solid fa-star"></i>
                    <i className="fa-solid fa-star"></i>
                    <i className="fa-solid fa-star"></i>
                  </div>
                  <div className="product-price">400.000 VNĐ</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default NewArrival;
