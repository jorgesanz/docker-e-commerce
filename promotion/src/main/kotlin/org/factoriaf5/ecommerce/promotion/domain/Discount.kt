package org.factoriaf5.ecommerce.promotion.domain

import java.math.BigDecimal

data class Discount(val value: BigDecimal, val type: DiscountType )

enum class DiscountType{
    AMOUNT,PERCENTAGE
}