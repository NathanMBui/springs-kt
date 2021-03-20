package com.nathanmbui.restservice.scheduler

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Component
class ScheduledTasks {

    private val logger = LoggerFactory.getLogger(javaClass)
    private val pattern = DateTimeFormatter.ofPattern("HH:mm:ss")

    @Scheduled(fixedRate = 500)
    fun reportCurrentTime() {
        logger.info("The time is now: " + LocalDateTime.now().format(pattern))
    }

}