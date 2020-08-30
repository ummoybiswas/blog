<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="./common/head.jsp"></jsp:include>
    <title>Blog</title>
</head>
<body class="bg-dark text-white py-5">
<div class="container py-5">
    <div class="row">
        <div class="col-md-2 text-center">
            <p><i class="fa fa-exclamation-triangle fa-5x"></i><br/>Status Code: 404</p>
        </div>
        <div class="col-md-10">
            <h3>OPPSSS!!!! Sorry...</h3>
            <p>Sorry, the page you are looking for does not exist!.<br/>Please
                go back to the previous page to continue browsing.</p>
            <a class="btn btn-danger" href="javascript:history.back()">Go Back</a>
        </div>
    </div>
</div>
<jsp:include page="./common/footer.jsp"></jsp:include>
</body>