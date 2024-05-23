def getBestGroupPrices(rates: Seq[Rate],
                       prices: Seq[CabinPrice]): Seq[BestGroupPrice] = {

  // 1 - converting the list of cabin prices to a list of group prices
  val groupPrices = prices.map(cabinPrice => BestGroupPrice(cabinPrice.cabinCode, cabinPrice.rateCode, cabinPrice.price, rates.find(rate => rate.rateCode == cabinPrice.rateCode).get.rateGroup))

  // 2 - group the group prices by cabin code and rate group for lowest price
  val bestGroupPrices = groupPrices
    .groupBy(groupPrice => (groupPrice.cabinCode, groupPrice.rateGroup))
    .map { case (grouping, priceGroupObjects) => priceGroupObjects.minBy(groupPrice => groupPrice.price) }

  // 3 - keep original ordering - return group prices in the bestGroupPrices list
  groupPrices.filter(groupPrice =>
    bestGroupPrices.exists(best =>
      best.cabinCode == groupPrice.cabinCode
        && best.rateCode == groupPrice.rateCode
        && best.price == groupPrice.price))
}
case class Rate(rateCode: String, rateGroup: String)
case class CabinPrice(cabinCode: String,
                      rateCode: String,
                      price: BigDecimal)
case class BestGroupPrice(cabinCode: String,
                          rateCode: String,
                          price: BigDecimal,
                          rateGroup: String) {
  override def toString: String = {
    val priceFormatted = f"$price%.2f"
    s"BestGroupPrice($cabinCode, $rateCode, $priceFormatted, $rateGroup)"
  }
}