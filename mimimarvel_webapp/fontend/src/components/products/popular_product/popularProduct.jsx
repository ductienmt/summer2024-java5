import "./popularProduct.css";

const PopularProduct = () => {
  return (
    <>
      <div className="container gx-0 py-3">
        <h2 className="py-3 name-header">Sản phẩm phổ biến</h2>
        <div className="row gx-0">
          <div className="col-md-12">
            <div className="products-main">
              <div className="product">
                <div className="product-image">
                  <img
                    src="https://via.placeholder.com/150"
                    alt="product"
                    className="img-fluid"
                  />
                </div>
                <div className="product-details">
                  <h6 className="product-name">Product Name</h6>
                  <p className="product-price">Price</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default PopularProduct;
