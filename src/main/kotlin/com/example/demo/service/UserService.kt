package com.example.demo.service

import com.example.demo.entities.ChatUser
import java.util.Optional

interface UserService {

    fun createUser(usr: ChatUser):ChatUser;
    fun deleteUser(id: String);
    fun getUser(id: String): Optional<ChatUser>;
    fun joinChat(id: String, usr: ChatUser);

}