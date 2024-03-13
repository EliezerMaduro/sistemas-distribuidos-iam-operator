package com.iam.login.services

import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient
import software.amazon.awssdk.services.cognitoidentityprovider.model.AuthenticationResultType
import software.amazon.awssdk.services.cognitoidentityprovider.model.InitiateAuthRequest
import software.amazon.awssdk.services.cognitoidentityprovider.model.InitiateAuthResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Value
import com.iam.login.models.*
import java.nio.charset.StandardCharsets
import java.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

@Service
class AuthService @Autowired constructor(
    private val cognitoClient: CognitoIdentityProviderClient,
    @Value("\${cognito.clientId}") private val userPoolClientId: String,
    @Value("\${cognito.clientSecret}") private val userPoolClientSecret: String
) {
    public fun initiateAuth(username: String, password: String): AuthenticationResultType {
        val secretHash = calculateSecretHash(username)
        val initiateAuthRequest = InitiateAuthRequest.builder()
            .clientId(userPoolClientId)
            .authFlow("USER_PASSWORD_AUTH")
            .authParameters(mapOf("USERNAME" to username, "PASSWORD" to password, "SECRET_HASH" to secretHash))
            .build()

        val response: InitiateAuthResponse = cognitoClient.initiateAuth(initiateAuthRequest)
        return response.authenticationResult()
    }

    private fun calculateSecretHash(username: String): String {
        val HMAC_SHA256_ALGORITHM = "HmacSHA256"
        
        val signingKey = SecretKeySpec(
                userPoolClientSecret.toByteArray(StandardCharsets.UTF_8),
                HMAC_SHA256_ALGORITHM)
        try {
            val mac = Mac.getInstance(HMAC_SHA256_ALGORITHM)
            mac.init(signingKey)
            mac.update(username.toByteArray(StandardCharsets.UTF_8))
            val rawHmac = mac.doFinal(userPoolClientId.toByteArray(StandardCharsets.UTF_8))
            return Base64.getEncoder().encodeToString(rawHmac)
        } catch (e: Exception) {
            throw RuntimeException("Error while calculating secret hash", e)
        }
    }

}