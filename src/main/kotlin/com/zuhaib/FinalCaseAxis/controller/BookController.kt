package com.zuhaib.FinalCaseAxis.controller

import com.google.gson.Gson
import com.zuhaib.FinalCaseAxis.model.Book
import com.zuhaib.FinalCaseAxis.model.helper.BookHelperModel
import com.zuhaib.FinalCaseAxis.service.BookService
import com.zuhaib.FinalCaseAxis.service.S3ServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ByteArrayResource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.*

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
class BookController {

    @Autowired
    val s3ServiceImpl: S3ServiceImpl? = null

    @Autowired
    val bookService: BookService? = null


    @PostMapping("/")
    fun upload(@RequestParam("book") book:String, @RequestParam("image") image : MultipartFile, @RequestParam("file") file:MultipartFile ) : Book? {
        val imagename = image.originalFilename
        val filename : String? = file.originalFilename
        val gson : Gson = Gson()
        val bookHelperModel : BookHelperModel = gson.fromJson(book,BookHelperModel::class.java)

        val url  = s3ServiceImpl!!.uploadFile(file)
        val imageUrl = s3ServiceImpl!!.uploadFile(image)
        val book : Book = Book(bookHelperModel.bookName,bookHelperModel.bookAuthor,bookHelperModel.yearPublished,url,filename,imagename,imageUrl)

        return bookService!!.uploadBook(book)


    }

    @GetMapping("/")
    fun getAllBooks() : List<Book>? {
        return bookService!!.getAllBooks()
    }

    @PostMapping("/download")
    fun download(@RequestBody id:String) : String {
        val book : Book? = bookService!!.getBookById(id)
        var filename : String? = book?.filename
        val file : ByteArray? = s3ServiceImpl!!.downloadFile(filename!!)
        val bb : String = Base64.getEncoder().encodeToString(file)
        return bb

    }

    @GetMapping("/download/{id}")
    fun downloadfile(@PathVariable id:String) : ResponseEntity<*> {
        val book : Book? = bookService!!.getBookById(id)
        var filename : String? = book?.filename
        val data : ByteArray? = s3ServiceImpl!!.downloadFile(filename!!)
        val resource = data?.let { ByteArrayResource(it) }

            return ResponseEntity.ok()
                .contentLength(data?.size!!.toLong())
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"$filename\"")
                .body(resource)
    }

    @GetMapping("/{id}")
    fun getBook(@PathVariable("id") id:String) : Book? {
        return bookService?.getBookById(id)
    }

    @GetMapping("/count")
    fun getBookCount() : ResponseEntity<*> {
        val count = bookService?.getAllBooks()?.size
        return ResponseEntity.ok(count)
    }

}