import "./about.css";

const About = () => {
  return (
    <div className="container mt-5">
      <div className="row p-5 about-us">
        <div className="col-md-12">
          <h1 className="text-center text-white text-about-us py-5">
            Về chúng tôi
          </h1>
        </div>
      </div>
      <div className="custom-about text-center">
        <div className="column align-items-center">
          <p>
            Chúng tôi tự tin là đơn vị chuyên cung cấp sỉ lẻ mô hình hàng đầu
            Việt Nam
          </p>
        </div>
        <div className="column align-items-center">
          <p>
            Bạn có thể tin tưởng mua sắm kể cả online và offline, đều có
            freeship và đảm bảo chất lượng sản phẩm
          </p>
        </div>
        <div className="column align-items-center">
          <p>Uy tín và trách nhiệm tạo nên sự khác biệt</p>
        </div>
      </div>
    </div>
  );
};

export default About;
