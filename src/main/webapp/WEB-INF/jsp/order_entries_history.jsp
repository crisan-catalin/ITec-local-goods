<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid flex-fill order-list-background-left">
    <div class="container h-100">
        <h1>History of delivers</h1>
        <table class="table table-hover mt-5">
            <thead>
            <tr>
                <th>Product ID</th>
                <th>Product</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total price</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orderEntries}" var="entry">
                <tr class="table table-striped">
                    <td><a href="/products/details/${entry.product.id}">${entry.product.id}</a></td>
                    <td>${entry.product.name}</td>
                    <td>${entry.totalPrice/entry.quantity}</td>
                    <td>${entry.quantity}</td>
                    <td>${entry.totalPrice}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>