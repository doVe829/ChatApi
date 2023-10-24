package com.example.demo.controller

import com.example.demo.dto.UserDto
import com.example.demo.entities.ChatUser
import com.example.demo.service.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usr")
class UserController(
    val usrService: UserService,
    private val logger: Logger = LoggerFactory.getLogger(UserController::class.java)
) {

    @PostMapping("/create")
    fun createUser(@RequestBody usr: ChatUser): ResponseEntity<UserDto> {

        logger.info("REQUEST CREATE: [USER]")
        val chatUser: ChatUser = usrService.createUser(usr);
        val response = UserDto(chatUser.copy());
        logger.info("REQUEST JOIN CHAT: [$chatUser]")
        usrService.joinChat("70fa77f7-be51-482b-bb40-a6316f86bce0", chatUser)

        return ResponseEntity(response, HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/get/{id}")
    fun getUser(@PathVariable("id") id: String) = usrService.getUser(id);

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    fun deleteUser(@PathVariable("id") id: String) {
        logger.info("REQUEST DELETE [${id}]")
        usrService.deleteUser(id);
    }

}