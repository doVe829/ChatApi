package com.example.demo.serviceImpl

import com.example.demo.entities.Chat
import com.example.demo.entities.ChatUser
import com.example.demo.repository.ChatRepository
import com.example.demo.repository.UserRepository
import com.example.demo.service.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(
    private val userRepo: UserRepository,
    private val chatRepo: ChatRepository,
    private val logger: Logger = LoggerFactory.getLogger(UserServiceImpl::class.java)
) : UserService {

    override fun createUser(usr: ChatUser): ChatUser {
        val user: ChatUser = userRepo.save(usr);
        logger.info("SERVICE CREATE user [$user]")

        return user;
    }

    override fun deleteUser(id: String) {
        userRepo.deleteById(UUID.fromString(id))
        logger.info("SERVICE DELETE user [$id]")
    }

    override fun getUser(id: String): Optional<ChatUser> {
        return userRepo.findById(UUID.fromString(id))
    }

    override fun joinChat(id: String, usr: ChatUser) {
       val chat: Optional<Chat> = chatRepo.findById(UUID.fromString(id));
        logger.info("SERVICE joinChat user ${usr.id} joined.")
        chat.get().chatUsers.add(usr)

    }


}