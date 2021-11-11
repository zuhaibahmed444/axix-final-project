package com.zuhaib.FinalCaseAxis.service

import com.zuhaib.FinalCaseAxis.model.Book

interface BookService {
    //to upload book
    fun uploadBook(book: Book) : Book?
    //to get book by id
    fun getBookById(id: String) : Book?

    //to get all books
    fun getAllBooks() : List<Book>?

}