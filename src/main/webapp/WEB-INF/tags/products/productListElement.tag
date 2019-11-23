<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="product" required="true" type="com.brotech.localgoods.model.Product" %>

<div class="row mb-5">
    <div class="col-12 col-md-8 offset-md-4 col-lg-6 offset-lg-4">
        <div class="product-card p-3 mt-2">
            <div class="row">
                <div class="col-8">
                    <small>
                        <a href="/products/details/${product.id}">#${product.name}</a>
                    </small>
                    <div class="pt-2 d-flex justify-content-between">
                        <div class="d-flex flex-column">
                            <b>Price:</b>
                            <span class="text-right">Starting from ${product.priceIntervals[0].price} RON</span>
                        </div>
                    </div>
                </div>
                <div class="col-4 d-flex align-items-center">
                    <a href="/product/details/${product.id}">
                        <button type="button"
                                class="btn btn-primary product-remove mr-3 js-product-remove">
                            <i class="fa fa-info" aria-hidden="true"></i> Product details
                        </button>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>