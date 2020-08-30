<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="btn-group btn-group-sm" data-post-id="${post.id}">
    <c:if test="${!(post.admin || post.submittedByActor)}">
        <c:if test="${!post.likedByActor}">
            <button type="button" class="btn btn-white" id="like-btn" data-is-liked="${post.likedByActor}">
                <span class="text-light"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i></span>
                Like
            </button>
        </c:if>
        <c:if test="${post.likedByActor}">
            <button type="button" class="btn btn-success" id="like-btn" data-is-liked="${post.likedByActor}">
                <span><i class="fa fa-thumbs-up" aria-hidden="true"></i></span>
                Like
            </button>
        </c:if>
        <c:if test="${!post.dislikedByActor}">
            <button type="button" class="btn btn-white" id="dislike-btn" data-is-disliked="${post.dislikedByActor}">
                <span class="text-light"><i class="fa fa-thumbs-o-down" aria-hidden="true"></i></span>
                Dislike
            </button>
        </c:if>
        <c:if test="${post.dislikedByActor}">
            <button type="button" class="btn btn-danger" id="dislike-btn" data-is-disliked="${post.dislikedByActor}">
                <span><i class="fa fa-thumbs-down" aria-hidden="true"></i></span>
                Dislike
            </button>
        </c:if>
    </c:if>
    <c:if test="${post.admin && !post.approvedPost}">
        <button type="button" class="btn btn-white" id="approve-btn">
            <span class="text-success"><i class="fa fa-check" aria-hidden="true"></i></span>
            Approve
        </button>
    </c:if>
    <c:if test="${post.admin || post.submittedByActor}">
        <a href="/posts/delete/${post.id}" id="delete-btn" class="btn btn-white">
            <span class="text-light"><i class="fa fa-trash-o" aria-hidden="true"></i></span>
            Delete
        </a>
    </c:if>
</div>