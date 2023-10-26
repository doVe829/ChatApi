package com.example.demo

import com.example.demo.service.ChatService
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class OnStartUp(private val chatService: ChatService) : ApplicationRunner {

    private final val logger = LoggerFactory.getLogger(OnStartUp::class.java)
    override fun run(args: ApplicationArguments?) {
        logger.info("REQUEST create chat")
        chatService.createChat()
    }
}