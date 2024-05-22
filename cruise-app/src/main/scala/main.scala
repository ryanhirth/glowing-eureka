val M1: String = "M1"
val M2: String = "M2"
val Military: String = "Military"
val S1: String = "S1"
val S2: String = "S2"
val Senior: String = "Senior"
val CA: String = "CA"
val CB: String = "CB"

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
  var result = getBestGroupPrices(rates, cabinPrices)
  for (bestGroupPrice <- result) {
    println(bestGroupPrice)
  }
}

