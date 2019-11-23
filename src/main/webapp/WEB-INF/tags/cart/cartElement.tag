<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="cartElement" required="true" type="com.brotech.localgoods.model.Product" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="product" required="true" type="com.brotech.localgoods.model.Product" %>

<div class="row mb-5">
    <div class="col-12 col-md-8 offset-md-4 col-lg-6 offset-lg-4">
        <div class="product-card p-3 mt-2">
            <div class="row">
                <div class="col-8">
                    <b>#${product.name}</b>
                    <div class="pt-2 d-flex justify-content-between">
                        <div class="d-flex flex-column">
                            <span class="text-right">starting from ${product.priceIntervals[0].price} RON</span>
                        </div>
                    </div>
                </div>
                <div class="col-4 d-flex align-items-center">
                    <a href="/products/details/${product.id}">
                        <button type="button" class="btn btn-info">Details</button>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>