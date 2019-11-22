<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp"></jsp:include>

<div class="container flex-fill">

    <div class="row h-100">
        <div class="col"></div>

        <div class="col-5 my-auto">
            <div class="card bg-light">
                <div class="card-body">
                    <form:form method="post" action="/register" modelAttribute="registerForm">
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <form:input class="form-control" id="name" path="name" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="name">Phone:</label>
                            <form:input class="form-control" id="phone" path="phone" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="name">City:</label>
                            <form:input type="text" class="form-control" id="city" path="address.city"
                                        required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="name">Street:</label>
                            <form:input type="text" class="form-control" id="street" path="address.street"
                                        required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="name">Number:</label>
                            <form:input type="text" class="form-control" id="number" path="address.number"
                                        required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <form:input type="text" class="form-control" id="email" path="email" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <form:password class="form-control" id="password" path="password" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="isSeller">Activity type:</label>
                            <form:select class="form-control" id="isSeller" path="isSeller">
                                <form:option value="true">Seller</form:option>
                                <form:option value="false">Buyer</form:option>
                            </form:select>
                        </div>
                        <div class="form-group">
                            <label for="type">Collaborate with:</label>
                            <form:select class="form-control" id="type" path="type">
                                <form:option value="PRIVATE">Locals</form:option>
                                <form:option value="COMPANY">Companies</form:option>
                            </form:select>
                        </div>
                        <c:if test="${not empty infoMessage}">
                            <div class="form-group alert alert-info">
                                    ${infoMessage}
                            </div>
                        </c:if>
                        <c:if test="${not empty errorMessage}">
                            <div class="form-group alert alert-danger">
                                    ${errorMessage}
                            </div>
                        </c:if>
                        <button type="submit" class="btn btn-primary col-12">Register</button>
                    </form:form>
                </div>
            </div>
        </div>

        <div class="col"></div>
    </div>

</div>

<jsp:include page="footer.jsp"></jsp:include>