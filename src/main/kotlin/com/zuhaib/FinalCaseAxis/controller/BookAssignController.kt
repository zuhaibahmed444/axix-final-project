package com.zuhaib.FinalCaseAxis.controller

import com.zuhaib.FinalCaseAxis.model.Book
import com.zuhaib.FinalCaseAxis.model.BookAssigned
import com.zuhaib.FinalCaseAxis.model.User
import com.zuhaib.FinalCaseAxis.model.helper.BookAssignRequestModel
import com.zuhaib.FinalCaseAxis.service.BookAssignedService
import com.zuhaib.FinalCaseAxis.service.BookService
import com.zuhaib.FinalCaseAxis.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/bookassign")
@CrossOrigin("*")
class BookAssignController {

    @Autowired
    val userService : UserService? = null

    @Autowired
    val bookService : BookService? = null

    @Autowired
    val bookAssignedService:BookAssignedService? = null

    @PostMapping("/")
    fun assignBook(@RequestBody bookAssignRequestModel: BookAssignRequestModel): BookAssigned? {
        var user : User? = bookAssignRequestModel.userId?.let { userService?.getUserById(it) }
        var book: Book? = bookAssignRequestModel.bookId?.let { bookService!!.getBookById(it) }
        return bookAssignedService!!.assignBook(book!!, user!!)

    }

    @GetMapping("/")
    fun getAllAssignedBooks(): List<BookAssigned>? {
        return bookAssignedService!!.getAllAssignedBooks()
    }

    @GetMapping("/{id}")
    fun getAssignAllBookByUserdata(@PathVariable id: String): List<BookAssigned>? {
        val user : User? = userService!!.getUserById(id)
        return bookAssignedService?.getAssignedByUser(user!!)
    }

    @GetMapping("/book-active/{id}")
    fun getAssignBookByUser(@PathVariable id: String): List<Book> {
        val user : User? = userService!!.getUserById(id)
        return bookAssignedService!!.getAssignedBooksByUser(user!!)
    }

    @GetMapping("/book-all/{id}")
    fun getAssignAllBookByUser(@PathVariable id: String): List<Book> {
        val user : User? = userService!!.getUserById(id)
        return bookAssignedService!!.getAssignedByUserAll(user!!)
    }



}