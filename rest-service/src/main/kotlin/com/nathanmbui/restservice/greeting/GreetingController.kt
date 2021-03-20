package com.nathanmbui.restservice.greeting

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.format.DateTimeFormatter
import java.util.concurrent.atomic.AtomicLong


@RestController
class GreetingController {
    private val counter = AtomicLong()
    private val logger = LoggerFactory.getLogger(javaClass)
    private val pattern = DateTimeFormatter.ofPattern("HH:mm:ss")

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String?): Greeting {
        return Greeting(counter.incrementAndGet(), String.format(template, name))
    }

    @Scheduled(initialDelay = 500, fixedDelay = 500)
    fun testFixedRateWithDelay() {
        logger.info("test delay in Greeting")
    }

    companion object {
        private const val template = "Hello, %s!"
    }
}