<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="./head.jsp"></jsp:include>
    <title>Blog - Home</title>
</head>
<body>

<jsp:include page="./header.jsp"></jsp:include>
<c:if test="${not empty message}">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="alert alert-danger">
                        ${message}
                </div>
            </div>
        </div>
    </div>
</c:if>
<div class="container">
    <jsp:useBean id="posts" scope="request" type="java.util.List<com.sqh.blog.controller.data.PostData>"/>
    <c:if test="${posts.isEmpty()}">
        <div class="d-flex justify-content-center align-items-center">
            <h3 class="text-center">Currently no posts is available.</h3>
        </div>
    </c:if>
    <c:if test="${!posts.isEmpty()}">
        <div class="row">
            <div class="col-12">
                <h3>Recent Posts</h3>
            </div>
        </div>
        <div class="row">
            <c:forEach items="${posts}" var="post" varStatus="counter">
                <div id="post-${post.id}" class="col-12">
                    <c:set var="detailPage" scope="request" value="false"></c:set>
                    <c:set var="post" scope="request" value="${post}"></c:set>
                    <jsp:include page="./single-post.jsp"></jsp:include>
                </div>
            </c:forEach>
        </div>
    </c:if>
</div>

<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>