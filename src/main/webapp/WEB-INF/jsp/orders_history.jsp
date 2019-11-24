<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid flex-fill order-list-background-left">
    <div class="container h-100">
        <h1>Orders history</h1>
        <hr/>
        <c:choose>
            <c:when test="${empty orders}">
                <div class="text-center">
                    <img src="https://cdn.dribbble.com/users/2382015/screenshots/6065978/no_result.gif"/>
                </div>
            </c:when>
            <c:otherwise>
                <table class="table table-hover mt-5">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Address</th>
                        <th>Price</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${orders}" var="order">
                        <tr class="table table-striped">
                            <td><a href="/orders/details/${order.id}">${order.id}</a></td>
                            <td>${order.deliveryAddress.city} ${order.deliveryAddress.street} ${order.deliveryAddress.number}</td>
                            <td>${order.totalPrice}</td>
                            <td class="text-center font-weight-bold ${order.deliveryStatus eq 'PROCESSING' ? 'bg-info' : (order.deliveryStatus eq 'READY_TO_SHIP' ? 'table-warning' : 'table-success')}">${order.deliveryStatus}</td>
                            <td>
                                <a class="btn ${order.deliveryStatus eq 'PROCESSING' ? 'btn-outline-primary' : (order.deliveryStatus eq 'READY_TO_SHIP' ? 'btn-outline-warning' : 'btn-outline-success')}"
                                   href="/orders/details/${order.id}">Details</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>