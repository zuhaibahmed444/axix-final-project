package com.zuhaib.FinalCaseAxis.service.Impl

import com.fasterxml.uuid.Generators
import com.zuhaib.FinalCaseAxis.helper.UserException
import com.zuhaib.FinalCaseAxis.model.User
import com.zuhaib.FinalCaseAxis.repo.UserRepository
import com.zuhaib.FinalCaseAxis.service.UserService
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl: UserService {

    @Autowired
    var userRepository: UserRepository? = null

    @Throws(Exception::class)
    override fun createUser(user: User): User? {
        if (user.email?.let { userRepository!!.findByEmail(it) } != null) {
            throw UserException("User with email ${user.email} already exists")
        }else{
            user.userId = Generators.timeBasedGenerator().generate().toString()
            user.role = "USER"
            return userRepository!!.save(user)
        }
    }

    override fun getUser(email: String): User? {
        return userRepository!!.findByEmail(email)
    }

    override fun updateUser(user: User): User? {
        return userRepository!!.save(user)
    }

    override fun getUsers(): List<User?>? {
        return userRepository!!.findAll()
    }

    override fun getUserById(userId: String): User? {
        return userRepository!!.findById(userId).orElse(null)
    }
}