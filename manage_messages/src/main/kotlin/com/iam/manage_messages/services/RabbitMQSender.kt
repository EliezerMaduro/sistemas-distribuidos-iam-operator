package com.iam.manage_messages.services

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import com.iam.manage_messages.models.MessageType
import com.iam.manage_messages.models.Message

@Service
class RabbitMQSender @Autowired constructor(private val amqpTemplate: AmqpTemplate, private val objectMapper: ObjectMapper) {

    fun sendObjectToQueue(requestBody: Message): ResponseEntity<Any> {
        val messageType = requestBody.messageType
        val payload = requestBody.payload
        val queueName = determineQueueName(messageType)
        val json = objectMapper.writeValueAsString(payload);
        amqpTemplate.convertAndSend(queueName, json);
        return ResponseEntity(payload, HttpStatus.OK);
    }

    fun determineQueueName(messageType: String): String {
        return MessageType.valueOf(messageType).queueName
    }


}