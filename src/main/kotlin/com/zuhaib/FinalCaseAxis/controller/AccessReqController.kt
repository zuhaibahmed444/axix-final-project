package com.zuhaib.FinalCaseAxis.controller

import com.zuhaib.FinalCaseAxis.model.AccessReq
import com.zuhaib.FinalCaseAxis.service.AccessReqService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/accessreq")
@CrossOrigin("*")
class AccessReqController {

    @Autowired
    val accessReqService: AccessReqService? = null

    @PostMapping("/")
    fun accessReq(@RequestBody accessReq: AccessReq): AccessReq? {
        println(accessReq.bookId)
        return accessReqService!!.saveAccessReq(accessReq)
    }

    @GetMapping("/")
    fun getAllAccessReq(): List<AccessReq>? {
        return accessReqService!!.getAllAccessReq()
    }

    @PostMapping("/update")
    fun updateAccessReq(@RequestBody accessReq: AccessReq): AccessReq? {
        return accessReqService!!.updateAccessReq(accessReq)
    }
    @GetMapping("/active")
    fun getActiveAccessReq(): List<AccessReq>? {
        return accessReqService!!.getActiveAccessReq()
    }

    @GetMapping("/{id}")
    fun getAccessReqById(@PathVariable id: String): AccessReq? {
        return accessReqService!!.getAccessReq(id)
    }

    @PostMapping("/user")
    fun getAccessReqByUser(@RequestBody email:String):List<AccessReq>?{
        return accessReqService!!.getAllByUser(email)
    }


}