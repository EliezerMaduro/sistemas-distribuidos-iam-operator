package com.iam.manage_messages.controller

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import com.iam.manage_messages.services.RabbitMQSender
import org.springframework.beans.factory.annotation.Autowired

@RestController
class MessageController @Autowired constructor(private val rabbitMQSender: RabbitMQSender) {

    private val exchange = "user.signed_up"
    private val routingKey = "sign_up_email"

    @PostMapping("/send-message")
    fun sendMessageToQueue(@RequestBody message: Any): ResponseEntity<Any>{
        return rabbitMQSender.sendObjectToQueue(message, "user.sign_up_email")
    }
}
