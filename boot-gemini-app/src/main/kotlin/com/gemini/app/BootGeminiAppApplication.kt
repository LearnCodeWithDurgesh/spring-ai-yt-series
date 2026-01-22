package com.gemini.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BootGeminiAppApplication

fun main(args: Array<String>) {
    runApplication<BootGeminiAppApplication>(*args)
}
