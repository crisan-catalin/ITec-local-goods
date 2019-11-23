<%@ attribute name="priceInterval" required="true" type="com.brotech.localgoods.model.PriceInterval" %>

<p>From ${priceInterval.intervalMin} to ${priceInterval.intervalMax} : ${priceInterval.price} RON</p>