package com.demo.tdd

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TddApplication

fun main(args: Array<String>) {
	runApplication<TddApplication>(*args)
}
