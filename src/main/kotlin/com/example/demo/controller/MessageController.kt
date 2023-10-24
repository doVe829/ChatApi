package com.example.demo.controller

import com.example.demo.dto.MessageDto
import com.example.demo.entities.Message
import com.example.demo.service.MessageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/message")
class MessageController(val msgService: MessageService) {

    @GetMapping("/list")
    fun get() = msgService.getAllMessages()

    @PostMapping("/list")
    fun post(@RequestBody message: MessageDto) {
        msgService.saveMessages(message);
    }

    @GetMapping("/list/{id}")
    fun getById(@PathVariable("id")id: String) = msgService.findById(id);
}