package com.nathanmbui.restservice.scheduler

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}

@SpringBootApplication
@EnableScheduling
class Application
