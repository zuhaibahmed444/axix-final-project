package com.zuhaib.FinalCaseAxis.repo

import com.zuhaib.FinalCaseAxis.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: MongoRepository<User,String> {
    fun findByEmail(email: String): User?
}
