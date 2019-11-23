<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cart" tagdir="/WEB-INF/tags/cart" %>


<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid flex-fill">
    <div class="row">
        <div class="col-12">
            <div class="panel panel-info">
                <div class="panel-heading mb-5">
                    <h1>Shopping cart</h1>
                </div>
                <div class="panel-body">
                    <c:forEach items="${cartProducts}" var="cartElement">
                        <cart:cartElement product="${cartElement}"/>
                    </c:forEach>
                </div>
                <div class="panel-footer align-right">
                    <div class="row">
                        <div class="col-12">
                            <h4 class="text-right">Total <strong>$50.00</strong></h4>
                        </div>
                    </div>
                    <div class="row mt-5">
                        <div class="col-12">
                            <button type="button" class="btn btn-success btn-block">
                                Checkout
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>