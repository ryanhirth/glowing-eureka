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