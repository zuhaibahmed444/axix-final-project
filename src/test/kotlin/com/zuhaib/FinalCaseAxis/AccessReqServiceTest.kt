package com.zuhaib.FinalCaseAxis

import com.zuhaib.FinalCaseAxis.model.AccessReq
import com.zuhaib.FinalCaseAxis.repo.AccessReqRepository
import com.zuhaib.FinalCaseAxis.service.AccessReqService
import org.junit.Assert
import org.junit.Assert.*
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AccessReqServiceTest {

    @Autowired
    val service : AccessReqService?=null

    @Mock
    val accessReqRepository : AccessReqRepository ?=null

    val accessreq = AccessReq("1784dc80-5343-11ec-98af-53f96f86804e","Java","zuhaibahmed444@gmail.com",true)

    @Test
    fun saveRequestTest(){
        `when`(accessReqRepository?.save(accessreq)).thenReturn(accessreq)
        Assert.assertEquals(accessreq, service?.saveAccessReq(accessreq))
    }
    @Test
    fun getRequestTest(){
        val id ="b017ad8c-4ec8-11ec-b9d4-a7950e1caace"
        Assert.assertEquals(id,service?.getAccessReq(id)?.reqID)
    }

    @Test
    fun getAllRequestTest(){
        assertTrue(service?.getAllAccessReq()!!.isNotEmpty())
    }

    @Test
    fun getAccessRequestByUserTest(){
        val email = "zuhaibahmeds27@gmail.com"
        val req = service?.getAllByUser(email)
        val em = req!![0].userEmail
        assertEquals(email,em)
    }


}