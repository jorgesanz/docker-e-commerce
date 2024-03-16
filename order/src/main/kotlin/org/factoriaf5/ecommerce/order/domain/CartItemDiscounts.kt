package org.factoriaf5.ecommerce.order.domain

import org.factoriaf5.ecommerce.promotion.domain.Discount
import java.math.BigDecimal

data class CartItemDiscounts(val itemDiscounts: List<ItemDiscounts>) {
    fun getDiscountsByItemId(itemId: String): Discount? {
        return itemDiscounts.firstOrNull { itemDiscount -> itemDiscount.itemId == itemId }?.discount
    }
}