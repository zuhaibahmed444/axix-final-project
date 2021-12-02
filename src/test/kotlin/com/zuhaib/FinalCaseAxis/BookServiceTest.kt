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

    val book = Book("Mock Test-1","Myself","2021","https://zuhaib-axis-bucket.s3.amazonaws.com/Test-Book.pdf","Test-Book.pdf","https://zuhaib-axis-bucket.s3.amazonaws.com/Test-Book.pdf","test-image")

    @Test
    fun saveBookTest(){
        `when`(bookRepository?.save(book)).thenReturn(book)
        assertEquals(book, service?.uploadBook(book))
    }

    @Test
    fun getBookByIdTest(){
        val id = "c9c879eb-533a-11ec-98af-6bd001cdcda5"
        assertEquals("Outliers",service?.getBookById(id)?.title)
    }

    @Test
    fun getAllBooksTest(){
        assertTrue(service?.getAllBooks()!!.isNotEmpty())
    }

}