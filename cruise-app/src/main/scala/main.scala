val M1: String = "M1"
val M2: String = "M2"
val Military: String = "Military"
val S1: String = "S1"
val S2: String = "S2"
val Senior: String = "Senior"
val CA: String = "CA"
val CB: String = "CB"
val P1: String = "P1"
val P2: String = "P2"
val P3: String = "P3"
val P4: String = "P4"
val P5: String = "P5"

@main
def main(): Unit = {
  println("Hello world, first to find the best price for each rate group!")
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
  var bestPriceResult = getBestGroupPrices(rates, cabinPrices)
  for (bestGroupPrice <- bestPriceResult) {
    println(bestGroupPrice)
  }

  println("==================================================")
  println("Now finding list of combinable promotions.")

  var rules = Seq(
    Promotion(P1, Seq(P3)), // P1 is not combinable with P3
    Promotion(P2, Seq(P4, P5)), // P2 is not combinable with P4 and P5
    Promotion(P3, Seq(P1)), // P3 is not combinable with P1
    Promotion(P4, Seq(P2)), // P4 is not combinable with P2
    Promotion(P5, Seq(P2)) // P5 is not combinable with P2
  )

  var promotionsResult = allCombinablePromotions(rules)
  println(promotionsResult)

}
/*
def combinations[T](list: List[T], k: Int): List[List[T]] = {
  if (k == 0) List(Nil) // Base case: If k is 0, return a list containing an empty list
  else if (list.isEmpty) Nil // Base case: If the input list is empty, return an empty list
  else {
    // Recursive step:
    // Either include the head element in the combination and find combinations for the rest of the list,
    // or exclude the head element and find combinations for the rest of the list.
    combinations(list.tail, k - 1).map(list.head :: _) ++ combinations(list.tail, k)
  }
}
 */



