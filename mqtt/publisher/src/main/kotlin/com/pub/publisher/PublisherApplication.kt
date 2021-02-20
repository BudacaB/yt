package com.pub.publisher

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class PublisherApplication

fun main(args: Array<String>) {
	runApplication<PublisherApplication>(*args)

	notifyEmailOrNotificationService()

}

fun notifyEmailOrNotificationService() {
	val topic = "topic"
	val broker = "tcp://127.0.0.1:1883"

	val messageService = MessageService(topic, broker)
	messageService.publish("New stuff")
}
