package com.zuhaib.FinalCaseAxis.model.helper

class BookAssignRequestModel() {
    var bookId: String? = null
    var userId: String? = null

    constructor(bookId: String, userId: String) : this() {
        this.bookId = bookId
        this.userId = userId
    }

}