package com.zuhaib.FinalCaseAxis.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Document(collection = "users")
class User(): UserDetails {

    @Id
    var userId: String? = null
    var name: String? = null
    var email: String? = null
    var phone: String? = null
    private var password: String? = null
    var role:String? = null

    constructor(userId: String, name: String, email: String, phone: String, password: String, role: String) : this() {
        this.userId = userId
        this.name = name
        this.email = email
        this.phone = phone
        this.password = password
        this.role = role
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val set:MutableSet<Authority> = HashSet()
        set.add(Authority(role))

        return set
    }

    override fun getPassword(): String {
        return password!!
    }

    fun setPassword(password: String) {
        this.password = password
    }


    override fun getUsername(): String {
        return email!!
    }

    override fun isAccountNonExpired(): Boolean {
       return false
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}