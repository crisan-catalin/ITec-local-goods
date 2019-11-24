<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/product" %>

<jsp:include page="header.jsp"></jsp:include>

<div class="container flex-fill">
    <div class="row my-4">
        <div class="col-sm-6 col-md-2 ">
            <div class="d-flex justify-content-center align-items-center">
                <img src="https://placehold.it/100x100" alt="" class="rounded img-responsive">
            </div>
        </div>
        <div class="col-sm-6 col-md-8">
            <h4>${userDetails.name}</h4>
            <small>
                <cite> ${userDetails.address.street}, ${userDetails.address.city} <span
                        class="oi oi-location"></span> </cite>
            </small>
            <p>
                <span class="oi oi-envelope-closed"></span> ${userDetails.email}
                <br>
                <span class="oi oi-phone"></span> ${userDetails.phone}</a>
                <br>
            </p>
        </div>
    </div>
    <c:forEach items="${userDetails.products}" var="product" varStatus="loopStatus">
        <div class="row">
            <div class="col-7 offset-2">
                <product:productListElement product="${product}"/>
            </div>
        </div>
    </c:forEach>
</div>

<jsp:include page="footer.jsp"></jsp:include>