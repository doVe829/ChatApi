package com.example.demo.controller

import com.example.demo.dto.MessageDto
import com.example.demo.service.MessageService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/message")
class MessageController(
    val msgService: MessageService,
    private val logger: Logger = LoggerFactory.getLogger(MessageController::class.java)
) {

    @GetMapping("/get")
    fun get() = msgService.getAllMessages()

    @PostMapping("/send")
    fun sendMessage(@RequestBody message: MessageDto) {
        logger.info("REQUEST sendMessage from user [${message.userId}] with content [${message.text}]")
        msgService.sendMessage(message);
    }

    @GetMapping("/get/{id}")
    fun getById(@PathVariable("id") id: String) = msgService.findById(id);
}