<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/product" %>


<jsp:include page="header.jsp"></jsp:include>

<div class="w-100">
    <div class="btn-group w-25 float-right" role="group" aria-label="View Mode">
        <a href="/products/list"><span class="oi oi-list mx-2 my-2"></span></a>
        <a href="/products/grid"><span class="oi oi-grid-three-up mx-2 my-2"></span></a>
        <a href="/products/map"><span class="oi oi-map-marker mx-2 my-2"></span></a>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-4">
            <product:productFilter categories="${subcategories}"/>
        </div>
        <div class="col  ${page_view_mode == 'GRID' ? 'd-flex flex-wrap':''}">
            <c:forEach items="${productList}" var="product" varStatus="loopStatus">
                <c:choose>
                    <c:when test="${page_view_mode == 'LIST'}">
                        <product:productListElement product="${product}"/>
                    </c:when>
                    <c:when test="${page_view_mode == 'GRID'}">
                        <product:productGridElement product="${product}"/>
                    </c:when>
                    <c:otherwise>
                        <product:productMapElement product="${product}"/>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>