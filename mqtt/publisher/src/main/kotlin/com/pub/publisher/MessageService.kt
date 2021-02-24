package com.pub.publisher

import org.eclipse.paho.client.mqttv3.*

class MessageService(private val topic: String, private val broker: String) {

    fun publish(message: String) {

        // get a random client ID
        val clientId = MqttAsyncClient.generateClientId()

        try {
            val mqttClient = MqttClient(broker, clientId)
            val connOpts = MqttConnectOptions()

            // configute connection options
            connOpts.isCleanSession = true
            connOpts.isAutomaticReconnect = true
            connOpts.connectionTimeout = 10

            mqttClient.connect(connOpts)
            mqttClient.publish(topic, MqttMessage(message.toByteArray()))
            mqttClient.disconnect()

            println("Message published")
        } catch (e: MqttException) {
            println(e)
        }
    }
}