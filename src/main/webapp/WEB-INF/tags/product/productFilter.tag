<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="categories" required="true" type="java.util.List" %>

<div class="border border-light rounded">
    <article class="card-group-item">
        <header class="card-header">
            <h6 class="title">Price range</h6>
        </header>
        <div class="filter-content">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label>Min</label>
                    <input type="number" class="form-control" class="js-filter-price-min" placeholder="0 RON">
                </div>
                <div class="form-group col-md-6">
                    <label>Max</label>
                    <input type="number" class="form-control" class="js-filter-price-max" placeholder="1.0000 RON">
                </div>
            </div>
        </div>
    </article>
    <article class="card-group-item">
        <header class="card-header">
            <h6 class="title">Categories</h6>
        </header>
        <div class="filter-content">
            <c:forEach items="${categories}" var="category">
                <div class="form-check js-toggle-category">
                    <input type="checkbox" value="${category.id}" class="js-filter-category-toggle">
                    <label class="form-check-label" for="exampleCheck1">${category.name}</label>
                </div>
            </c:forEach>
        </div>
    </article>
    <article class="card-group-item">
        <header class="card-header">
            <h6 class="title">Distance range</h6>
        </header>
        <div class="filter-content">
            <div class="card-body">
                <div class="custom-control custom-checkbox">
                    <div class="form-group">
                        <span class="js-distance-filter-value">50 km</span>
                        <input type="range" value="50" min="10" max="100" step="10"
                               class="form-control-range js-change-distance-filter" id="formControlRange">
                    </div>
                </div>
            </div>
        </div>
    </article>
</div>
