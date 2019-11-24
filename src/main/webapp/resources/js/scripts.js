mapboxgl.accessToken = 'pk.eyJ1IjoidG9tYXN6amF3b3Jza2kiLCJhIjoiY2p3YWQ1Y3dqMDhweDQ4bGpqcjl6c3JvbCJ9.OGdxKDPgRO5Oswfl-jNfAQ';
var map = new mapboxgl.Map({
    container: 'map',
    style: 'mapbox://styles/mapbox/streets-v11',
    center: [21.017532, 52.237049],
    zoom: 10
});

// add marker to map
new mapboxgl.Marker()
    .setLngLat([21.017532, 52.237049])
    .addTo(map);

var MAX_PRICE_INTERVALS = 5;
var PRICE_INTERVAL_INDEX = 1;
$(".js-add-price-interval-button").click(function (e) {
    e.preventDefault();
    if (PRICE_INTERVAL_INDEX < MAX_PRICE_INTERVALS) {
        $(".js-add-price-interval-container")
            .append(
                '<div class="row align-items-end"><div class="form-group col-3"><label>From</label> <input name="priceIntervals['
                + PRICE_INTERVAL_INDEX
                + '].intervalMin" type="text" class="form-control" placeholder="X units"></div><div class="form-group col-3"><label>to</label> <input name="priceIntervals['
                + PRICE_INTERVAL_INDEX
                + '].intervalMax" type="text" class="form-control" placeholder="Y units"></div><div class="form-group col-3"><label>price is</label> <input name="priceIntervals['
                + PRICE_INTERVAL_INDEX
                + '].price" type="text" class="form-control" placeholder="Z RON">\</div><div class="form-group col-3"><a href="#" class="js-delete-price-interval-button">Remove</a></div></div>');
        PRICE_INTERVAL_INDEX++;
    } else {
        alert('You reached the limits');
    }
});

$(".js-add-price-interval-container").on("click", ".js-delete-price-interval-button", function (e) {
    e.preventDefault();
    $(this).closest('div.row').remove();
    PRICE_INTERVAL_INDEX--;
});

var imagesPreview = function (input) {
    if (input.files) {
        var filesAmount = input.files.length;
        for (i = 0; i < filesAmount; i++) {
            var reader = new FileReader();
            reader.onload = function (event) {
                var img = $($.parseHTML('<img>')).attr('class', 'col-3 img-thumbnail mx-2 mb-2').attr('src',
                    event.target.result);

                $('.js-product-gallery').append(img);
            };
            reader.readAsDataURL(input.files[i]);
        }
    }
};

$('.js-add-product').on('change', function () {
    imagesPreview(this);
});

$('.js-change-distance-filter').on('change', function (e) {
    var rangeValue = e.target.value;
    var unit = rangeValue >= 100 ? " km+" : " km";
    $('.js-distance-filter-value').text(rangeValue + unit);
});