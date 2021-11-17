package com.zuhaib.FinalCaseAxis.service.Impl

import com.fasterxml.uuid.Generators
import com.zuhaib.FinalCaseAxis.helper.UserException
import com.zuhaib.FinalCaseAxis.model.AccessReq
import com.zuhaib.FinalCaseAxis.repo.AccessReqRepository
import com.zuhaib.FinalCaseAxis.service.AccessReqService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.jvm.Throws

@Service
class AccessReqServiceImpl: AccessReqService {

    @Autowired
    val accessReqRepository: AccessReqRepository? = null

    @Throws(Exception::class)
    override fun saveAccessReq(accessReq: AccessReq): AccessReq? {
        var bookid = accessReq.bookId
        var useremail = accessReq.userEmail
        if (accessReqRepository!!.findByBookIdAndUserEmail(bookid!!, useremail!!) !== null) {
            throw UserException("Access Request Already Exists")
        }else{
        accessReq.reqID = Generators.timeBasedGenerator().generate().toString()
        return accessReqRepository!!.save(accessReq)
        }
    }

    override fun updateAccessReq(accessReq: AccessReq): AccessReq? {
        return accessReqRepository!!.save(accessReq)
    }

    override fun getAllAccessReq(): List<AccessReq>? {
        return accessReqRepository!!.findAll()
    }

    override fun getAllByUser(email: String): List<AccessReq>? {
        return accessReqRepository!!.findByUserEmail(email)
    }


    override fun getAccessReq(id: String): AccessReq? {
        return accessReqRepository!!.findById(id).orElse(null)
    }

    override fun getActiveAccessReq(): List<AccessReq>? {
        return accessReqRepository?.findByActive(true)
    }




}
