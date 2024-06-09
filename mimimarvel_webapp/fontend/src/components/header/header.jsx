// import React from "react";

import { NavLink } from "react-router-dom";
import logo from "../../assets/favicon.png";
import cart from "../../assets/shopping_cart.png";
import find from "../../assets/find.png";
import "./header.css";
import { useState, useEffect, useRef } from "react";
import Cart from "../cart/cart";
import axios from "axios";

const Header = () => {
  const [scrolled, setscrolled] = useState(false);
  const [username, setUsername] = useState("");
  const [isInputVisible, setIsInputVisible] = useState(false);
  const inputRef = useRef(null);
  const [query, setQuery] = useState("");
  const [results, setResults] = useState([]);

  const handleInputChange = async (event) => {
    const inputValue = event.target.value;
    setQuery(inputValue);

    if (!inputValue) {
      setResults([]);
      return;
    }

    try {
      const response = await axios.get(
        `http://localhost:8080/product/find?keyword=${inputValue}`
      );
      setResults(response.data);
    } catch (error) {
      console.error("Error fetching search results:", error);
      setResults([]);
    }
  };

  const handleMouseEnter = () => {
    setIsInputVisible(true);
    setQuery("");
  };

  const handleMouseLeave = () => {
    if (!inputRef.current.contains(document.activeElement)) {
      setIsInputVisible(false);
      setResults([]);
    }
  };

  const HandleScroll = () => {
    const offsets = window.scrollY;
    if (offsets > 200) {
      setscrolled(true);
    } else {
      setscrolled(false);
    }
    // console.log(offsets);
  };

  const handleLogout = () => {
    localStorage.removeItem("username");
    localStorage.removeItem("phone");
    localStorage.removeItem("id");
    window.location.href = "/"; // Redirect to home page
  };

  useEffect(() => {
    window.addEventListener("scroll", HandleScroll);
    const loggedInUser = localStorage.getItem("username");
    if (loggedInUser) {
      setUsername(loggedInUser);
    }
    if (isInputVisible) {
      inputRef.current.focus();
    }
  }, [isInputVisible]);
  return (
    <>
      <nav
        className={`navbar navbar-expand-lg nav-sec1 ${
          scrolled ? "sticky-nav1" : ""
        }`}
        data-bs-theme="dark"
      >
        <div className="container">
          <NavLink to="/">
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
                <NavLink to="/about">Giới thiệu</NavLink>
              </li>
              <li className="nav-item nav-li">
                <NavLink to="/contact">Liên hệ</NavLink>
              </li>
            </ul>
            {/* search and shopping cart */}
            <form className="cart1 d-flex align-items-center mx-4">
              <div className="d-flex" onMouseLeave={handleMouseLeave}>
                <input
                  type="text"
                  className={`form-control form-control-sm ${
                    isInputVisible ? "d-block" : "d-none"
                  }`}
                  placeholder="Tìm kiếm sản phẩm"
                  ref={inputRef}
                  value={query}
                  onChange={handleInputChange}
                  onBlur={() => {
                    setIsInputVisible(false);
                    setResults([]);
                  }}
                />
                <img
                  src={find}
                  alt=""
                  data-bs-target="#searchModal"
                  className="img-small find mr-2 btn"
                  onMouseEnter={handleMouseEnter}
                />
              </div>

              <img
                src={cart}
                alt=""
                data-bs-toggle="modal"
                data-bs-target="#shoppingCart"
                className="img-small cart mr-2 btn"
              />
              {/* xử lý tổng số sản phẩm ở đây */}
              {/* <span className="cart-total--item"></span> */}

              <div
                className="modal fade "
                id={username ? "shoppingCart" : ""}
                data-bs-backdrop="static"
                data-bs-keyboard="false"
                tabIndex="-1"
                aria-labelledby="shoppingCartLabel"
                aria-hidden="true"
              >
                <div className="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-xl ">
                  <div className="modal-content bg-transparent custom-modal">
                    <div className="modal-body">
                      <div className="row d-flex justify-content-center align-items-center h-100">
                        <Cart />
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div className="dropdown px-3">
                <a
                  className="custom-dropdown-header dropdown-toggle"
                  href="#"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  {username || "Tài khoản"}
                </a>

                <ul className="dropdown-menu">
                  {username ? (
                    <>
                      <li>
                        <NavLink to="/profile" className="dropdown-item">
                          Thay đổi thông tin
                        </NavLink>
                      </li>
                      <li>
                        <NavLink to="/profile" className="dropdown-item">
                          Đơn hàng
                        </NavLink>
                      </li>
                      <hr />
                      <li>
                        <a
                          className="dropdown-item"
                          onClick={handleLogout}
                          href="#"
                        >
                          Đăng xuất
                        </a>
                      </li>
                    </>
                  ) : (
                    <>
                      <li>
                        <NavLink to="/signup" className="dropdown-item">
                          Đăng ký
                        </NavLink>
                      </li>
                      <li>
                        <NavLink to="/login" className="dropdown-item">
                          Đăng nhập
                        </NavLink>
                      </li>
                    </>
                  )}
                </ul>
              </div>
            </form>
          </div>
        </div>
      </nav>
      <div
        className={`search-results ${isInputVisible ? "d-block" : "d-none"} `}
        onBlur={() => {
          setIsInputVisible(false);
          setResults([]);
        }}
      >
        {results.map((product) => (
          <div key={product.id}>
            <NavLink to={`/singleProduct/${product.id}`}>
              <div className="container mt-3">
                <div className="row">
                  <div className="col-md-4">
                    <img
                      src={`../../../public/product/${product.image}`}
                      alt=""
                      width="50%"
                    />
                  </div>
                  <div className="col-md-8">
                    <div className="row align-item-center">
                      <div className="col-md-12">
                        <h5 className="text-dark">{product.name}</h5>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </NavLink>
            <hr />
          </div>
        ))}
      </div>
    </>
  );
};

export default Header;
