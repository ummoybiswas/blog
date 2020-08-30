$(document).on("click", "#like-btn", function () {
    let postId = $(this).parent().attr('data-post-id');
    let oPromise = $.get('/posts/like/' + postId + '?detailPage=' + detailPage, null);
    oPromise.done(function (oHtml) {
        $("#post-" + postId).html(oHtml);
    });
});

$(document).on("click", "#dislike-btn", function () {
    let postId = $(this).parent().attr('data-post-id');
    let oPromise = $.get('/posts/dislike/' + postId + '?detailPage=' + detailPage, null);
    oPromise.done(function (oHtml) {
        $("#post-" + postId).html(oHtml);
    });
});

$(document).on("click", "#approve-btn", function () {
    let postId = $(this).parent().attr('data-post-id');
    let oPromise = $.get('/posts/approve/' + postId + '?detailPage=' + detailPage, null);
    oPromise.done(function (oHtml) {
        $("#post-" + postId).html(oHtml);
    });
});

$(document).on("click", "#delete-btn", function () {
    let postId = $(this).parent().attr('data-post-id');
    if (confirm("Are you sure?")) {
        window.location.href = "/posts/delete/" + postId;
    }
});