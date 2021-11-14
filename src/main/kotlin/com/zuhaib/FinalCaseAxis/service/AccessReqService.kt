package com.zuhaib.FinalCaseAxis.service

import com.zuhaib.FinalCaseAxis.model.AccessReq

interface AccessReqService {
    fun saveAccessReq(accessReq: AccessReq) : AccessReq?
    fun getAccessReq(id: String) : AccessReq?
    fun getActiveAccessReq() : List<AccessReq>?
    fun updateAccessReq(accessReq: AccessReq) : AccessReq?
    fun getAllAccessReq() : List<AccessReq>?
}