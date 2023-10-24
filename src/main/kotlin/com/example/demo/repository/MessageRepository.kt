package com.example.demo.repository

import com.example.demo.entities.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface MessageRepository : JpaRepository<Message, UUID> {
}