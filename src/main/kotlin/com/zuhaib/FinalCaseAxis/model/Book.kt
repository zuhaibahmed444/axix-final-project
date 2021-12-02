package com.zuhaib.FinalCaseAxis.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "books")
class Book (){
    @Id
    var bookId :String? = null
    var title: String? = null
    var author: String? = null
    var year: String? = null
    var fileurl: String? = null
    var filename: String? = null
    var imagename:String? = null
    var imageurl:String? = null


    constructor(title: String?, author: String?, year: String?, fileurl: String?, filename: String?, imagename: String?, imageurl: String?) : this() {
        this.title = title
        this.author = author
        this.year = year
        this.fileurl = fileurl
        this.filename = filename
        this.imagename = imagename
        this.imageurl = imageurl
    }
}