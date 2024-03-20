package com.iam.signup

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.beans.factory.annotation.Value
import org.springframework.beans.factory.annotation.Autowired
import com.fasterxml.jackson.databind.ObjectMapper

import com.iam.signup.models.Citizen
import com.iam.signup.models.RegisterCitizen

import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

@SpringBootApplication
class SignUpSubscriberService {

    @Value("\${rabbitmq.queueName}")
    private lateinit var queueName: String

    @Value("\${operator.name}")
    private lateinit var operatorName: String

    @Value("\${operator.id}")
    private lateinit var operatorId: String

    @Value("\${govcarpeta.url}")
    private lateinit var govCarpetaUrl: String

    @RabbitListener(queues = ["\${rabbitmq.queueName}"])
    fun handleMessage(message: String) {
        val citizen : Citizen = mapMessageToCitizen(message)
        val gson = Gson()
        val registerCitizen = RegisterCitizen(
            id = citizen.idCitizen.toInt(),
            name = citizen.name,
            email = citizen.email,
            address = citizen.address,
            operatorName = operatorName,
            operatorId = operatorId
        )

        val json = gson.toJson(registerCitizen)
        println(json)
        val requestBody = json.toRequestBody("application/json; charset=utf-8".toMediaType())

        val client = OkHttpClient()

        val request = Request.Builder()
            .url(govCarpetaUrl)
            .post(requestBody)
            .build()

        try {
            val response = client.newCall(request).execute()
            val responseBody = response.body?.string()
            println("Respuesta del servidor:")
            println(responseBody)
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun getQueueName(): String {
        return queueName
    }

    fun mapMessageToCitizen(message: String): Citizen {
        val objectMapper = ObjectMapper()
        return objectMapper.readValue(message, Citizen::class.java)
    }
}

fun main(args: Array<String>) {
    runApplication<SignUpSubscriberService>(*args)
}
