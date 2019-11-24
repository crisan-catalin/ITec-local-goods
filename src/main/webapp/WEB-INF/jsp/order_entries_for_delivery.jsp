<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid flex-fill order-list-background-left">
    <div class="container h-100">
        <h1>Orders to be delivered</h1>
        <c:choose>
            <c:when test="${empty orderEntries}">
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
                        <th>Total price</th>
                        <th>Status</th>
                        <th>Switch status</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${orderEntries}" var="entry">
                        <tr class="table table-striped">
                            <td><a href="/orders/details/${entry.order.id}">${entry.order.id}</a></td>
                            <td>${entry.order.deliveryAddress.city} ${entry.order.deliveryAddress.street} ${entry.order.deliveryAddress.number}</td>
                            <td>${entry.order.totalPrice}</td>
                            <td>${entry.deliveryStatus}</td>
                            <td>
                                <form method="post" action="">
                                    <div class="btn-group" role="group">
                                        <button type="submit" formaction="/orders/changeStatus/${entry.id}/PROCESSING"
                                                class="btn ${entry.deliveryStatus == 'PROCESSING' ?'btn-secondary' : 'btn-info'}" ${entry.deliveryStatus == 'PROCESSING' ?'disabled="disabled"' : ''}>
                                            PROCESSING
                                        </button>
                                        <button type="submit"
                                                formaction="/orders/changeStatus/${entry.id}/READY_TO_SHIP"
                                                class="btn ${entry.deliveryStatus == 'READY_TO_SHIP' ?'btn-warning' : 'btn-warning'}" ${entry.deliveryStatus == 'READY_TO_SHIP' ?'disabled="disabled"' : ''}>
                                            READY TO SHIP
                                        </button>
                                        <button type="submit" formaction="/orders/changeStatus/${entry.id}/DELIVERED"
                                                class="btn ${entry.deliveryStatus == 'DELIVERED' ?'btn-warning' : 'btn-primary'}" ${entry.deliveryStatus == 'DELIVERED' ?'disabled="disabled"' : ''}>
                                            DELIVERED
                                        </button>
                                    </div>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>