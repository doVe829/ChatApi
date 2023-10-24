package com.example.demo.entities

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.*

@Entity
data class ChatUser (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID?,
    val name: String,
    @ManyToOne
    @JoinColumn(name="chat_id")
    val chat:Chat = Chat(),

) {

}