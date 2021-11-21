package com.zuhaib.FinalCaseAxis.controller

import com.zuhaib.FinalCaseAxis.helper.CSVUtils
import com.zuhaib.FinalCaseAxis.model.AccessReq
import com.zuhaib.FinalCaseAxis.model.Book
import com.zuhaib.FinalCaseAxis.model.BookAssigned
import com.zuhaib.FinalCaseAxis.model.User
import com.zuhaib.FinalCaseAxis.model.helper.BookBasedUserResponse
import com.zuhaib.FinalCaseAxis.model.helper.RevokeRequestModel
import com.zuhaib.FinalCaseAxis.repo.BookAssignedRepository
import com.zuhaib.FinalCaseAxis.service.AccessReqService
import com.zuhaib.FinalCaseAxis.service.BookAssignedService
import com.zuhaib.FinalCaseAxis.service.BookService
import com.zuhaib.FinalCaseAxis.service.Impl.CSVServiceImpl
import com.zuhaib.FinalCaseAxis.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import kotlin.jvm.Throws

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

    @Autowired
    val accessReqService: AccessReqService? = null

    @Autowired
    val bookAssignedRepository: BookAssignedRepository? = null

   @Autowired
   val csvServiceImpl : CSVServiceImpl? = null

    @PostMapping("/")
    fun assignBook(@RequestBody reqId: String): BookAssigned? {
        val accessReq : AccessReq? = accessReqService!!.getAccessReq(reqId)
        var email : String? = accessReq!!.userEmail
        var bookId : String? = accessReq!!.bookId
        var user : User? = userService!!.getUser(email!!)
        var book: Book? = bookService!!.getBookById(bookId!!)
        accessReq.active = false
        accessReqService!!.updateAccessReq(accessReq)
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

    @GetMapping("/book-res/{id}")
    fun getAssignBookByUserRes(@PathVariable id: String): List<BookBasedUserResponse> {
        val book : Book? = bookService!!.getBookById(id)
        return bookAssignedService!!.getAssignedBooksByBook(book!!)

    }

    @PostMapping("/revoke")
    fun revokeBookAccess(@RequestBody revreq : RevokeRequestModel): BookAssigned? {
        var email : String? = revreq.userEmail
        var bookId : String? = revreq.bookId
        var user : User? = userService!!.getUser(email!!)
        var book: Book? = bookService!!.getBookById(bookId!!)
        return bookAssignedService?.revokeBookAssigned(user!!, book!!)
    }

    @PostMapping("/csv")
    fun uploadCSV(@RequestParam("file") file: MultipartFile): ResponseEntity<*> {

            var ot = csvServiceImpl!!.uploadMultipart(file)
            ot.forEach {
                var user: User? = it.userEmail?.let { it1 -> userService!!.getUser(it1) }
                var book: Book? = it.bookId?.let { it1 -> bookService!!.getBookById(it1) }
                bookAssignedService?.revokeBookAssigned(user!!, book!!)
            }
            return ResponseEntity.ok(ot)


    }

}