package com.example.demo.serviceImpl

import com.example.demo.dto.MessageDto
import com.example.demo.entities.ChatUser
import com.example.demo.entities.Message
import com.example.demo.exceptions.UserNotFoundException
import com.example.demo.repository.MessageRepository
import com.example.demo.repository.UserRepository
import com.example.demo.service.MessageService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*


@Service
class MessageServiceImpl(
    private val msgRepo: MessageRepository,
    private val logger: Logger = LoggerFactory.getLogger(MessageServiceImpl::class.java),
    private val userRepository: UserRepository
) : MessageService {
    override fun getAllMessages(): List<Message> {
        return msgRepo.findAll().toList();
    }

    fun findChatUserById(uuid: UUID): ChatUser?{
        return userRepository.findById(uuid).orElse(null)
    }

    override fun saveMessages(messageDto: MessageDto): Message {
        val user:ChatUser? = findChatUserById(UUID.fromString(messageDto.userId))
        if(user !== null){
            val message = Message(text = messageDto.text, chatUser = user)
            val savedMessage: Message = msgRepo.save(message)
            logger.info("SERVICE sendMessage sent by [${savedMessage.chatUser?.id}] and content [${savedMessage.text}]");

            return savedMessage;
        }else{
            throw UserNotFoundException("The user couldn't be found")
        }
//        val msg:Message = msgRepo.save(msg);

    }

    override fun findById(id: String): Optional<Message> {
        return msgRepo.findById(UUID.fromString(id))
    }


}