package com.zuhaib.FinalCaseAxis.service.Impl

import com.fasterxml.uuid.Generators
import com.zuhaib.FinalCaseAxis.model.Book
import com.zuhaib.FinalCaseAxis.repo.BookRepository
import com.zuhaib.FinalCaseAxis.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookServiceImpl: BookService {

    @Autowired
    val bookRepository: BookRepository? = null

    override fun uploadBook(book: Book): Book? {
        book.bookId = Generators.timeBasedGenerator().generate().toString()
        return bookRepository?.save(book)
    }

    override fun getBookById(id: String): Book? {
        return bookRepository?.findById(id)?.orElse(null)
    }

    override fun getAllBooks(): List<Book>? {
        return bookRepository?.findAll()
    }


}
