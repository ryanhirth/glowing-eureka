import org.scalatest.funsuite.AnyFunSuite
class mainTest extends AnyFunSuite {

  test("Get lowest price for each rate group") {
    var rates = Seq(
      Rate(M1, Military),
      Rate(M2, Military),
      Rate(S1, Senior),
      Rate(S2, Senior)
    )
    var cabinPrices = Seq(
      CabinPrice(CA, M1, 200.00),
      CabinPrice(CA, S1, 225.00),
      CabinPrice(CA, M2, 250.00),
      CabinPrice(CA, S2, 260.00),
      CabinPrice(CB, M1, 230.00),
      CabinPrice(CB, M2, 260.00),
      CabinPrice(CB, S1, 245.00),
      CabinPrice(CB, S2, 270.00)
    )
    var expectedOutput = Seq(
      BestGroupPrice(CA, M1, 200.00, Military),
      BestGroupPrice(CA, S1, 225.00, Senior),
      BestGroupPrice(CB, M1, 230.00, Military),
      BestGroupPrice(CB, S1, 245.00, Senior)
    )
    val result = getBestGroupPrices(rates, cabinPrices)
    assert(result == expectedOutput)
  }

  test("Get All Combinable Promotions") {
    var rules = Seq(
      Promotion(P1, Seq(P3)), // P1 is not combinable with P3
      Promotion(P2, Seq(P4, P5)), // P2 is not combinable with P4 and P5
      Promotion(P3, Seq(P1)), // P3 is not combinable with P1
      Promotion(P4, Seq(P2)), // P4 is not combinable with P2
      Promotion(P5, Seq(P2)) // P5 is not combinable with P2
    )

    var expectedOutput = Seq(
      PromotionCombo(Seq(P1, P2)),
      PromotionCombo(Seq(P1, P4, P5)),
      PromotionCombo(Seq(P2, P3)),
      PromotionCombo(Seq(P3, P4, P5))
    )

    var result = allCombinablePromotions(rules)
    assert(result == expectedOutput)
  }

  test("Get All Promotions that can be used with P1") {
    var rules = Seq(
      Promotion(P1, Seq(P3)), // P1 is not combinable with P3
      Promotion(P2, Seq(P4, P5)), // P2 is not combinable with P4 and P5
      Promotion(P3, Seq(P1)), // P3 is not combinable with P1
      Promotion(P4, Seq(P2)), // P4 is not combinable with P2
      Promotion(P5, Seq(P2)) // P5 is not combinable with P2
    )

    var expectedOutput = Seq(
      PromotionCombo(Seq(P1, P2)),
      PromotionCombo(Seq(P1, P4, P5))
    )

    var result = combinablePromotions(P1, rules)
    assert(result == expectedOutput)
  }

  test("Get All Promotions that can be used with P3") {
    var rules = Seq(
      Promotion(P1, Seq(P3)), // P1 is not combinable with P3
      Promotion(P2, Seq(P4, P5)), // P2 is not combinable with P4 and P5
      Promotion(P3, Seq(P1)), // P3 is not combinable with P1
      Promotion(P4, Seq(P2)), // P4 is not combinable with P2
      Promotion(P5, Seq(P2)) // P5 is not combinable with P2
    )

    var expectedOutput = Seq(
      PromotionCombo(Seq(P3, P2)),
      PromotionCombo(Seq(P3, P4, P5))
    )

    var result = combinablePromotions(P3, rules)
    assert(result == expectedOutput)
  }
}