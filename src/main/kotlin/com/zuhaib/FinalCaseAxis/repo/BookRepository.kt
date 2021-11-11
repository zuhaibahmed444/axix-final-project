package com.zuhaib.FinalCaseAxis.repo

import com.zuhaib.FinalCaseAxis.model.Book
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository:MongoRepository<Book,String> {
}