<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: DUCTIEN
  Date: 5/14/2024
  Time: 1:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    <style>
        .gradient-custom {
            /* fallback for old browsers */
            background: #f6d365;

            /* Chrome 10-25, Safari 5.1-6 */
            background: -webkit-linear-gradient(to right bottom, rgba(246, 211, 101, 1), rgba(253, 160, 133, 1));

            /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            background: linear-gradient(to right bottom, rgba(246, 211, 101, 1), rgba(253, 160, 133, 1))
        }
    </style>
</head>
<body style="background-color: #f4f5f7;">
<section class="vh-100">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-lg-6 mb-4 mb-lg-0">
                <div class="card mb-3" style="border-radius: .5rem;">
                    <div class="row g-0">
                        <div class="col-md-4 gradient-custom text-center text-white"
                             style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem;">
                            <img src="${pageContext.request.contextPath}/img/${student.avatar}" alt="Avatar" class="rounded-circle img-fluid my-5" style="width: 80px;"/>

                            <h5>${student.name}</h5>
                            <p>${student.faculty}</p>
                            <i class="far fa-edit mb-5"></i>
                        </div>
                        <div class="col-md-8">
                            <div class="card-body p-4">
                                <h5>Information</h5>
                                <hr class="mt-0 mb-4">
                                <div class="row pt-1">

                                    <div class="col-6 mb-3">
                                        <h6>Name</h6>
                                        <p class="text-muted">${student.name}</p>
                                    </div>

                                    <div class="col-6 mb-3">
                                        <h6>Gender</h6>
                                        <p class="text-muted">${student.gender?"Male":"Female"}</p>
                                    </div>
                                </div>
                                <div class="row pt-1">
                                    <div class="col-6 mb-3">
                                        <h6>Faculty</h6>
                                        <p class="text-muted">${student.faculty}</p>
                                    </div>
                                    <div class="col-6 mb-3">
                                        <h6>Hobbies</h6>
                                        <%
                                            String[] selectedHobbies = request.getParameterValues("hobbies");
                                            if (selectedHobbies != null && selectedHobbies.length > 0) {
                                                Map<String, String> hobbiesMap = (Map<String, String>) request.getAttribute("hobbies");
                                                List<String> selectedHobbiesList = new ArrayList<>();
                                                for (String hobbyIndex : selectedHobbies) {
                                                    String hobby = hobbiesMap.get(hobbyIndex);
                                                    selectedHobbiesList.add(hobby);
                                                }
                                                String selectedHobbiesString = String.join(", ", selectedHobbiesList);
                                        %>
                                        <p class="text-muted"><%= selectedHobbiesString %></p>
                                        <%
                                        } else {
                                        %>
                                        <p class="text-muted">No hobbies selected.</p>
                                        <%
                                            }
                                        %>

                                    </div>

                                </div>
                                <h5>Contact</h5>
                                <hr class="mt-0 mb-4">
                                <div class="row pt-1">
                                    <div class="col-12 mb-3">
                                        <h6>Email</h6>
                                        <p class="text-muted">${student.email}</p>
                                    </div>
                                </div>
                                <h5>Study</h5>
                                <hr class="mt-0 mb-4">
                                <div class="row pt-1">
                                    <div class="col-6 mb-3">
                                        <h6>Marks</h6>
                                        <p class="text-muted">${student.marks}</p>
                                    </div>

                                </div>

                                <div class="d-flex justify-content-start">
                                    <a href="#!"><i class="fab fa-facebook-f fa-lg me-3"></i></a>
                                    <a href="#!"><i class="fab fa-twitter fa-lg me-3"></i></a>
                                    <a href="#!"><i class="fab fa-instagram fa-lg"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
