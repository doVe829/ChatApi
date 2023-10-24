package com.example.demo.entities

import jakarta.persistence.*
import java.util.*

@Entity
 class Message(
    @Id
    @GeneratedValue
   val id: UUID? = null,
    val text: String,
    @ManyToOne
    val chatUser: ChatUser?
) {

}