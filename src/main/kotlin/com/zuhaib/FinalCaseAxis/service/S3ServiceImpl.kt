package com.zuhaib.FinalCaseAxis.service

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.PutObjectRequest
import com.amazonaws.services.s3.model.S3Object
import com.amazonaws.services.s3.model.S3ObjectInputStream
import com.amazonaws.util.IOUtils
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
        val fileName = file.originalFilename
        val fileUrl = "$endpointUrl/$bucketName/$fileName";
        val ree = s3Client!!.putObject(PutObjectRequest(bucketName, fileName, fileObj)
               .withCannedAcl(CannedAccessControlList.PublicRead))
        fileObj!!.delete()
        return fileUrl
    }

    fun downloadFile(fileName: String?): ByteArray? {
        val s3Object: S3Object = s3Client!!.getObject(bucketName, fileName)
        val inputStream: S3ObjectInputStream = s3Object.objectContent
        try {
            val content = IOUtils.toByteArray(inputStream)
            println(content)
            return content
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
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