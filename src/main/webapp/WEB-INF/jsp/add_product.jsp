<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col-12">
            <h1>Add new product</h1>
            <form [formgroup]="adForm" (ngsubmit)="onSendAd()">

                <div class="form-group">
                    <label>Title</label>
                    <input type="text" class="form-control" formcontrolname="title" value="">
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading">Description</div>
                    <textarea class="form-control" rows="5" [spellcheck]="false" formcontrolname="description"
                              value="{{ad?.description}}"></textarea>
                </div>

                <div class="form-group">
                    <label>Category</label>
                    <select class="form-control" formcontrolname="category">
                        <c:forEach var="supercategory_entry" items="${categories_grouped}">
                            <optgroup label="${supercategory_entry.key.name}">
                                <c:forEach var="category" items="${supercategory_entry.value}">
                                    <option value="${category.id}">${category.name}</option>
                                </c:forEach>
                            </optgroup>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label>Choose unit of the product</label>
                    <select class="form-control" formcontrolname="category">
                        <c:forEach var="unit_type" items="${product_units}">
                            <option value="${unit_type}">${unit_type}</option>
                        </c:forEach>
                    </select>
                </div>

                <div>
                    <label>Price intervals</label>
                    <div class="js-add-price-interval-container">
                        <div class="row align-items-end">
                            <div class="form-group col-3">
                                <label>From</label> <input type="text" class="form-control" placeholder="1 unit">
                            </div>
                            <div class="form-group col-3">
                                <label>to</label> <input type="text" class="form-control" placeholder="20 units">
                            </div>
                            <div class="form-group col-3">
                                <label>price is</label> <input type="text" class="form-control" placeholder="35 RON">
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
                            <input type="file" multiple class="js-add-product btn"/>
                        </div>
                        <div class="js-product-gallery row col-12 pt-2">
                        </div>
                    </div>
                </div>
                <div class="pt-2">
                    <button class="btn btn-success btn-lg btn-block">Confirm</button>
                </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>