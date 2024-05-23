case class Promotion(code: String, notCombinableWith: Seq[String])
case class PromotionCombo(promotionCodes: Seq[String])
def allCombinablePromotions(allPromotions: Seq[Promotion]): Seq[PromotionCombo]
= {
  return Seq()
}

def combinablePromotions(
                          promotionCode: String,
                          allPromotions: Seq[Promotion]): Seq[PromotionCombo] = {
  return Seq()
}

def makeUpList(size: Int): List[Int] = {
  var sequence = Seq()
  for (i <- 0 to size) {
    sequence ::: i
    //list = list.concat(i)
  }
  return sequence.toList
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


/*def combinePromotionsByIndex(index: Int, combinedPromotions: PromotionCombo, allPromotions: Seq[Promotion]): Unit = {
  if (index > allPromotions.length) {
    return
  }
  if (combinedPromotions.promotionCodes.isEmpty) {
    var combo = combinedPromotions.promotionCodes.concat(allPromotions.apply(index).code)
  }
  return
}*/

