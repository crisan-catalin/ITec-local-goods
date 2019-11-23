<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/products" %>


<jsp:include page="header.jsp"></jsp:include>

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