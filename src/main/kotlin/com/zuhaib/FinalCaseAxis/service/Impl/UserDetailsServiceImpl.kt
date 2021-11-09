package com.zuhaib.FinalCaseAxis.service.Impl

import com.zuhaib.FinalCaseAxis.repo.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service


@Service
class UserDetailsServiceImpl(private val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(email: String?): UserDetails {
        val user = email?.let { userRepository.findByEmail(it) }
        if (user == null){
            println("User Not Found")
            throw Exception("Invalid User")
        }
        return user

    }

}


