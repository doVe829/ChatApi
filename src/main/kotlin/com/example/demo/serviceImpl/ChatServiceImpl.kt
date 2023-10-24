package com.example.demo.serviceImpl

import com.example.demo.entities.Chat
import com.example.demo.repository.ChatRepository
import com.example.demo.service.ChatService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ChatServiceImpl(
    private val chatRepository: ChatRepository,
    private val logger: Logger = LoggerFactory.getLogger(ChatServiceImpl::class.java)
) : ChatService {
    override fun createChat(): Chat {
        val currentChat: Chat = Chat();
        val chat:Chat = chatRepository.save(currentChat);
        logger.info("SERVICE CREATE chat created [${chat.roomId}]")
        return chat;
    }
}