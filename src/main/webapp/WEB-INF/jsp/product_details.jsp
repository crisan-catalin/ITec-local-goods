<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="price" tagdir="/WEB-INF/tags/price" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>

<div class="section section-gray">
    <div class="section-content">
        <div class="product-details">
            <ul class="product-images">
                <li class="preview"><img
                        src="${empty productDetails.pictures ? '/resources/images/default.jpg' : productDetails.pictures[0].path}"
                        alt=""></li>
                <c:if test="${productDetails.pictures.size() > 1}">
                    <c:forEach items="${productDetails.pictures}" var="picture">
                        <li>
                            <a href="javascript:void(0)"><img
                                    src="${picture.path}"
                                    alt=""></a>
                        </li>
                    </c:forEach>
                </c:if>
            </ul>
            <ul class="product-info">
                <li class="product-name">${productDetails.name}</li>
                <li class="product-price">Starting from ${productDetails.priceIntervals[0].price} RON</li>
                <ul class="fields">
                    <li class="field-name">Available stock: ${productDetails.stock} ${productDetails.unitType}'s</li>
                    <c:forEach var="priceInterval" items="${productDetails.priceIntervals}">
                        <li class="field-name">
                            <price:priceInterval priceInterval="${priceInterval}"/>
                        </li>
                    </c:forEach>
                </ul>
                <li class="product-description">
                    <p>${productDetails.description}</p>
                </li>
                <form:form method="post" action="/order-entry/add" modelAttribute="addToCartForm">
                    <form:input type="hidden" id="productId" path="productId" value="${productDetails.id}" required="required"/>
                    <div class="form-group">
                        <label for="quantity">Quantity:</label>
                        <form:input class="form-control w-50" id="quantity" min="1" value="1" path="quantity" required="required"/>
                    </div>
                    <li class="product-addtocart w-50">
                        <button type="submit">Add To Cart</button>
                    </li>
                </form:form>
            </ul>
        </div>
    </div>
</div>

<script src='//production-assets.codepen.io/assets/common/stopExecutionOnTimeout-b2a7b3fe212eaa732349046d8416e00a9dec26eb7fd347590fbced3ab38af52e.js'></script>
<script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>
<script>var Chef = {
    init: function () {
        this.productImagePreview();
        this.menuToggle();
        this.misc();
    },

    productImagePreview: function () {
        $(document).on('click', '.product-images li', function () {
            if (!$(this).hasClass('preview')) {
                var src = $(this).find('img').attr('src');
                $('.product-images .preview img').attr('src', src);
            }
        });
    },

    menuToggle: function () {
        $(document).on('click', '#menu .trigger', function () {
            // Toggle open and close icons
            $(this).find('img').each(function () {
                if ($(this).hasClass('hidden')) {
                    $(this).removeClass('hidden');
                } else {
                    $(this).addClass('hidden');
                }
            });

            // Toggle menu links
            $(this).siblings('.links').stop(true, true).slideToggle(200);

            // Toggle open class
            $('#menu').toggleClass('open');
        });
    },

    misc: function () {
        // Misc stuff

        for (var i = 1; i <= 3; i++) {
            if (window.CP.shouldStopExecution(1)) {
                break;
            }
            $('.product').parent().eq(0).clone().appendTo('.product-list');
        }
        window.CP.exitedLoop(1);

    }
};

$(function () {
    Chef.init();
});
//# sourceURL=pen.js
</script>

<jsp:include page="footer.jsp"></jsp:include>