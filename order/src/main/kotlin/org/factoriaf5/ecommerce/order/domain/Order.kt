package org.factoriaf5.ecommerce.order.domain

import java.math.BigDecimal

data class Order(val items:List<Item>){
    val total:BigDecimal = items.sumOf { item -> item.price - item.discount }
}