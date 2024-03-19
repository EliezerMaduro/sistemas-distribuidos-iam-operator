package com.iam.manage_messages.controller

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import com.iam.manage_messages.services.RabbitMQSender
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping

import com.iam.manage_messages.models.Message

@RestController
@RequestMapping("/v1")
class MessageController @Autowired constructor(private val rabbitMQSender: RabbitMQSender) {

    @PostMapping("/send-message")
    fun sendMessageToQueue(@RequestBody message: Message): ResponseEntity<Any>{
        return rabbitMQSender.sendObjectToQueue(message)
    }
}
