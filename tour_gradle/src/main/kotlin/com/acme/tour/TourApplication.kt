package com.acme.tour

import com.acme.tour.model.Promocao
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class TourApplication {
	companion object {
		val initialPromocoes = arrayOf(
			Promocao(1, "Maravilhosa viagem", "cancun", true, 7,7.400),
			Promocao(2, "Viagem tosca", "nada", false, 1,10.00),
			Promocao(3, "Que viagem legal", "São Paulo", false, 20,500.00),
			Promocao(4, "Venha aproveitar essa viagem", "Rio de Janeiro", false, 14,1000.00),
		)
	}

	@Bean
	fun promocoes() = ConcurrentHashMap<Long, Promocao>(initialPromocoes.associateBy(Promocao::id))
}

fun main(args: Array<String>) {
	runApplication<TourApplication>(*args)
}

