package org.factoriaf5.ecommerce.order.repository

import org.factoriaf5.ecommerce.order.domain.CartItemDiscounts
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestClient
import org.springframework.web.util.DefaultUriBuilderFactory

@Repository
class DiscountRepository {

  fun getDiscounts(itemIds: List<String>): CartItemDiscounts =
      try {
        RestClient.create()
            .get()
            .uri(
                DefaultUriBuilderFactory()
                    .builder()
                    .scheme("http")
                    .host("promotion")
                    .port(8082)
                    .path("promotion")
                    .queryParam("item_id", itemIds)
                    .build())
            .retrieve()
            .body(CartItemDiscounts::class.java)!!
      } catch (e: Exception) {
        CartItemDiscounts(emptyList())
      }
}
