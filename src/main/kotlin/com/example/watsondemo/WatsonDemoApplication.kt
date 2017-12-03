package com.example.watsondemo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class WatsonDemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(WatsonDemoApplication::class.java, *args)
}
