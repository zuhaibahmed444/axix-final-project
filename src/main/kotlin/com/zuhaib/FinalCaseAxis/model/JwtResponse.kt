package com.zuhaib.FinalCaseAxis.model

import org.springframework.security.core.userdetails.UserDetails

class JwtResponse {
    var token: String? = null
    var details: UserDetails?  = null

    constructor(token: String?, details: UserDetails?) {
        this.token = token
        this.details = details
    }

    constructor() {}
}