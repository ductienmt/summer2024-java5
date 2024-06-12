/* eslint-disable react/no-unescaped-entities */
import { useState } from "react";
import "./login.css";
import axios from "axios";

const Login = () => {
  window.scrollTo(0, 0);
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      // eslint-disable-next-line no-unused-vars
      const response = await axios.post(
        `http://localhost:8080/users/login?username=${username}&password=${password}`
      );

      alert("Đăng nhập thành công");
      localStorage.setItem("username", username);
      localStorage.setItem("phone", response.data.phone);
      localStorage.setItem("id", response.data.id);
      window.location.href = "/"; // Redirect to home page
    } catch (error) {
      // setError("Login failed: " + error.message);
      alert("Đăng nhập thất bại");
    }
  };

  return (
    <>
      <div className="container-fluid vh-100 gradient-custom">
        <div className="container py-5 h-100">
          <div className="row d-flex justify-content-center align-items-center h-100">
            <div className="col-12 col-md-8 col-lg-6 col-xl-5">
              <div className="card bg-dark text-white custom-card-radius">
                <div className="card-body p-5 text-center">
                  <form onSubmit={handleSubmit}>
                    <div className="mb-md-5 mt-md-4 pb-5">
                      <h2 className="fw-bold mb-2 text-uppercase">Đăng nhập</h2>
                      <p className="text-white-50 mb-5">
                        Hãy nhập username và mật khẩu để đăng nhập !
                      </p>
                      <div className="form-outline form-white mb-4">
                        <label className="form-label">Username</label>
                        <input
                          type="text"
                          className="form-control form-control-lg"
                          value={username}
                          onChange={(e) => setUsername(e.target.value)}
                          required
                        />
                      </div>
                      <div className="form-outline form-white mb-4">
                        <label className="form-label">Mật khẩu</label>
                        <input
                          type="password"
                          className="form-control form-control-lg"
                          value={password}
                          onChange={(e) => setPassword(e.target.value)}
                          required
                        />
                      </div>
                      <button
                        className="btn btn-outline-light btn-lg px-5"
                        type="submit"
                      >
                        Đăng nhập
                      </button>
                    </div>
                  </form>
                  <div>
                    <p className="mb-0">
                      Bạn chưa có tài khoản?{" "}
                      <a href="/signup" className="text-white-50 fw-bold">
                        Đăng ký tại đây
                      </a>
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Login;
