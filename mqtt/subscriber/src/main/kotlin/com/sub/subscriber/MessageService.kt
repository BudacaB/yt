package com.sub.subscriber;

import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttException;

class MessageService(private val topic: String, private val broker: String) {

    fun subscribe() {

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

            // this function fires whenever there's a new message
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
