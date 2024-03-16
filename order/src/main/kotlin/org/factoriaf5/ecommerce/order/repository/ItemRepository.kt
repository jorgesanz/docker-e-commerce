package org.factoriaf5.ecommerce.order.repository

import java.math.BigDecimal
import org.factoriaf5.ecommerce.order.domain.Item
import org.springframework.stereotype.Repository

@Repository
class ItemRepository {

  val items =
      mapOf(
          "1" to Item("1", BigDecimal.valueOf(15.50)),
          "2" to Item("2", BigDecimal.valueOf(11.20)),
          "3" to Item("3", BigDecimal.valueOf(55.59)),
          "4" to Item("4", BigDecimal.valueOf(5.50)),
          "5" to Item("5", BigDecimal.valueOf(7.75)),
          "6" to Item("6", BigDecimal.valueOf(15.90)),
          "7" to Item("7", BigDecimal.valueOf(25.80)))

  fun getItems(itemIds: List<String>): List<Item> =
      itemIds.mapNotNull { itemId -> if (items.containsKey(itemId)) items[itemId] else null }
}
