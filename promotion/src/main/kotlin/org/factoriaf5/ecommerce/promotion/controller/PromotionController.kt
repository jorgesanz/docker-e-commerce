package org.factoriaf5.ecommerce.promotion.controller

import org.factoriaf5.ecommerce.promotion.domain.CartItemDiscounts
import org.factoriaf5.ecommerce.promotion.service.PromotionService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PromotionController(private val promotionService: PromotionService) {

    @GetMapping( "/promotion")
    fun getAllPromotions(@RequestParam("item_id") itemIds: List<String> ): ResponseEntity<CartItemDiscounts> {

        val promos:CartItemDiscounts = promotionService.getPromotions(itemIds)
        return ResponseEntity(promos, HttpStatus.OK)
    }
}