import React, { useState } from "react";
import "./loginadmin.css";
import axios from "axios";

function LoginAdmin() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  //   const [emailadmin, setEmail] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      // eslint-disable-next-line no-unused-vars
      const response = await axios.post(
        `http://localhost:8080/admin/login?username=${username}&password=${password}`
      );

      alert("Đăng nhập thành công");
      window.location.href = "/admin/home"; // Redirect to home page
    } catch (error) {
      // setError("Login failed: " + error.message);
      alert("Đăng nhập thất bại");
      console.error("Error logging in", error);
    }
  };
  return (
    <>
      <section className="background-radial-gradient-admin overflow-hidden">
        <div className="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
          <div className="row gx-lg-5 align-items-center mb-5">
            <div className="col-lg-6 mb-5 mb-lg-0" style={{ zIndex: 10 }}>
              <h1
                className="my-5 display-5 fw-bold ls-tight"
                style={{ color: "hsl(218, 81%, 95%)" }}
              >
                Admin page of <br />
                <span style={{ color: "hsl(218, 81%, 75%)" }}>MIMI MARVEL</span>
              </h1>
              <p
                className="mb-4 opacity-70"
                style={{ color: "hsl(218, 81%, 85%)" }}
              >
                Lorem ipsum dolor, sit amet consectetur adipisicing elit.
                Temporibus, expedita iusto veniam atque, magni tempora mollitia
                dolorum consequatur nulla, neque debitis eos reprehenderit quasi
                ab ipsum nisi dolorem modi. Quos?
              </p>
            </div>

            <div className="col-lg-6 custom-card-login-admin mb-5 mb-lg-0 position-relative">
              <div
                id="radius-shape-1"
                className="position-absolute rounded-circle shadow-5-strong"
              ></div>
              <div
                id="radius-shape-2"
                className="position-absolute shadow-5-strong"
              ></div>

              <div className="card bg-glass-admin">
                <div className="card-body px-4 py-5 px-md-5">
                  <form onSubmit={handleSubmit}>
                    {/* <div className="row">
                      <div className="col-md-6 mb-4">
                        <div className="form-outline">
                          <input
                            type="text"
                            id="form3Example1"
                            className="form-control"
                          />
                          <label className="form-label" htmlFor="form3Example1">
                            First name
                          </label>
                        </div>
                      </div>
                      <div className="col-md-6 mb-4">
                        <div className="form-outline">
                          <input
                            type="text"
                            id="form3Example2"
                            className="form-control"
                          />
                          <label className="form-label" htmlFor="form3Example2">
                            Last name
                          </label>
                        </div>
                      </div>
                    </div> */}
                    <div className="py-5">
                      <h2 className="text-center text-uppercase custom-text-admin-login">
                        Login Form
                      </h2>
                    </div>

                    {/* <div className="form-outline mt-3 mb-4">
                      <label className="form-label" htmlFor="form3Example3">
                        Email address
                      </label>
                      <input
                        type="email"
                        id="form3Example3"
                        className="form-control"
                        onChange={(e) => setEmail(e.target.value)}
                      />
                    </div> */}
                    <div className="form-outline mt-3 mb-4">
                      <label className="form-label" htmlFor="form3Example2">
                        Username
                      </label>
                      <input
                        type="text"
                        id="form3Example2"
                        className="form-control"
                        onChange={(e) => setUsername(e.target.value)}
                      />
                    </div>

                    <div className="form-outline mb-4">
                      <label className="form-label" htmlFor="form3Example4">
                        Password
                      </label>
                      <input
                        type="password"
                        id="form3Example4"
                        className="form-control"
                        onChange={(e) => setPassword(e.target.value)}
                      />
                    </div>

                    {/*  */}

                    <div className="d-flex justify-content-center">
                      <button
                        type="submit"
                        className="btn custom-btn-login-admin btn-block mb-4"
                      >
                        Sign up
                      </button>
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
}

export default LoginAdmin;
