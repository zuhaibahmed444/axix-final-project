package com.zuhaib.FinalCaseAxis.service

import com.zuhaib.FinalCaseAxis.model.User
import org.bson.types.ObjectId

interface UserService {
    fun createUser(user : User): User?
    //get user by username
    fun getUser(email : String): User?
    //update
    fun updateUser(user:User) :User?
    //get user
    fun getUsers():List<User?>?
    //get user by id
    fun getUserById(userId:String):User?
}