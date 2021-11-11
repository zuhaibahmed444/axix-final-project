package com.zuhaib.FinalCaseAxis.service.Impl

import com.zuhaib.FinalCaseAxis.model.Book
import com.zuhaib.FinalCaseAxis.model.BookAssigned
import com.zuhaib.FinalCaseAxis.model.User
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
        var bookassigned = BookAssigned(user,book, expirydate, issuedate)
        return bookAssignedRepository?.save(bookassigned)

    }

    override fun getAllAssignedBooks(): List<BookAssigned> {
        return bookAssignedRepository?.findAll()!!
    }

    override fun getAssignedByUser(user: User): List<BookAssigned> {
        return bookAssignedRepository!!.findByUser(user)
    }

    override fun getAssignedBooksByUser(user: User): List<Book> {
        return bookAssignedRepository!!.findBookByUser(user)
    }


}
