package com.zuhaib.FinalCaseAxis.service.Impl

import com.zuhaib.FinalCaseAxis.helper.CSVUtils
import com.zuhaib.FinalCaseAxis.model.helper.RevokeRequestModel
import kotlin.Throws
import java.io.IOException
import org.springframework.web.multipart.MultipartFile
import org.springframework.stereotype.Service

@Service
class CSVServiceImpl {
    private val csvUtils: CSVUtils? = null
    @Throws(IOException::class)
    fun uploadMultipart(file: MultipartFile): List<RevokeRequestModel> {
        val ot = CSVUtils.read(RevokeRequestModel::class.java, file.inputStream)
        println(ot)
        return ot
    }
}