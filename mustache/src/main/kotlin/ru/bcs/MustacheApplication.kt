package ru.bcs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MustacheApplication
    fun main(args: Array<String>) {
        runApplication<MustacheApplication>(*args)
    }