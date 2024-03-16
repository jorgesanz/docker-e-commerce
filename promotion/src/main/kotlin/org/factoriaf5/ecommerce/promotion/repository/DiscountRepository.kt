package org.factoriaf5.ecommerce.promotion.repository

import java.math.BigDecimal
import kotlin.random.Random
import org.factoriaf5.ecommerce.promotion.domain.Discount
import org.factoriaf5.ecommerce.promotion.domain.DiscountType
import org.factoriaf5.ecommerce.promotion.domain.ItemDiscounts
import org.springframework.stereotype.Repository
import java.math.RoundingMode

@Repository
class DiscountRepository {

  private val randomDiscounts = initializeDiscounts()

  fun getDiscounts(itemId: String): ItemDiscounts {
    return ItemDiscounts(itemId, randomDiscounts[Random.nextInt(9)])
  }

  private fun initializeDiscounts(): List<Discount> =
      (1..10).map {
        Discount(
                BigDecimal.valueOf(Random.nextDouble(10.0)).setScale(2, RoundingMode.HALF_UP),
                if (it > 4) DiscountType.AMOUNT else DiscountType.PERCENTAGE)
      }
}
