package com.zuhaib.FinalCaseAxis.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.*
import java.security.Principal
import com.fasterxml.jackson.databind.ObjectMapper
import com.zuhaib.FinalCaseAxis.config.JwtUtils
import com.zuhaib.FinalCaseAxis.model.JwtRequest
import com.zuhaib.FinalCaseAxis.model.JwtResponse
import com.zuhaib.FinalCaseAxis.service.Impl.UserDetailsServiceImpl


@RestController
@CrossOrigin("*")
class AuthController {
    val mapper = ObjectMapper()

    @Autowired
    private val authenticationManager: AuthenticationManager? = null

    @Autowired
    private val userDetailsService: UserDetailsServiceImpl? = null

    @Autowired
    private val jwtUtils: JwtUtils? = null

    //generate token
    @PostMapping("/generate-token")
    @Throws(Exception::class)
    fun generateToken(@RequestBody jwtRequest: JwtRequest): ResponseEntity<*> {
        try {
            authenticate(jwtRequest.getEmail(), jwtRequest.getPassword())
        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception("User not found ")
        }
        /////////////authenticate
        val userDetails = userDetailsService!!.loadUserByUsername(jwtRequest.getEmail())
        val token = jwtUtils?.generateToken(userDetails)
        val userdetail = userDetailsService!!.loadUserByUsername(jwtRequest.getEmail())
        return ResponseEntity.ok(JwtResponse(token, userdetail))
    }

    @Throws(Exception::class)
    private fun authenticate(username: String?, password: String?) {
        try {
            authenticationManager?.authenticate(UsernamePasswordAuthenticationToken(username, password))
        } catch (e: DisabledException) {
            throw Exception("USER DISABLED " + e.message)
        } catch (e: BadCredentialsException) {
            throw Exception("Invalid Credentials " + e.message)
        }
    }
    //return the details of current user
    @GetMapping("/api/v1/current-user")
    fun getCurrentUser(principal: Principal): String? {
        return mapper.writeValueAsString(userDetailsService?.loadUserByUsername(principal.name))
    }
}





