<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${detailPage}">
        <div class="row">
            <div class="col-12">
                <h1 class="mt-4">${post.title}</h1>
                <p class="lead">
                    by
                    <a href="#">${post.postedBy}</a>
                </p>
                <hr>
                <div class="d-flex justify-content-between align-items-center">
                    <p class="mb-0">Posted on ${post.postedAt}</p>
                    <jsp:include page="./post-basic-actions.jsp"></jsp:include>
                </div>
                <hr>
                <p class="lead">
                        ${post.text}
                <hr>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="card card-small card-post mb-4">
            <div class="card-body">
                <a class="text-decoration-none text-dark" href="/admin/posts/detail/${post.id}"><h5
                        class="card-title">${post.title}</h5></a>
                <p class="card-text text-muted">${post.text}</p>
            </div>
            <div class="card-footer border-top d-flex">
                <div class="card-post__author d-flex">
                    <div class="d-flex flex-column justify-content-center ml-3">
                        <span class="card-post__author-name">${post.postedBy}</span>
                        <small class="text-muted">${post.postedAt}</small>
                    </div>
                </div>

                <div class="my-auto ml-auto">
                    <div class="blog-comments__actions">
                        <jsp:include page="./post-basic-actions.jsp"></jsp:include>
                    </div>
                </div>
            </div>
        </div>
    </c:otherwise>
</c:choose>

<script>
    var detailPage = ${detailPage};
</script>