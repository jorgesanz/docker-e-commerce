package org.factoriaf5.ecommerce.promotion

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude =  [DataSourceAutoConfiguration::class] )
class PromotionApplication

fun main(args: Array<String>) {
	runApplication<PromotionApplication>(*args)
}
