package com.sub.subscriber;

import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttException;

class MessageService(private val topic: String, private val broker: String) {

    fun subscribe() {

        val clientId = MqttAsyncClient.generateClientId()

        try {
            val mqttClient = MqttClient(broker, clientId)
            val connOpts = MqttConnectOptions()

            connOpts.isCleanSession = true
            connOpts.isAutomaticReconnect = true
            connOpts.connectionTimeout = 10

            mqttClient.connect(connOpts)
            mqttClient.subscribeWithResponse(topic) { _, msg ->
                sendNotificationOrEmailForNewStuff(String(msg.payload))
            }

        } catch (e: MqttException) {
            println(e)
        }
    }

    fun sendNotificationOrEmailForNewStuff(message: String) {
        println(message)
    }
}
