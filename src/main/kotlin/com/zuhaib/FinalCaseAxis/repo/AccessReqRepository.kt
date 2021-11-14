package com.zuhaib.FinalCaseAxis.repo

import com.zuhaib.FinalCaseAxis.model.AccessReq
import org.springframework.data.mongodb.repository.MongoRepository

interface AccessReqRepository:MongoRepository<AccessReq,String> {
    fun findByActive(active:Boolean):List<AccessReq>
    fun findByBookIdAndUserEmail(bookId:String,userEmail:String):AccessReq?
}