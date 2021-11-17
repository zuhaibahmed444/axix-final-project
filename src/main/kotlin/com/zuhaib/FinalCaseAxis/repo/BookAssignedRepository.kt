package com.zuhaib.FinalCaseAxis.repo

import com.zuhaib.FinalCaseAxis.model.Book
import com.zuhaib.FinalCaseAxis.model.BookAssigned
import com.zuhaib.FinalCaseAxis.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BookAssignedRepository : MongoRepository<BookAssigned, String> {
    fun save(bookAssigned: BookAssigned): BookAssigned?
    fun findByUser(user:User):List<BookAssigned>
    fun findBookByUser(user:User):List<Book>
    fun findByBook(book:Book):List<BookAssigned>
    fun findByBookAndUser(book:Book,user:User):BookAssigned?

}

