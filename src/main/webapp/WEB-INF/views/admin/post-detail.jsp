<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../common/head.jsp"></jsp:include>
    <title>Blog</title>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

<c:choose>
    <c:when test="${not empty message}">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="alert alert-danger">
                            ${message}
                    </div>
                </div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="container" id="post-${post.id}">
            <c:set var="detailPage" scope="request" value="true"></c:set>
            <jsp:include page="./single-post.jsp"></jsp:include>
        </div>
    </c:otherwise>
</c:choose>
</div>


<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>