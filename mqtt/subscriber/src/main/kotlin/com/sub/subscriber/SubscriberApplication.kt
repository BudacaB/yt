package com.sub.subscriber

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class SubscriberApplication

fun main(args: Array<String>) {
	runApplication<SubscriberApplication>(*args)

	val topic = "topic"
	val broker = "tcp://127.0.0.1:1883"

	val messageService = MessageService(topic, broker)
	messageService.subscribe()

}
