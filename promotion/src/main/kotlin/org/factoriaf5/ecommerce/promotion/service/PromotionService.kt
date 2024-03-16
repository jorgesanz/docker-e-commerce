package org.factoriaf5.ecommerce.promotion.service

import org.factoriaf5.ecommerce.promotion.domain.CartItemDiscounts
import org.factoriaf5.ecommerce.promotion.repository.DiscountRepository
import org.springframework.stereotype.Service

@Service
class PromotionService(val discountRepository: DiscountRepository) {
    fun getPromotions(itemIds: List<String>): CartItemDiscounts {
        return CartItemDiscounts(itemIds.map { discountRepository.getDiscounts(it) })
    }
}