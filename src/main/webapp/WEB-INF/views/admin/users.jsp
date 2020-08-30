<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../common/head.jsp"></jsp:include>
    <title>Blog</title>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

<div class="container">
    <div class="text-right mb-4">
        <a href="/users/create" class="text-decoration-none btn btn-primary">Add new Admin</a>
    </div>
    <div class="card card-small mb-4">
        <div class="card-header bg-light">
            <h6 class="m-0 text-dark">Bloggers</h6>
        </div>
        <div class="card-body p-0 pb-3 text-center">
            <table class="table mb-0">
                <thead class="bg-light">
                <tr>
                    <th scope="col" class="border-0">#</th>
                    <th scope="col" class="border-0">Name</th>
                    <th scope="col" class="border-0">Username</th>
                    <th scope="col" class="border-0">Approved</th>
                    <th scope="col" class="border-0">Action</th>
                </tr>
                </thead>
                <tbody>
                <jsp:useBean id="bloggers" scope="request"
                             type="java.util.List<com.sqh.blog.controller.data.UserData>"/>
                <c:if test="${bloggers.isEmpty()}">
                    <tr>
                        <td colspan="5" class="text-center">
                            No bloggers found!
                        </td>

                    </tr>
                </c:if>
                <c:forEach items="${bloggers}" var="blogger" varStatus="counter">
                    <tr>
                        <td>${counter.index +1}</td>
                        <td>${blogger.fullName}</td>
                        <td>${blogger.username}</td>
                        <td class="align-middle"><input type="checkbox" ${blogger.enabled ? 'checked' : ''} disabled></td>
                        <td>
                            <div class="btn-group btn-group-sm">
                                <c:choose>
                                    <c:when test="${blogger.enabled}">
                                        <a href="/users/enabled/${blogger.id}" class="btn btn-danger">
                                            <span class="text-white"><i class="fa fa-times"
                                                                        aria-hidden="true"></i></span>
                                            Reject
                                        </a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="/users/enabled/${blogger.id}" class="btn btn-white">
                                            <span class="text-success"><i class="fa fa-check"
                                                                          aria-hidden="true"></i></span>
                                            Approve
                                        </a>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <div class="card card-small mb-4">
        <div class="card-header bg-dark">
            <h6 class="m-0 text-white">Admins</h6>
        </div>
        <div class="card-body p-0 pb-3 text-center">
            <table class="table mb-0">
                <thead class="bg-light">
                <tr>
                    <th scope="col" class="border-0">#</th>
                    <th scope="col" class="border-0">Name</th>
                    <th scope="col" class="border-0">Username</th>
                </tr>
                </thead>
                <tbody>
                <jsp:useBean id="admins" scope="request" type="java.util.List<com.sqh.blog.controller.data.UserData>"/>
                <c:forEach items="${admins}" var="admin" varStatus="counter">
                    <tr>
                        <td>${counter.index +1}</td>
                        <td>${admin.fullName}</td>
                        <td>${admin.username}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>

<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>