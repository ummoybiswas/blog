<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="btn-group btn-group-sm" data-post-id="${post.id}">
    <c:choose>
        <c:when test="${post.submittedByActor}">
            <button type="button" class="btn btn-white shadow-none" data-toggle="tooltip" data-placement="top"
                    title="You cannot like your own post" data-is-liked="${post.likedByActor}">
                <span class="text-light"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i></span>
                Like ${post.likeCount}
            </button>
            <button type="button" class="btn btn-white shadow-none" data-toggle="tooltip" data-placement="top"
                    title="You cannot dislike your own post" data-is-disliked="${post.dislikedByActor}">
                <span class="text-light"><i class="fa fa-thumbs-o-down" aria-hidden="true"></i></span>
                Dislike ${post.dislikeCount}
            </button>
        </c:when>
        <c:otherwise>
            <c:if test="${!post.likedByActor}">
                <button type="button" class="btn btn-white" id="like-btn" data-is-liked="${post.likedByActor}">
                    <span class="text-light"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i></span>
                    Like ${post.likeCount}
                </button>
            </c:if>
            <c:if test="${post.likedByActor}">
                <button type="button" class="btn btn-success" id="like-btn" data-is-liked="${post.likedByActor}">
                    <span><i class="fa fa-thumbs-up" aria-hidden="true"></i></span>
                    Like ${post.likeCount}
                </button>
            </c:if>
            <c:if test="${!post.dislikedByActor}">
                <button type="button" class="btn btn-white" id="dislike-btn" data-is-disliked="${post.dislikedByActor}">
                    <span class="text-light"><i class="fa fa-thumbs-o-down" aria-hidden="true"></i></span>
                    Dislike ${post.dislikeCount}
                </button>
            </c:if>
            <c:if test="${post.dislikedByActor}">
                <button type="button" class="btn btn-danger" id="dislike-btn"
                        data-is-disliked="${post.dislikedByActor}">
                    <span><i class="fa fa-thumbs-down" aria-hidden="true"></i></span>
                    Dislike ${post.dislikeCount}
                </button>
            </c:if>
        </c:otherwise>
    </c:choose>
    <c:if test="${post.submittedByActor}">
        <button type="button" id="delete-btn" class="btn btn-white">
            <span class="text-light"><i class="fa fa-trash-o" aria-hidden="true"></i></span>
            Delete
        </button>
    </c:if>
</div>