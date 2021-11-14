package com.zuhaib.FinalCaseAxis.service

import com.zuhaib.FinalCaseAxis.model.Book
import com.zuhaib.FinalCaseAxis.model.BookAssigned
import com.zuhaib.FinalCaseAxis.model.User

interface BookAssignedService {

    fun assignBook(book:Book, user:User): BookAssigned?
    fun getAllAssignedBooks(): List<BookAssigned>
    fun getAssignedByUser(user:User): List<BookAssigned>
    fun getAssignedBooksByUser(user:User): List<Book>
    fun getAssignedByUserAll(user: User): List<Book>
    fun updateBookAssigned(bookAssigned: BookAssigned): BookAssigned?
    fun getAssignedBookById(id:String): BookAssigned?
}