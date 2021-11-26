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
        val book = bookService?.getBookById("08e69f37-4ec8-11ec-b9d4-f92af5e15ff7")
        Assert.assertEquals(book,service?.assignBook(book!!,user!!)?.book)

    }



    @Test
    fun getAssignedBookTest(){
        val id = "c4f5a09f-4ec8-11ec-b9d4-991048f304af"
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