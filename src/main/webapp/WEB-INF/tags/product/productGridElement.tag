<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="product" required="true" type="com.brotech.localgoods.model.Product" %>

<div style="width: 350px;" class="card border-primary mx-5 my-5 shadow p-3 mb-5 bg-white">
    <c:choose>
        <c:when test="${empty product.pictures}">
            <img class="card-img-top" src="/resources/images/default.jpg" alt="product image cap">
        </c:when>
        <c:otherwise>
            <img class="card-img-top" src="data:image/jpeg;base64,${product.pictures[0].content}" alt="product image cap">
        </c:otherwise>
    </c:choose>
    <div class="card-body">
        <h3 class="card-title">#${product.name}</h3>
        <p class="card-text">
            <span class="text-right">Starting from ${product.priceIntervals[0].price} RON</span>
        </p>
        <a href="/user/${product.user.id}">
            <span class="text-right">selled by ${product.user.name}</span>
        </a>
        <a href="/products/details/${product.id}">
            <button type="button" class="btn btn-info w-100">Details</button>
        </a>
    </div>
</div>
