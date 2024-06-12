import axios from "axios";
import "./signup.css";
import { useState } from "react";
const Signup = () => {
  window.scrollTo(0, 0);
  const [userData, setUserData] = useState({
    username: "",
    password: "",
    emmail: "",
    fullname: "",
    gender: "",
    phone: "",
    birthdate: "",
  });
  const [showPassword, setShowPassword] = useState(false);
  const [pass, setPass] = useState("");
  const [repass, setRepass] = useState("");
  const [passwordsMatch, setPasswordsMatch] = useState(true);

  const togglePasswordVisibility = () => {
    setShowPassword(!showPassword);
  };

  const handlePassChange = (event) => {
    setPass(event.target.value);
    if (event.target.value !== repass) {
      setPasswordsMatch(false);
    } else {
      setPasswordsMatch(true);
    }
    setUserData({
      ...userData,
      password: event.target.value,
    });
  };

  const handleRepassChange = (event) => {
    setRepass(event.target.value);
    if (event.target.value !== pass) {
      setPasswordsMatch(false);
    } else {
      setPasswordsMatch(true);
    }
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    if (!passwordsMatch) {
      return;
    }

    try {
      const response = await axios.post(
        "http://localhost:8080/users/create",
        userData
      );
      console.log(response.data);
      alert("Đăng ký thành công");

      // Đặt userData về null
      setUserData(null); // Điều này giả sử bạn đã sử dụng useState để quản lý state của userData

      window.location.href = "/login";
    } catch (error) {
      console.error("Error:", error);
      alert("Đăng ký thất bại");
    }
  };
  return (
    <>
      <section className="vh-100 gradient-custom-signup">
        <div className="container py-5 h-100">
          <div className="row justify-content-center align-items-center h-100">
            <div className="col-12 col-lg-9 col-xl-7">
              <div className="card shadow-2-strong card-registration">
                <div className="card-body p-4 p-md-5">
                  <h3 className="mb-4 pb-2 pb-md-0 mb-md-5 text-white">
                    Đăng ký thành viên
                  </h3>
                  <form onSubmit={handleSubmit}>
                    <div className="row">
                      <div className="col-md-6 mb-4">
                        <div data-mdb-input-init className="form-outline">
                          <input
                            type="text"
                            id="fullname"
                            name="name"
                            className="form-control form-control-lg"
                            value={userData.fullname}
                            onChange={(e) =>
                              setUserData({
                                ...userData,
                                fullname: e.target.value,
                              })
                            }
                          />
                          <label className="form-label text-white">
                            Họ và tên
                          </label>
                        </div>
                      </div>
                      <div className="col-md-6 mb-4">
                        <div data-mdb-input-init className="form-outline">
                          <input
                            type="text"
                            id="username"
                            name="username"
                            className="form-control form-control-lg"
                            value={userData.username}
                            onChange={(e) =>
                              setUserData({
                                ...userData,
                                username: e.target.value,
                              })
                            }
                          />
                          <label className="form-label text-white">
                            Username
                          </label>
                        </div>
                      </div>
                    </div>

                    <div className="row">
                      <div className="col-md-6 mb-4 d-flex align-items-center">
                        <div
                          data-mdb-input-init
                          className="form-outline datepicker w-100"
                        >
                          <input
                            type="date"
                            name="birthday"
                            className="form-control form-control-lg"
                            id="birthdayDate"
                            value={userData.birthdate}
                            onChange={(e) =>
                              setUserData({
                                ...userData,
                                birthdate: e.target.value,
                              })
                            }
                          />
                          <label className="form-label text-white">
                            Ngày sinh
                          </label>
                        </div>
                      </div>
                      <div className="col-md-6 mb-4">
                        <h6 className="mb-2 pb-1 text-white">Giới tính: </h6>

                        <div className="form-check form-check-inline">
                          <input
                            className="form-check-input"
                            type="radio"
                            name="gender"
                            id="Female"
                            value="Nữ"
                            onChange={(e) =>
                              setUserData({
                                ...userData,
                                gender: e.target.value,
                              })
                            }
                          />
                          <label className="form-check-label text-white">
                            Nữ
                          </label>
                        </div>

                        <div className="form-check form-check-inline">
                          <input
                            className="form-check-input"
                            type="radio"
                            name="gender"
                            id="Male"
                            value="Nam"
                            onChange={(e) =>
                              setUserData({
                                ...userData,
                                gender: e.target.value,
                              })
                            }
                          />
                          <label className="form-check-label text-white">
                            Nam
                          </label>
                        </div>

                        <div className="form-check form-check-inline">
                          <input
                            className="form-check-input"
                            type="radio"
                            name="gender"
                            id="Other"
                            value="Khác"
                            onChange={(e) =>
                              setUserData({
                                ...userData,
                                gender: e.target.value,
                              })
                            }
                          />
                          <label className="form-check-label text-white">
                            Khác
                          </label>
                        </div>
                      </div>
                    </div>

                    <div className="row">
                      <div className="col-md-6 mb-4 pb-2">
                        <div data-mdb-input-init className="form-outline">
                          <input
                            type="email"
                            id="emailAddress"
                            name="email"
                            className="form-control form-control-lg"
                            value={userData.email}
                            onChange={(e) =>
                              setUserData({
                                ...userData,
                                email: e.target.value,
                              })
                            }
                          />
                          <label className="form-label text-white">Email</label>
                        </div>
                      </div>
                      <div className="col-md-6 mb-4 pb-2">
                        <div data-mdb-input-init className="form-outline">
                          <input
                            type="tel"
                            id="phoneNumber"
                            name="phone"
                            className="form-control form-control-lg"
                            value={userData.phone}
                            onChange={(e) =>
                              setUserData({
                                ...userData,
                                phone: e.target.value,
                              })
                            }
                          />
                          <label className="form-label text-white">
                            Số điện thoại
                          </label>
                        </div>
                      </div>
                    </div>

                    <div className="row">
                      <div className="col-md-6 mb-4 pb-2">
                        <div data-mdb-input-init className="form-outline ">
                          <div className="input-group">
                            <input
                              type={showPassword ? "text" : "password"}
                              id="pass"
                              name="password"
                              className="form-control form-control-lg "
                              value={pass}
                              onChange={handlePassChange}
                            />
                            <span
                              className="password-toggle-icon py-3 my-auto input-group-text"
                              onClick={togglePasswordVisibility}
                            >
                              <i
                                className={`fa ${
                                  showPassword ? "fa-eye" : "fa-eye-slash"
                                }`}
                              ></i>
                            </span>
                          </div>

                          <label className="form-label text-white">
                            Mật khẩu
                          </label>
                        </div>
                      </div>
                      <div className="col-md-6 mb-4 pb-2">
                        <div data-mdb-input-init className="form-outline ">
                          <div className="input-group">
                            <input
                              type={showPassword ? "text" : "password"}
                              id="repass"
                              className="form-control form-control-lg"
                              value={repass}
                              onChange={handleRepassChange}
                            />
                            <span
                              className="password-toggle-icon my-auto py-3 input-group-text"
                              onClick={togglePasswordVisibility}
                            >
                              <i
                                className={`fa ${
                                  showPassword ? "fa-eye" : "fa-eye-slash"
                                }`}
                              ></i>
                            </span>
                          </div>

                          <label className="form-label text-white">
                            Nhập lại mật khẩu
                          </label>
                        </div>
                      </div>
                      {!passwordsMatch && (
                        <p style={{ color: "red" }}>Mật khẩu không khớp</p>
                      )}
                    </div>

                    <div className="mt-4 pt-2 row">
                      <input
                        data-mdb-ripple-init
                        className="btn btn-outline-light btn-lg"
                        type="submit"
                        value="Đăng ký"
                      />
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </>
  );
};

export default Signup;
