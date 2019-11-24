<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="product" required="true" type="com.brotech.localgoods.model.Product" %>

<div class="row mb-5 mr-5 border-bottom border-secondary">
    <div class="col-12">
        <div class="product-card py-3 mt-2">
            <div class="row">
                <div class="col-sm-2">
                    <div class="d-flex justify-content-center align-items-center">
                        <img src="https://placehold.it/100x100" alt="" class="rounded img-responsive">
                    </div>
                </div>
                <div class="col-6">
                    <b>#${product.name}</b>
                    <div class="pt-2 d-flex justify-content-between">
                        <div class="d-flex flex-column">
                            <span class="text-right">starting from ${product.priceIntervals[0].price} RON</span>
                            <a href="/user/${product.user.id}">
                                <span class="text-right">selled by ${product.user.name}</span>
                            </a>
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