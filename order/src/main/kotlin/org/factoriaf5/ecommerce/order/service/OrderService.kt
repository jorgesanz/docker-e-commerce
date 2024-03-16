package org.factoriaf5.ecommerce.order.service

import org.factoriaf5.ecommerce.order.domain.Order
import org.factoriaf5.ecommerce.order.repository.DiscountRepository
import org.factoriaf5.ecommerce.order.repository.ItemRepository
import org.factoriaf5.ecommerce.order.domain.CartItemDiscounts
import org.factoriaf5.ecommerce.order.domain.Item
import org.factoriaf5.ecommerce.promotion.domain.Discount
import org.factoriaf5.ecommerce.promotion.domain.DiscountType
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode


@Service
class OrderService(val discountRepository: DiscountRepository, val itemRepository: ItemRepository) {
    fun getOrder(itemIds: List<String>): Order {

        val items = itemRepository.getItems(itemIds)
        val discounts = discountRepository.getDiscounts(itemIds)
        val itemsWithDiscount = items.applyDiscounts(discounts)
        return Order(itemsWithDiscount)
    }
}

private fun List<Item>.applyDiscounts(discounts: CartItemDiscounts):List<Item> {
    return  this.map { item ->
        val itemDiscount  = discounts.getDiscountsByItemId(item.id)
        if (itemDiscount!= null) item.applyDiscounts(itemDiscount) else item
    }
}

private fun Item.applyDiscounts(itemDiscount: Discount): Item {
    val discount = when(itemDiscount.type){
        DiscountType.PERCENTAGE -> getPercentageDiscount(this.price, itemDiscount.value)
        DiscountType.AMOUNT -> getAmountDiscount(this.price, itemDiscount.value)
    }
    this.discount = discount
    return this
}

fun getPercentageDiscount(itemPrice: BigDecimal,
                percentageDiscount: BigDecimal):BigDecimal =
        percentageDiscount.divide(BigDecimal(100)).multiply(itemPrice).setScale(2, RoundingMode.HALF_UP)



fun getAmountDiscount(basePrice: BigDecimal,
                      amountDiscount: BigDecimal): BigDecimal =
        if (basePrice.subtract(amountDiscount) < BigDecimal.ZERO) basePrice else amountDiscount.setScale(2, RoundingMode.HALF_UP)

