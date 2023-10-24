package com.example.demo.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.util.*

@Entity
data class Chat(
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    val roomId: UUID = UUID.fromString("70fa77f7-be51-482b-bb40-a6316f86bce0"),
    @OneToMany(mappedBy = "chat")
    val chatUsers: MutableList<ChatUser> = mutableListOf()
) {
}