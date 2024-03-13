package com.iam.login.controller.AuthController

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import software.amazon.awssdk.services.cognitoidentityprovider.model.AuthenticationResultType
import javax.validation.Valid
import com.iam.login.services.AuthService
import com.iam.login.models.*

@RestController
@RequestMapping("/v1/idp")
class AuthController @Autowired constructor(private val authService: AuthService){

    @PostMapping("/login")
    fun login(@Valid @RequestBody request: LoginRequest): ResponseEntity<LoginResponse> {
        val result: AuthenticationResultType = authService.initiateAuth(request.username, request.password)
        val loginResponse = LoginResponse(result.accessToken(), result.idToken(), result.expiresIn())
        return ResponseEntity.ok(loginResponse)
    }
}
