package com.zuhaib.FinalCaseAxis.service

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.PutObjectRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

@Service
class S3ServiceImpl {
    @Value("\${amazonProperties.bucketName}")
    private val bucketName: String? = null

    @Value("\${amazonProperties.endpointUrl}")
    private val endpointUrl: String? = null

    @Autowired
    private val s3Client: AmazonS3? = null

    fun uploadFile(file: MultipartFile): String {
        val fileObj = convertMultiPartFileToFile(file)
        val fileName = System.currentTimeMillis().toString() + "_" + file.originalFilename
        val fileUrl = "$endpointUrl/$bucketName/$fileName";
        val ree = s3Client!!.putObject(PutObjectRequest(bucketName, fileName, fileObj))
        fileObj!!.delete()
        return fileUrl
    }


    private fun convertMultiPartFileToFile(file: MultipartFile): File? {
        val convertedFile = File(file.originalFilename)
        try {
            FileOutputStream(convertedFile).use { fos -> fos.write(file.bytes) }
        } catch (e: IOException) {

        }
        return convertedFile
    }
}