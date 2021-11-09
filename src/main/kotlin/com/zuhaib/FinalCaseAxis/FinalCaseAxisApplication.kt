package com.zuhaib.FinalCaseAxis

import com.zuhaib.FinalCaseAxis.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FinalCaseAxisApplication : CommandLineRunner {

    override fun run(vararg args: String?) {
        println("Application Starting")
    }
}


fun main(args: Array<String>) {
	runApplication<FinalCaseAxisApplication>(*args)
}
