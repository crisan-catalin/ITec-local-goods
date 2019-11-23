<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cart" tagdir="/WEB-INF/tags/cart" %>


<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid flex-fill">
    <c:forEach items="${cartProducts}" var="cartElement">
                <cart:cartElement product="${cartElement}"/>
    </c:forEach>
</div>

<jsp:include page="footer.jsp"></jsp:include>