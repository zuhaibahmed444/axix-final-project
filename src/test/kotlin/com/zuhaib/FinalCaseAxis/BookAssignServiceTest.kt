package com.zuhaib.FinalCaseAxis


import com.zuhaib.FinalCaseAxis.repo.BookAssignedRepository
import com.zuhaib.FinalCaseAxis.service.BookAssignedService
import com.zuhaib.FinalCaseAxis.service.BookService
import com.zuhaib.FinalCaseAxis.service.UserService
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

@SpringBootTest
class BookAssignServiceTest {

    @Autowired
    val service : BookAssignedService?=null

    @Mock
    val bookAssignedRepository : BookAssignedRepository?=null

    @Autowired
    val userService : UserService?=null

    @Autowired
    val bookService : BookService?=null


    @Test
    fun assignBookTest(){
        val user = userService?.getUser("zuhaibahmed444@gmail.com")
        val book = bookService?.getBookById("b03101dc-41f4-11ec-bdb5-ef1318946000")
        Assert.assertEquals(book,service?.assignBook(book!!,user!!)?.book)

    }



    @Test
    fun getAssignedBookTest(){
        val id = "2ca89243-47cf-11ec-aa32-99e5e5223e7f"
        Assert.assertEquals(id,service?.getAssignedBookById(id)?.id)

    }

    @Test
    fun getAllAssignedBooksTest(){
        Assert.assertTrue(service?.getAllAssignedBooks()!!.isNotEmpty())
    }

    @Test
    fun getAssignedBookByUserTest(){
        val user = userService?.getUser("zuhaibahmeds27@gmail.com")
        Assert.assertTrue(service?.getAssignedBooksByUser(user!!)!!.isNotEmpty())
    }

}