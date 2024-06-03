// import React from "react";

import { NavLink } from "react-router-dom";
import logo from "../../assets/favicon.png";
import cart from "../../assets/shopping_cart.png";
import find from "../../assets/find.png";
import "./header.css";
import { useState, useEffect } from "react";

const Header = () => {
  const [scrolled, setscrolled] = useState(false);

  const HandleScroll = () => {
    const offsets = window.scrollY;
    if (offsets > 200) {
      setscrolled(true);
    } else {
      setscrolled(false);
    }
    // console.log(offsets);
  };

  useEffect(() => {
    window.addEventListener("scroll", HandleScroll);
  }, []);
  return (
    <>
      <nav
        className={`navbar navbar-expand-lg nav-sec1 ${
          scrolled ? "sticky-nav1" : ""
        }`}
        data-bs-theme="dark"
      >
        <div className="container">
          <NavLink>
            <img src={logo} alt="" width="110%" height="70px" />
          </NavLink>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav mx-auto mb-2 mb-lg-0 nav-ul">
              <li className="nav-li nav-item">
                <NavLink to="/">Trang chủ</NavLink>
              </li>
              <li className="nav-item nav-li">
                <NavLink to="/products">Sản phẩm</NavLink>
              </li>
              <li className="nav-item nav-li">
                <NavLink to="/service">Dịch vụ</NavLink>
              </li>
              <li className="nav-item nav-li">
                <NavLink to="/about">Giới thiệu</NavLink>
              </li>
              <li className="nav-item nav-li">
                <NavLink to="/contact">Liên hệ</NavLink>
              </li>
            </ul>
            {/* search and shopping cart */}
            <form className="cart1 d-flex align-items-center mx-4">
              <img
                src={find}
                alt=""
                // data-bs-toggle="modal"
                // data-bs-target="#exampleModal"
                // xử lý code search ở đây
                className="img-small mx-3"
              />
              <NavLink to="">
                <img
                  src={cart}
                  alt=""
                  //   data-bs-toggle="offcanvas"
                  //   data-bs-target="#offcanvasRight"
                  //   aria-controls="offcanvasRight"
                  className="img-small mr-2"
                />
                {/* xử lý tổng số sản phẩm ở đây */}
                {/* <span className="cart-total--item"></span> */}
              </NavLink>
              <div className="dropdown px-3">
                <a
                  className="custom-dropdown-header dropdown-toggle"
                  href="#"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  Tài khoản
                </a>

                <ul className="dropdown-menu">
                  <li>
                    <a className="dropdown-item" href="#">
                      Đăng ký
                    </a>
                  </li>
                  <li>
                    <a className="dropdown-item" href="#">
                      Đăng nhập
                    </a>
                  </li>
                  <li>
                    <a className="dropdown-item" href="#">
                      Đăng xuất
                    </a>
                  </li>
                </ul>
              </div>
            </form>
          </div>
        </div>
      </nav>
    </>
  );
};

export default Header;
