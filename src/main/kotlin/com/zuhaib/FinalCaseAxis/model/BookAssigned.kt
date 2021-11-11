package com.zuhaib.FinalCaseAxis.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document(collection = "bookAssigned")
class BookAssigned (){
    @Id
    var Id : String? = null
    @DBRef
    var user: User? = null
    @DBRef
    var book: Book? = null
    var expiryDate: LocalDate? = null
    var issueDate: LocalDate? = null

    constructor(user: User, book: Book, expiryDate: LocalDate, issueDate: LocalDate) : this() {
        this.user = user
        this.book = book
        this.expiryDate = expiryDate
        this.issueDate = issueDate
    }

}