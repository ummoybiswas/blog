<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../common/head.jsp"></jsp:include>
    <title>Blog</title>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col-12">
            <h3 class="mt-4">Add new post</h3>
            <form:form method="POST" modelAttribute="postForm">
                <spring:bind path="title">
                    <div class="form-group">
                        <form:input type="text" path="title" class="form-control ${status.error ? 'is-invalid' : ''}"
                                    placeholder="Title"
                                    autofocus="true"></form:input>
                        <div class="invalid-feedback">
                            <form:errors path="title"></form:errors>
                        </div>
                    </div>
                </spring:bind>
                <spring:bind path="text">
                    <div class="form-group">
                        <form:textarea path="text" class="form-control ${status.error ? 'is-invalid' : ''}"
                                       placeholder="Description" rows="10" cols="3"
                                       autofocus="true"></form:textarea>
                        <div class="invalid-feedback">
                            <form:errors path="text"></form:errors>
                        </div>
                    </div>
                </spring:bind>
                <button type="submit" class="btn btn-primary mb-2">Submit</button>
            </form:form>
        </div>
    </div>
</div>

<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>