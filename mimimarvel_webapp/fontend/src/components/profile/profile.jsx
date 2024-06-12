import axios from "axios";
import React, { useEffect, useState } from "react";

function Profile() {
  const [userData, setUserData] = useState([]);
  window.scrollTo(0, 0);
  const [image, setImage] = useState("");
  const [imageName, setImageName] = useState("");

  const [showPassword, setShowPassword] = useState(false);
  const [currentPassword, setCurrentPassword] = useState("");
  const [newPassword, setNewPassword] = useState("");
  const [confirmNewPassword, setConfirmNewPassword] = useState("");
  const [error, setError] = useState("");
  const [isButtonDisabled, setIsButtonDisabled] = useState(true);

  const togglePasswordVisibility = () => {
    setShowPassword(!showPassword);
  };

  const handleCurrentPasswordChange = (e) => {
    setCurrentPassword(e.target.value);
  };

  const handleNewPasswordChange = (e) => {
    setNewPassword(e.target.value);
    validatePasswords(e.target.value, confirmNewPassword);
  };

  const handleConfirmNewPasswordChange = (e) => {
    setConfirmNewPassword(e.target.value);
    validatePasswords(newPassword, e.target.value);
  };

  const validatePasswords = (newPass, confirmPass) => {
    if (newPass !== confirmPass) {
      setError("Mật khẩu mới và mật khẩu nhập lại không khớp");
      setIsButtonDisabled(true);
    } else {
      setError("");
      setIsButtonDisabled(false);
    }
  };

  const handleSubmit = async () => {
    try {
      if (!userData) {
        setError("Không thể tải dữ liệu người dùng.");
        return;
      }

      // Compare current password
      if (userData.password !== currentPassword) {
        setError("Mật khẩu hiện tại không chính xác");
        return;
      }

      userData.password = newPassword;

      // Update password
      await axios.post(
        `http://localhost:8080/users/update/${userId}`,
        userData
      );

      alert("Thay đổi mật khẩu thành công");
      // Clear the form
      setCurrentPassword("");
      setNewPassword("");
      setConfirmNewPassword("");
      setError("");
    } catch (error) {
      alert("Có lỗi xảy ra. Vui lòng thử lại sau.");
      console.log(error);
    }
  };

  const uploadImage = async (e) => {
    const file = e.target.files[0];
    if (file) {
      setImage(URL.createObjectURL(file));
      setImageName(file.name);
      console.log(file.name);
      // console.log(imageName);

      userData.avatar = file.name;
      // console.log(formData);

      const response = await axios.post(
        `http://localhost:8080/users/update/${userId}`,
        userData
      );

      alert("Thay đổi ảnh đại diện thành công");
    }
  };

  const handleImageClick = () => {
    document.getElementById("fileInput").click();
  };

  const userId = localStorage.getItem("id");

  const loadProfile = async () => {
    console.log(userId);
    try {
      const response = await axios.get(
        `http://localhost:8080/users/get/${userId}`
      );
      setUserData(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    loadProfile();
  }, [userId]);

  return (
    <>
      <section style={{ backgroundColor: "#eee" }}>
        <div className="container py-5">
          <div className="row">
            <div className="col-lg-4">
              <div className="card mb-4">
                <div className="card-body text-center">
                  <input
                    type="file"
                    accept="image/*"
                    id="fileInput"
                    style={{ display: "none" }}
                    onChange={uploadImage}
                  />
                  <img
                    src={`../../../public/avatar/${userData.avatar}`}
                    alt="avatar"
                    className="rounded-circle img-fluid"
                    style={{ width: "150px", cursor: "pointer" }}
                    onClick={handleImageClick}
                  />
                  <h5 className="my-3">{userData.fullname}</h5>
                  {/* {imageName && <p>{imageName}</p>} */}
                </div>
              </div>
            </div>
            <div className="col-lg-8">
              <div className="card mb-4">
                <div className="card-body">
                  <div className="row">
                    <div className="col-sm-3">
                      <p className="mb-0">Full Name</p>
                    </div>
                    <div className="col-sm-9">
                      <p className="text-muted mb-0">{userData.fullname}</p>
                    </div>
                  </div>
                  <hr />
                  <div className="row">
                    <div className="col-sm-3">
                      <p className="mb-0">Email</p>
                    </div>
                    <div className="col-sm-9">
                      <p className="text-muted mb-0">{userData.email}</p>
                    </div>
                  </div>
                  <hr />
                  <div className="row">
                    <div className="col-sm-3">
                      <p className="mb-0">Phone</p>
                    </div>
                    <div className="col-sm-9">
                      <p className="text-muted mb-0">{userData.phone}</p>
                    </div>
                  </div>
                  <hr />
                  <div className="row">
                    <div className="col-sm-3">
                      <p className="mb-0">Gender</p>
                    </div>
                    <div className="col-sm-9">
                      <p className="text-muted mb-0">{userData.gender}</p>
                    </div>
                  </div>
                  <hr />
                  <div className="row">
                    <div className="col-sm-3">
                      <p className="mb-0">Birtday</p>
                    </div>
                    <div className="col-sm-9">
                      <p className="text-muted mb-0">{userData.birthdate}</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div className="row">
            <div className="col-lg-4">
              <div className="card mb-4">
                <div className="card-body ">
                  <h5 className="text-center">Thay đổi mật khẩu</h5>
                  <div data-mdb-input-init className="form-outline py-3">
                    <label className="form-label">Mật khẩu hiện tại</label>
                    <div className="input-group">
                      <input
                        type={showPassword ? "text" : "password"}
                        name="password_old"
                        className="form-control form-control-lg "
                        value={currentPassword}
                        onChange={handleCurrentPasswordChange}
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
                  </div>
                  <div data-mdb-input-init className="form-outline py-3">
                    <label className="form-label">Mật khẩu mới</label>
                    <div className="input-group">
                      <input
                        type={showPassword ? "text" : "password"}
                        name="password"
                        className="form-control form-control-lg "
                        value={newPassword}
                        onChange={handleNewPasswordChange}
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
                  </div>
                  <div data-mdb-input-init className="form-outline py-3">
                    <label className="form-label">Nhập lại mật khẩu</label>
                    <div className="input-group">
                      <input
                        type={showPassword ? "text" : "password"}
                        id="repass"
                        className="form-control form-control-lg"
                        value={confirmNewPassword}
                        onChange={handleConfirmNewPasswordChange}
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
                  </div>
                  {error && <p className="text-danger text-center">{error}</p>}
                  <button
                    className="col-md-12 btn btn-success"
                    onClick={handleSubmit}
                    disabled={isButtonDisabled}
                  >
                    Xác nhận
                  </button>
                </div>
              </div>
            </div>
            <div className="col-lg-8">
              <div className="card mb-4">
                <div className="card-body">
                  <div className="row">
                    <h5 className="text-mute">Hoạt động gần đây</h5>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </>
  );
}

export default Profile;
