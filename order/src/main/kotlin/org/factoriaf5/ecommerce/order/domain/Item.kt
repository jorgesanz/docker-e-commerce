package org.factoriaf5.ecommerce.order.domain

import java.math.BigDecimal

data class Item(val id:String, val price: BigDecimal, var discount: BigDecimal = BigDecimal.ZERO)