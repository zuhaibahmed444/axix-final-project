package com.zuhaib.FinalCaseAxis.model.helper

import java.time.LocalDate

class BookBasedUserResponse() {
    var userEmail : String? = null
    var expiredDate : LocalDate? = null
    var issuedDate : LocalDate? = null
    var active : Boolean = false

    constructor(userEmail: String?, expiredDate: LocalDate?, issuedDate: LocalDate?, active: Boolean) : this() {
        this.userEmail = userEmail
        this.expiredDate = expiredDate
        this.issuedDate = issuedDate
        this.active = active
    }
}