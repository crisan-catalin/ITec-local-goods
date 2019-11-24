<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp"/>

<div class="flex-fill p-3 mt-2">
    <div class="row">
        <div class="col-8 offset-2">
            <div class="customer-details-block border-bottom pb-4">
                <b>Customer</b>

                <c:set var="customerDetails" value="${orderDetails.customer}"/>
                <c:set var="customerAddress" value="${customerDetails.address}"/>

                <div class="customer-details-block--properties">
                    <div>Name: ${customerDetails.name}</div>
                    <div>Phone number: ${customerDetails.phone}</div>
                    <div>Address: ${customerAddress.city},
                        str. ${customerAddress.street},
                        nr. ${customerAddress.number}</div>
                </div>
            </div>

            <c:forEach items="${orderDetails.orderEntries}" var="entry">
                <div class="pl-4 py-1 mb-4">
                    <div class="order-entry-block pb-2 mt-4">
                        <b>Product:</b>
                        <div class="order-entry-block--properties">
                            <div>${entry.product.name}
                                <small>(Qty x ${entry.quantity})</small>
                            </div>
                            <div class="d-flex justify-content-between">
                                <span>Price: ${entry.product.priceIntervals[0].price} RON</span>
                            </div>
                        </div>
                    </div>
                    <div class="pt-2"><b>Seller:</b> ${entry.product.user.name}#${entry.product.user.id}</div>
                </div>
            </c:forEach>
            <div class="border-top pt-4">
                <div class="row">
                    <div class="col-6">
                        <b>Total price:</b>
                        <span class="text-right">${orderDetails.totalPrice} RON</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>