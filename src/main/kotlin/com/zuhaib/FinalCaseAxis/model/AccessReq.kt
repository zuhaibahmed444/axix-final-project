package com.zuhaib.FinalCaseAxis.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "access_req")
class AccessReq (){
    @Id
    var reqID : String? = null
    var bookId : String? = null
    var bookName :String? = null
    var userEmail:String? = null
    var active:Boolean = true

    constructor(bookId: String, bookName: String, userEmail: String,active:Boolean) : this() {
        this.bookId = bookId
        this.bookName = bookName
        this.userEmail = userEmail
        this.active = active
    }
}