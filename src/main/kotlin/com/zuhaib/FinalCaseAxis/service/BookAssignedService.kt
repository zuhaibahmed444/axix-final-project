package com.zuhaib.FinalCaseAxis.service

import com.zuhaib.FinalCaseAxis.model.Book
import com.zuhaib.FinalCaseAxis.model.BookAssigned
import com.zuhaib.FinalCaseAxis.model.User
import com.zuhaib.FinalCaseAxis.model.helper.BookBasedUserResponse
import com.zuhaib.FinalCaseAxis.model.helper.RevokeRequestModel

interface BookAssignedService {

    fun assignBook(book:Book, user:User): BookAssigned?
    fun getAllAssignedBooks(): List<BookAssigned>
    fun getAssignedByUser(user:User): List<BookAssigned>
    fun getAssignedBooksByUser(user:User): List<BookAssigned>
    fun getAssignedByUserAll(user: User): List<BookAssigned>
    fun updateBookAssigned(bookAssigned: BookAssigned): BookAssigned?
    fun getAssignedBookById(id:String): BookAssigned?
    fun getAssignedBooksByBook(book: Book): List<BookBasedUserResponse>
    fun revokeBookAssigned(user: User,book: Book): BookAssigned?
}