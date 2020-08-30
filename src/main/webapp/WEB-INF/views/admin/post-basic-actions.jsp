<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="btn-group btn-group-sm" data-post-id="${post.id}">
    <c:if test="${!post.approvedPost}">
        <a href="/admin/posts/approve/${post.id}?deatilPage=${detailPage}" class="btn btn-white">
            <span class="text-success"><i class="fa fa-check" aria-hidden="true"></i></span>
            Approve
        </a>
    </c:if>
    <a href="/admin/posts/delete/${post.id}" class="btn btn-white">
        <span class="text-light"><i class="fa fa-trash-o" aria-hidden="true"></i></span>
        Delete
    </a>
</div>