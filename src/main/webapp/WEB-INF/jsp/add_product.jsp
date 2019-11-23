<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="formm" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col-12">
            <h1>Add new product</h1>
            <form:form method="post" action="/products/add" modelAttribute="CreateProductForm" enctype="multipart/form-data">
                <div class="form-group">
                    <label>Title</label>
                    <form:input type="text" class="form-control" path="title"/>
                </div>

                <div class="form-group">
                    <label>Description</label>
                    <form:textarea cssClass="form-control" path="description"/>
                </div>

                <div class="form-group">
                    <label>Category</label>
                    <form:select class="form-control" formcontrolname="category" path="categoryId">
                        <c:forEach var="supercategory_entry" items="${categories_grouped}">
                            <optgroup label="${supercategory_entry.key.name}">
                                <c:forEach var="category" items="${supercategory_entry.value}">
                                    <form:option value="${category.id}">${category.name}</form:option>
                                </c:forEach>
                            </optgroup>
                        </c:forEach>
                    </form:select>
                </div>

                <div class="form-group">
                    <label>Choose unit of the product</label>
                    <form:select class="form-control" formcontrolname="category" path="unitType">
                        <c:forEach var="unit_type" items="${product_units}">
                            <form:option value="${unit_type}">${unit_type}</form:option>
                        </c:forEach>
                    </form:select>
                </div>

                <div class="form-group">
                    <label>Stock units</label>
                    <form:input type="text" class="form-control" path="stock"/>
                </div>

                <div>
                    <label>Price intervals</label>
                    <div class="js-add-price-interval-container">
                        <div class="row align-items-end">
                            <div class="form-group col-3">
                                <label>From</label> <input name="priceIntervals[0].intervalMin" required type="text"
                                                           class="form-control" placeholder="1 unit">
                            </div>
                            <div class="form-group col-3">
                                <label>to</label> <input name="priceIntervals[0].intervalMax" required type="text"
                                                         class="form-control" placeholder="20 units">
                            </div>
                            <div class="form-group col-3">
                                <label>price is</label> <input name="priceIntervals[0].price" required type="text"
                                                               class="form-control" placeholder="35 RON">
                            </div>
                            <div class="form-group col-3">
                                <button class="js-add-price-interval-button btn btn-info">Add price interval</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div>
                    <label>Photos</label>
                    <div class="row">
                        <div>
                            <input type="file" multiple class="js-add-product btn" name="files"/>
                        </div>
                        <div class="js-product-gallery row col-12 pt-2">
                        </div>
                    </div>
                </div>
                <div class="pt-2">
                    <button type="submit" class="btn btn-success btn-lg btn-block">Confirm</button>
                </div>
            </form:form>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>