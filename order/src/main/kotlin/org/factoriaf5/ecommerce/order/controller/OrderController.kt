package org.factoriaf5.ecommerce.order.controller

import org.factoriaf5.ecommerce.order.domain.Order
import org.factoriaf5.ecommerce.order.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(private val orderService: OrderService) {

    @GetMapping( "/order")
    fun getAllPromotions(@RequestParam("item_id") itemIds: List<String>): ResponseEntity<Order> {

        val order:Order = orderService.getOrder(itemIds)
        return ResponseEntity(order, HttpStatus.OK)
    }
}