package com.zuhaib.FinalCaseAxis

import com.zuhaib.FinalCaseAxis.model.Book
import com.zuhaib.FinalCaseAxis.repo.BookRepository
import com.zuhaib.FinalCaseAxis.service.BookService
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookServiceTest {

    @Autowired
    val service : BookService? =null

    @Mock
    val bookRepository : BookRepository?=null

    val book = Book("Mock Test-1","Myself","2021","https://zuhaib-axis-bucket.s3.amazonaws.com/Test-Book.pdf","Test-Book.pdf")

    @Test
    fun saveBookTest(){
        `when`(bookRepository?.save(book)).thenReturn(book)
        assertEquals(book, service?.uploadBook(book))
    }

    @Test
    fun getBookByIdTest(){
        val id = "08e69f37-4ec8-11ec-b9d4-f92af5e15ff7"
        assertEquals("Java",service?.getBookById(id)?.title)
    }

    @Test
    fun getAllBooksTest(){
        assertTrue(service?.getAllBooks()!!.isNotEmpty())
    }

}