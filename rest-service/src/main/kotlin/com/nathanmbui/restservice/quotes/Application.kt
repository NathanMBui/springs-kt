package com.nathanmbui.restservice.quotes

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}

@SpringBootApplication
class Application {

	private val log = LoggerFactory.getLogger(javaClass)

	@Bean(name = ["default"])
	fun restTemplateDefault(builder: RestTemplateBuilder): RestTemplate {
		return builder.build()
	}

	@Bean
	fun restTemplateTest(builder: RestTemplateBuilder): RestTemplate {
		return builder.build()
	}

	@Bean
	fun run(@Qualifier(value = "default") restTemplate: RestTemplate): CommandLineRunner {
		return CommandLineRunner {
			val quote: Quote = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random")
			log.info("Quote = $quote")
		}
	}
}
