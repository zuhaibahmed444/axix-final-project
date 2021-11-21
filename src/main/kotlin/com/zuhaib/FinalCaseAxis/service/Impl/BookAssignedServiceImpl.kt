package com.zuhaib.FinalCaseAxis.service.Impl

import com.fasterxml.uuid.Generators
import com.zuhaib.FinalCaseAxis.model.Book
import com.zuhaib.FinalCaseAxis.model.BookAssigned
import com.zuhaib.FinalCaseAxis.model.User
import com.zuhaib.FinalCaseAxis.model.helper.BookBasedUserResponse
import com.zuhaib.FinalCaseAxis.model.helper.RevokeRequestModel
import com.zuhaib.FinalCaseAxis.repo.BookAssignedRepository
import com.zuhaib.FinalCaseAxis.service.BookAssignedService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class BookAssignedServiceImpl() : BookAssignedService {

    @Autowired
    val bookAssignedRepository: BookAssignedRepository? = null


    override fun assignBook(book: Book, user: User): BookAssigned? {
        var expirydate : LocalDate = LocalDate.now().plusDays(15)
        var issuedate : LocalDate = LocalDate.now()
        var bookAssigned = BookAssigned()
        bookAssigned.book = book
        bookAssigned.user = user
        bookAssigned.expiryDate = expirydate
        bookAssigned.issueDate = issuedate
        bookAssigned.id =  Generators.timeBasedGenerator().generate().toString()
        return bookAssignedRepository?.save(bookAssigned)

    }

    override fun getAllAssignedBooks(): List<BookAssigned> {
        return bookAssignedRepository?.findAll()!!
    }

    override fun getAssignedByUser(user: User): List<BookAssigned> {
        return bookAssignedRepository!!.findByUser(user)

    }

    override fun getAssignedBooksByUser(user: User): List<Book> {
        val booksAssigned : List<BookAssigned> = bookAssignedRepository!!.findByUser(user)
        var dt : LocalDate = LocalDate.now()
        val len : Int = booksAssigned.size
        var books : MutableList<Book> = mutableListOf()
        for (i in 0 until len){
            if(booksAssigned[i].expiryDate!!.isAfter(dt)){
                books.add(booksAssigned[i].book!!)
            }

        }
        println(books)
        return books


    }

    override fun getAssignedByUserAll(user: User): List<Book> {
        val bookAssigned = bookAssignedRepository!!.findByUser(user)
        val len : Int = bookAssigned.size
        var books : MutableList<Book> = mutableListOf()
        for (i in 0 until len){
            books.add(bookAssigned[i].book!!)
        }
        return books
    }

    override fun updateBookAssigned(bookAssigned: BookAssigned): BookAssigned? {
        return bookAssignedRepository?.save(bookAssigned)
    }

    override fun getAssignedBookById(id: String): BookAssigned? {
        return bookAssignedRepository!!.findById(id).orElse(null)
    }

    override fun getAssignedBooksByBook(book: Book): List<BookBasedUserResponse> {
        var bookAssigned :List<BookAssigned> = bookAssignedRepository!!.findByBook(book)
        val len : Int = bookAssigned.size
        var bookres = BookBasedUserResponse()
        var res : MutableList<BookBasedUserResponse> = mutableListOf()
        println(len)
        for (i in 0 until len){
            res.add(BookBasedUserResponse(bookAssigned[i].user!!.email,bookAssigned[i].expiryDate,bookAssigned[i].issueDate,bookAssigned[i].expiryDate!!.isAfter(LocalDate.now())))
        }
        println(res)
        return res

    }

    override fun revokeBookAssigned(user: User, book: Book): BookAssigned? {
        val bookAssigned = bookAssignedRepository!!.findByBookAndUser(book,user)
        bookAssigned!!.expiryDate = LocalDate.now().minusDays(1)
        return bookAssignedRepository!!.save(bookAssigned)
    }


}



