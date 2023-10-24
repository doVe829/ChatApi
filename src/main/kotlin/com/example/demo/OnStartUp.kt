package com.example.demo

import com.example.demo.service.ChatService
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class OnStartUp(private val chatService: ChatService): ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
       chatService.createChat()
    }
}