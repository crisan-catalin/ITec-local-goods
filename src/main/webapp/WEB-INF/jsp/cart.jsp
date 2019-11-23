<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cart" tagdir="/WEB-INF/tags/cart" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid flex-fill">
    <c:choose>
        <c:when test="${empty cartProducts}">
            <div class="text-center">
                <img src="https://wilori.com/uploads/shopping-cart.png"/>
            </div>
        </c:when>
        <c:otherwise>
            <div class="row">
                <div class="col-12 col-md-8 offset-md-2 col-lg-6 offset-lg-3">
                    <div class="panel panel-info">
                        <div class="panel-heading mb-5">
                            <h1>Shopping cart</h1>
                        </div>
                        <form method="post" action="/orders/place">
                            <div class="panel-body">
                                <c:forEach items="${cartProducts}" var="cartElement">
                                    <cart:cartElement cartElement="${cartElement}"/>
                                </c:forEach>
                            </div>
                            <div class="panel-footer align-right">
                                <div class="row">
                                    <div class="col-12">
                                        <h4 class="text-right">Total <strong>${cartTotalPrice}RON</strong></h4>
                                    </div>
                                </div>
                                <div class="row mt-5">
                                    <div class="col-12">
                                        <button type="submit" class="btn btn-success btn-block">
                                            Checkout
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
</div>

<jsp:include page="footer.jsp"></jsp:include>