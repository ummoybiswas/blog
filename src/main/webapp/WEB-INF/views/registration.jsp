<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="./common/head.jsp"></jsp:include>
    <title>Blog</title>
</head>
<body>

<div id="logreg-forms">
    <%--@elvariable id="registrationForm" type="com.sqh.blog.controller.form.RegistrationForm"--%>
    <form:form method="POST" modelAttribute="registrationForm" class="form-signup">
        <h1 class="h3 mb-3 font-weight-normal text-center"> Sign up</h1>
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

        <button class="btn btn-primary btn-block" type="submit"><i class="fa fa-user-plus"></i> Sign Up</button>

        <a href="/login" id="cancel_signup"><i class="fa fa-angle-left"></i> Back</a>
    </form:form>
    <br/>

</div>


<jsp:include page="./common/footer.jsp"></jsp:include>
</body>
</html>
