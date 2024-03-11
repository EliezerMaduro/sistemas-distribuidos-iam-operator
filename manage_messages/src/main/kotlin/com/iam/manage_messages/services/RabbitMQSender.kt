package com.iam.manage_messages.services

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

@Service
class RabbitMQSender @Autowired constructor(private val amqpTemplate: AmqpTemplate, private val objectMapper: ObjectMapper) {

    fun sendObjectToQueue(obj: Any, queueName: String): ResponseEntity<Any> {
        val json = objectMapper.writeValueAsString(obj);
        amqpTemplate.convertAndSend(queueName, json);
        return ResponseEntity(obj, HttpStatus.OK);
    }
}