package com.example.demo.service

import com.example.demo.dto.MessageDto
import com.example.demo.entities.Message
import java.util.Optional


interface MessageService {

    fun getAllMessages(): List<Message>;

    fun saveMessages(msg: MessageDto):Message;

    fun findById(id: String): Optional<Message>
}