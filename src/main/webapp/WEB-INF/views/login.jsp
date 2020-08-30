<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="./common/head.jsp"></jsp:include>
    <title>Blog</title>
</head>
<body>

<div id="logreg-forms">
    <form class="form-signin" method="post" action="/login">
        <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Sign in</h1>
        <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
            <div class="alert alert-danger" role="alert">
                <c:out value="${SPRING_SECURITY_LAST_EXCEPTION}" />
                <c:remove var = "SPRING_SECURITY_LAST_EXCEPTION" scope = "session" />
            </div>
        </c:if>
        <c:if test="${not empty message}">
            <div class="alert alert-success" role="alert">
                <c:out value="${message}" />
            </div>
        </c:if>
        <div class="form-group">
            <input type="text" id="inputEmail" name="username" class="form-control" placeholder="Username" required
                   autofocus>
        </div>
        <div class="form-group">
            <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password"
                   required>
        </div>
        <button class="btn btn-success btn-block" type="submit"><i class="fa fa-sign-in"></i> Sign in</button>
        <hr>
        <a class="btn btn-primary btn-block text-white" href="/registration" id="btn-signup"><i class="fa fa-user-plus"></i> Sign up
            New Account
        </a>
    </form>
    <br/>

</div>

<jsp:include page="./common/footer.jsp"></jsp:include>
</body>
</html>
