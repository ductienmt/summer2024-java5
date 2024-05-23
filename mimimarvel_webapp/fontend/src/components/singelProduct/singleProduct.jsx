import "./singleProduct.css";

const SingleProduct = () => {
  return (
    <>
      <div className="container gx-0 py-4">
        <div className="category-title"></div>
        <div className="row gx-0 py-2 align-items-center">
          <div className="col-md-6">
            <div className="single-product1">
              <img
                src="../../../public/category/category2.png"
                className="img-fluid"
                alt=""
              />
            </div>
          </div>
          <div className="col-md-6">
            <div className="single-product2">
              <h2 className="single-product-title">Star Build Strike</h2>
              <h3 className="single-product-price mt-3">400.000 VNĐ</h3>
              <p className="single-product-description mt-3">
                Lorem ipsum dolor sit amet consectetur, adipisicing elit.
                Laborum, explicabo?
              </p>
              {/* <div></div> Thêm size */}
              <div className="carts-button-quantity">
                <div className="quantity-buttons my-4 py-3">
                  <span className="single-product-span">-</span>
                  <span>1</span>
                  <span className="single-product-span">+</span>
                </div>
                <div>
                  <button className="single-product-cart-button1 py-3">
                    Thêm vào giỏ hàng
                  </button>
                  <button className="single-product-cart-button2 py-3 mx-3">
                    Mua ngay
                  </button>
                </div>
              </div>
              <hr />
              <h6>Nhãn hàng:</h6>
              <h6>Danh mục:</h6>
              <h6 className="share-single-product">
                Chia sẻ: <i className="fa-brands fa-facebook"></i>
                <i className="fa-brands fa-twitter"></i>
                <i className="fa-brands fa-instagram"></i>
                <i className="fa-brands fa-facebook-messenger"></i>
              </h6>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default SingleProduct;
