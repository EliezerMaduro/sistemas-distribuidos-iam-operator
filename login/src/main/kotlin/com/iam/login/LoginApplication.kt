package com.iam.login

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient

@SpringBootApplication
class LoginApplication{
	@Bean
    fun cognitoClient(): CognitoIdentityProviderClient {
        return CognitoIdentityProviderClient.builder()
            .region(Region.US_EAST_1)
            .build()
    }
}

fun main(args: Array<String>) {
	runApplication<LoginApplication>(*args)
}
