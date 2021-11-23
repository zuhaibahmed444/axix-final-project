package com.zuhaib.FinalCaseAxis

import com.zuhaib.FinalCaseAxis.model.User
import com.zuhaib.FinalCaseAxis.repo.UserRepository
import com.zuhaib.FinalCaseAxis.service.UserService
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest {

    @Autowired
    val service : UserService?=null
    @Mock
    val userRepository : UserRepository?=null

    val user = User("John Smith","johnsmith@email.com","123654789","johnsmith123")

    @Test
    fun saveUserTest() {
        `when`(userRepository!!.save(user)).thenReturn(user)
        assertEquals(user,service?.createUser(user))

    }

    @Test
    fun getUserTest(){
        val email = "johnsmith@email.com"
        `when`(userRepository?.findByEmail(email))
                .thenReturn(user)
        assertEquals(user.name,service?.getUser(email)?.name)
    }

    @Test
    fun getUsersTest(){
        val users = service?.getUsers()
        assertTrue(users!!.isNotEmpty())
    }
    @Test
    fun getUserByIdTest(){
        val id = "06d612fd-4173-11ec-90c5-7fe4d8410484"
        assertEquals("zuhaibahmed444@gmail.com",service?.getUserById(id)?.email)
    }

}