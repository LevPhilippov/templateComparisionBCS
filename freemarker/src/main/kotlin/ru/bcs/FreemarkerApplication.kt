package ru.bcs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication

class FreemarkerApplication

    fun main(args: Array<String>) {
        runApplication<FreemarkerApplication>(*args)
    }