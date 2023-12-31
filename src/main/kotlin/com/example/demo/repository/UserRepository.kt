package com.example.demo.repository

import com.example.demo.entities.ChatUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<ChatUser, UUID> {

}