import "./Banner.css";
// Import Swiper React components
import { Swiper, SwiperSlide } from "swiper/react";
import ningguang from "../../../assets/ningguang.png";
import gundam from "../../../assets/gundam.png";
// Import Swiper styles
import "swiper/css";
import "swiper/css/pagination";
import "swiper/css/navigation";

// import required modules
import { Autoplay, Pagination, Navigation } from "swiper/modules";
const Banner = () => {
  return (
    <>
      <Swiper
        spaceBetween={30}
        centeredSlides={false}
        autoplay={{
          delay: 2500,
          disableOnInteraction: false,
        }}
        pagination={{
          clickable: true,
        }}
        navigation={true}
        modules={[Autoplay, Pagination, Navigation]}
        className="mySwiper"
      >
        <SwiperSlide>
          <div className="container-fluid p-0">
            <div className="m-0 gx-0 position-relative">
              <img src={ningguang} alt="" className="w-100 custom-background" />
              <div className="text-overlay-left">
                <div className="col-md-12 col-lg-8">
                  <div className="pt-md-4">
                    <h4 className="mb-4 custom-bestseller d-flex">
                      {/* <span>
                        <img src={star} style={styles.customImg} alt="" />
                      </span> */}
                      {/* <i className="fa-solid fa-circle-star"></i> */}
                      <i className="fa-solid fa-star"></i>
                      Sản phẩm bán chạy nhất của tháng
                    </h4>
                    <h1>
                      Genshin Impact{" "}
                      <span className="custom-text">Ningguang</span>
                    </h1>
                    <p className="custom-bestseller-text">
                      Lorem ipsum dolor sit amet consectetur adipisicing elit.
                      Sapiente harum in illum aspernatur sequi maxime et,
                      quisquam laborum deserunt consequatur!
                    </p>
                  </div>
                  <div className="banner-btns">
                    <button className="btn btn-custom-ban">Mua ngay !</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </SwiperSlide>

        <SwiperSlide>
          <div className="container-fluid p-0">
            <div className="m-0 gx-0">
              <img src={gundam} alt="" className="w-100 custom-background" />
              <div className="text-overlay-right">
                <div className="col-md-12 col-lg-8">
                  <div className="pt-md-4">
                    <h4 className="mb-4 custom-bestseller d-flex">
                      <span>
                        {/* <img src={star} style={styles.customImg} alt="" /> */}
                      </span>
                      <i className="fa-solid fa-star"></i>
                      Sản phẩm bán chạy nhất của tháng
                    </h4>
                    <h1>
                      The Ultimate <span>Gundam</span>
                    </h1>
                    <p className="custom-bestseller-text">
                      Lorem ipsum dolor sit amet consectetur adipisicing elit.
                      Sapiente harum in illum aspernatur sequi maxime et,
                      quisquam laborum deserunt consequatur!
                    </p>
                  </div>
                  <div className="banner-btns">
                    <button className="btn btn-custom-ban">Mua ngay !</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </SwiperSlide>
        {/* <SwiperSlide>
          <div className="container-fluid banner-2">
            <div className="container gx-0">
              <div className="row gx-0 align-items-center">
                <div className="col-md-12 col-lg-6">
                  <div className="banner-col2">
                    <img src={daitru} alt="" />
                  </div>
                </div>
                <div className="col-md-12 col-lg-6">
                  <div>
                    <div className="banner-col1 pt-md-4">
                      <h1>Dai Tru</h1>
                      <p>
                        Lorem ipsum dolor sit amet consectetur adipisicing elit.
                        Sapiente harum in illum aspernatur sequi maxime et,
                        quisquam laborum deserunt consequatur!
                      </p>
                    </div>
                    <div className="banner-btns">
                      <button className="btn btn-primary">Shop Now !</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </SwiperSlide> */}
      </Swiper>
    </>
  );
};

export default Banner;
