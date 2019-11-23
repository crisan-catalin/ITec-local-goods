<div class="border border-light rounded">
    <article class="card-group-item">
        <header class="card-header">
            <h6 class="title">Price range</h6>
        </header>
        <div class="filter-content">
            <div class="card-body">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>Min</label>
                        <input type="number" class="form-control" id="inputEmail4" placeholder="0 RON">
                    </div>
                    <div class="form-group col-md-6">
                        <label>Max</label>
                        <input type="number" class="form-control" placeholder="1.0000 RON">
                    </div>
                </div>
            </div>
        </div>
    </article>
    <article class="card-group-item">
        <header class="card-header">
            <h6 class="title">Categories</h6>
        </header>
        <div class="filter-content">
            <div class="card-body form-check">
                <input type="checkbox">
                <label class="form-check-label" for="exampleCheck1">Check me out</label>
            </div>
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
