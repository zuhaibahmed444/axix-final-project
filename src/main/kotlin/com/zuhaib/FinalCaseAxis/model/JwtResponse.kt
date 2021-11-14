package com.zuhaib.FinalCaseAxis.model


class JwtResponse {
    var token: String? = null

    constructor(token: String?) {
        this.token = token
    }

    constructor() {}
}