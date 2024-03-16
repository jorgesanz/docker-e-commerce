package org.factoriaf5.ecommerce.order.domain

import org.factoriaf5.ecommerce.promotion.domain.Discount

data class ItemDiscounts(val itemId:String, val discount: Discount)