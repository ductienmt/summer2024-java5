<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: DUCTIEN
  Date: 5/14/2024
  Time: 1:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Registration Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body style="background-color: #8fc4b7;">
<section class="h-100 h-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-8 col-xl-6">
                <div class="card rounded-3">
                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"
                         class="w-100" style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
                         alt="Sample photo">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Registration Info</h3>

                        <form:form action="/save" method="post" class="px-md-2" modelAttribute="student" enctype="multipart/form-data">

                            <div data-mdb-input-init class="form-outline mb-3">
                                <label class="form-label" for="name">Name</label>
                                <form:input path="name" type="text" id="name" class="form-control"/>
                                <span class="text-danger"><form:errors path="name"/></span>

                            </div>

                            <div data-mdb-input-init class="form-outline mb-3">
                                <label class="form-label" for="email">Email</label>
                                <form:input path="email" type="email" id="email" class="form-control"/>
                                <span class="text-danger"><form:errors path="email"/></span>

                            </div>

                            <div class="row">
                                <div class="col-md-6 mb-3">

                                    <div data-mdb-input-init class="form-outline datepicker">
                                        <label for="marks" class="form-label">Marks</label>
                                        <form:input type="number" path="marks" class="form-control" id="marks"/>
                                        <span class="text-danger"><form:errors path="marks"/></span>

                                    </div>

                                </div>
                                <div class="col-md-6 mb-3">

                                    <label class="form-label">Gender:</label> <br>
                                    <% Map<Boolean, String> genders = (Map<Boolean, String>) request.getAttribute("genders");
                                        for (Map.Entry<Boolean, String> entry : genders.entrySet()) {
                                            Boolean bool = entry.getKey();
                                            String gender = entry.getValue();
                                    %>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="gender" id="<%= bool%>"
                                               value="<%= bool%>">
                                        <label class="form-check-label" for="<%= bool%>"><%= gender%>
                                        </label>
                                    </div>
                                    <% } %>


                                </div>
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Hobbies</label> <br>
                                <% Map<String, String> facultyMap = (Map<String, String>) request.getAttribute("hobbies");
                                    for (Map.Entry<String, String> entry : facultyMap.entrySet()) {
                                        String hobby = entry.getKey();
                                        String hobbyName = entry.getValue();
                                %>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" name="hobbies" id="<%= hobby%>"
                                           value="<%= hobby%>">
                                    <label class="form-check-label" for="<%= hobby%>"><%= hobbyName%>
                                </div>
                                <%}%>
                            </div>

                            <div class="row mb-3 pb-2 pb-md-0 mb-md-4">
                                <div class="col-md-6">
                                    <div data-mdb-input-init class="form-outline mt-3">
                                        <label class="form-label" for="facultySelect">Select Faculty</label>
                                        <select id="facultySelect" name="faculty" class="form-select">
                                            <c:forEach var="faculty" items="${faculties}">
                                                <option value="${faculty}">${faculty}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-outline mt-3">
                                        <label for="image" class="form-label">Avatar</label> <br>
                                        <input type="file" class="form-control" id="image" name="image"/>
                                        <span>${message}</span>
                                    </div>
                                </div>
                            </div>

                            <button type="submit" data-mdb-button-init data-mdb-ripple-init
                                    class="btn btn-success btn-lg mb-1">Submit
                            </button>

                        </form:form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
