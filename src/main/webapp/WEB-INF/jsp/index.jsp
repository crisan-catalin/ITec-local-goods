<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<jsp:include page="header.jsp"></jsp:include>

<c:if test="${not empty sessionUser.isSeller}">
    <div class="pricing-header px-3 pb-md-4 mx-auto text-center">
        <c:choose>
            <c:when test="${sessionUser.isSeller}">
                <h1 class="display-4">Wanna sell something? You are welcome!</h1>
            </c:when>
            <c:otherwise>
                <h1 class="display-4">Wanna buy something? You are welcome!</h1>
            </c:otherwise>
        </c:choose>
    </div>
</c:if>

<div class="flex-fill homepage-background"></div>

<jsp:include page="footer.jsp"></jsp:include>