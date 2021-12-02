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
        val book = bookService?.getBookById("c9c879eb-533a-11ec-98af-6bd001cdcda5")
        Assert.assertEquals(book,service?.assignBook(book!!,user!!)?.book)

    }



    @Test
    fun getAssignedBookTest(){
        val id = "e08bc00d-5340-11ec-98af-df6c28495305"
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