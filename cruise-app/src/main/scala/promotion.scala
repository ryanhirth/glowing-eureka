import scala.collection.mutable.ListBuffer

case class Promotion(code: String, notCombinableWith: Seq[String])
case class PromotionCombo(promotionCodes: Seq[String])
def allPromotionPermutations(allPromotions: Seq[Promotion]): ListBuffer[Seq[String]] = {
  // 1 - create a numbered list for the amount of promotions
  // (ex: for 5 promotions List(0,1,2,3,4) )
  var list = allPromotions.indices.toList //makeUpList(allPromotions.length)

  // 2 - get all permutations for all the different orders that these promotions can be applied
  var promotionOrders = permutations(list)

  // 3 - for each permutation, going through each list in order, remove promotions that can't be combined
  var promotionCombos = ListBuffer[Seq[String]]()
  for (promotionOrder <- promotionOrders) {
    var promotionComboStrings = ListBuffer[String]()
    for (index <- promotionOrder) {
      var code = allPromotions.apply(index).code
      var notCombinable = allPromotions.apply(index).notCombinableWith
      if (!promotionComboStrings.exists(notCombinable.contains)) {
        // As long as a promotion in the not combinable list has not been applied this promotion can be added
        promotionComboStrings += code
      }
    }
    promotionCombos += promotionComboStrings.toSeq
  }
  return promotionCombos
}
def allCombinablePromotions(allPromotions: Seq[Promotion]): Seq[PromotionCombo]
= {
  var promotionPermutations = allPromotionPermutations(allPromotions)
  // order list and get distinct list without duplicates
  var allSortedWithoutDuplicates = promotionPermutations.map(c => c.sorted).distinct
  return allSortedWithoutDuplicates.map(list => PromotionCombo(list)).toSeq
}

def combinablePromotions(
                          promotionCode: String,
                          allPromotions: Seq[Promotion]): Seq[PromotionCombo] = {
  var promotionPermutations = allPromotionPermutations(allPromotions)
  var permutationsThatStartWithPromoCode = promotionPermutations
    .filter(p => p.head == promotionCode)
    .map(c => c.head +: c.tail.sorted)
    .distinct

  return permutationsThatStartWithPromoCode.map(list => PromotionCombo(list)).toSeq
}

def permutations(list: List[Int]): List[List[Int]] = {
  if (list.isEmpty) {
    List(Nil)
  }
  else {
    list.indices.flatMap { i=>
      val (before, after) = list.splitAt(i)
      val restOfList = before ::: after.tail
      permutations(restOfList).map(list(i) :: _)
    }.toList
  }
}


