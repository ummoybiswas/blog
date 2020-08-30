<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../common/head.jsp"></jsp:include>
    <title>Blog</title>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col-12">
            <h3 class="mt-4">Add new Admin</h3>
            <%--@elvariable id="registrationForm" type="com.sqh.blog.controller.form.RegistrationForm"--%>
            <form:form method="POST" modelAttribute="registrationForm">
                <spring:bind path="fullName">
                    <div class="form-group">
                        <form:input type="text" path="fullName" class="form-control ${status.error ? 'is-invalid' : ''}"
                                    placeholder="Full Name"
                                    autofocus="true"></form:input>
                        <div class="invalid-feedback">
                            <form:errors path="fullName"></form:errors>
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="username">
                    <div class="form-group">
                        <form:input type="text" path="username" class="form-control ${status.error ? 'is-invalid' : ''}"
                                    placeholder="Username"
                                    autofocus="true"></form:input>
                        <div class="invalid-feedback">
                            <form:errors path="username"></form:errors>
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="password">
                    <div class="form-group">
                        <form:input type="password" path="password" class="form-control ${status.error ? 'is-invalid' : ''}"
                                    placeholder="Password"
                                    autofocus="true"></form:input>
                        <div class="invalid-feedback">
                            <form:errors path="password"></form:errors>
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="passwordConfirm">
                    <div class="form-group">
                        <form:input type="password" path="passwordConfirm"
                                    class="form-control  ${status.error ? 'is-invalid' : ''}"
                                    placeholder="Confirm your password"></form:input>
                        <div class="invalid-feedback">
                            <form:errors path="passwordConfirm"></form:errors>
                        </div>

                    </div>
                </spring:bind>
                <button type="submit" class="btn btn-primary mb-2">Submit</button>
            </form:form>
        </div>
    </div>
</div>

<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>