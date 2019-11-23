<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/products" %>


<jsp:include page="header.jsp"></jsp:include>

<div class="w-100">
    <div class="btn-group w-25 float-right" role="group" aria-label="View Mode">
        <a href="/products/list"><span class="oi oi-list mx-2 my-2"></span></a>
        <a href="/products/grid"><span class="oi oi-grid-three-up mx-2 my-2"></span></a>
        <a href="/products/list"><span class="oi oi-map-marker mx-2 my-2"></span></a>
    </div>
</div>

<div class="container-fluid ${isList == true ? 'flex-fill' : 'd-flex flex-wrap'}">

    <c:forEach items="${productList}" var="product" varStatus="loopStatus">
        <c:choose>
            <c:when test="${isList}">
                <product:productListElement product="${product}"/>
            </c:when>
            <c:otherwise>
                <product:productGridElement product="${product}"/>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>

<jsp:include page="footer.jsp"></jsp:include>