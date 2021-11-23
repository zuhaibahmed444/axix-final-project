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

    val accessreq = AccessReq("b03101dc-41f4-11ec-bdb5-ef1318946000","xyz","zuhaibahmed444@gmail.com",true)

    @Test
    fun saveRequestTest(){
        `when`(accessReqRepository?.save(accessreq)).thenReturn(accessreq)
        Assert.assertEquals(accessreq, service?.saveAccessReq(accessreq))
    }
    @Test
    fun getRequestTest(){
        val id ="5b027cf2-47cd-11ec-a84f-59d8e2718fdb"
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