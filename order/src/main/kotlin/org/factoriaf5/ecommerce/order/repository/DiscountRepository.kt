package org.factoriaf5.ecommerce.order.repository

import org.factoriaf5.ecommerce.order.domain.CartItemDiscounts
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestClient
import org.springframework.web.util.DefaultUriBuilderFactory

@Repository
class DiscountRepository(
    @Value("\${promotion.scheme}") val promotionScheme: String,
    @Value("\${promotion.host}") val promotionHost: String,
    @Value("\${promotion.port}") val promotionPort: String,
    @Value("\${promotion.path}") val promotionPath: String
) {

  fun getDiscounts(itemIds: List<String>): CartItemDiscounts =
      try {
        RestClient.create()
            .get()
            .uri(
                DefaultUriBuilderFactory()
                    .builder()
                    .scheme(promotionScheme)
                    .host(promotionHost)
                    .port(promotionPort)
                    .path(promotionPath)
                    .queryParam("item_id", itemIds)
                    .build())
            .retrieve()
            .body(CartItemDiscounts::class.java)!!
      } catch (e: Exception) {
        CartItemDiscounts(emptyList())
      }
}
