package com.zuhaib.FinalCaseAxis.controller

import com.zuhaib.FinalCaseAxis.model.User
import com.zuhaib.FinalCaseAxis.service.UserService
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
class UserController {

    @Autowired
    val userService: UserService? = null

    @Autowired
    private val bCryptPasswordEncoder: BCryptPasswordEncoder? = null

    @GetMapping("/test")
    fun test(): String {
        return "Working Fine"
    }

    @PostMapping("/")
    fun createUser(@RequestBody user: User): User? {
        user.password = bCryptPasswordEncoder!!.encode(user.password)
        return userService?.createUser(user)
    }

    @GetMapping("/")
    fun getAllUsers(): List<User?>? {
        return userService?.getUsers()
    }

    @PostMapping("/email")
    fun getUserByEmail(@RequestBody email:String): User? {
        return userService?.getUser(email)
    }

    @GetMapping("/{Id}")
    fun getUserById(@PathVariable("Id") Id:String):User?{
        return userService?.getUserById(Id)
    }

    @GetMapping("/count")
    fun getUserCount(): ResponseEntity<*>{
        val count = userService?.getUsers()?.size
        return ResponseEntity.ok(count)
    }

}