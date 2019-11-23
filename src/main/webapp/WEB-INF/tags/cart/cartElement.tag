<%@ attribute name="product" required="true" type="com.brotech.localgoods.dto.CartElementDto" %>

<div class="row">
    <div class="col-3"><img class="img-responsive" src="https://placehold.it/100x70">
    </div>
    <div class="col-4">
        <h4 class="product-name"><strong>${product.productName}</strong></h4>
    </div>
    <div class="col-5">
        <div class="col-xs-6 text-right">
            <h6><strong>${product.totalPrice} <span class="text-muted">x</span></strong></h6>
        </div>
        <div class="col-xs-4">
            <input type="text" class="form-control input-sm" readonly value="${product.quantity}">
        </div>
        <div class="col-xs-2 text-right">
            <button type="button" class="btn btn-link btn-xs text-danger">
                <span class="glyphicon glyphicon-trash">Remove</span>
            </button>
        </div>
    </div>
</div>
<hr>