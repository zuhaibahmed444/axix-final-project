package com.zuhaib.FinalCaseAxis.model.helper

class RevokeRequestModel() {
    var bookId :String? = null
    var userEmail:String? = null

    constructor(bookId: String, userEmail: String) : this() {
        this.bookId = bookId
        this.userEmail = userEmail
    }
}