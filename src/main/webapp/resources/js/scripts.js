var MAX_PRICE_INTERVALS = 5;
var PRICE_INTERVAL_INDEX = 0;
$(".js-add-price-interval-button").click(function (e) {
    e.preventDefault();
    if (PRICE_INTERVAL_INDEX < MAX_PRICE_INTERVALS) {
        PRICE_INTERVAL_INDEX++;
        $(".js-add-price-interval-container")
            .append('<div class="row align-items-end"><div class="form-group col-3"><label>From</label> <input type="text" class="form-control" placeholder="X units"></div><div class="form-group col-3"><label>to</label> <input type="text" class="form-control" placeholder="Y units"></div><div class="form-group col-3"><label>price is</label> <input type="text" class="form-control" placeholder="Z RON">\</div><div class="form-group col-3"><a href="#" class="js-delete-price-interval-button">Remove</a></div></div>');
    } else {
        alert('You reached the limits');
    }
});

$(".js-add-price-interval-container").on("click", ".js-delete-price-interval-button", function (e) {
    e.preventDefault();
    $(this).closest('div.row').remove();
    PRICE_INTERVAL_INDEX--;
});

var imagesPreview = function(input) {
    if (input.files) {
        var filesAmount = input.files.length;
        for (i = 0; i < filesAmount; i++) {
            var reader = new FileReader();
            reader.onload = function(event) {
                var img = $($.parseHTML('<img>')).attr('class','col-3 img-thumbnail mx-2 mb-2').attr('src', event.target.result);

                $('.js-product-gallery').append(img);
            };
            reader.readAsDataURL(input.files[i]);
        }
    }
};

$('.js-add-product').on('change', function() {
    imagesPreview(this);
});

