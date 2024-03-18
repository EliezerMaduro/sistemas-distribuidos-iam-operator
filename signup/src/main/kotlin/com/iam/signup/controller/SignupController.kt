package com.iam.signup.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import software.amazon.awssdk.services.cognitoidentityprovider.model.AuthenticationResultType
import javax.validation.Valid
import com.iam.signup.services.AuthService
import com.iam.signup.models.*

@RestController
@RequestMapping("/v1/idp")
class SignupController @Autowired constructor(private val authService: AuthService){

    @PostMapping("/signup")
    fun login(@Valid @RequestBody request: SignupRequest): ResponseEntity<LoginResponse> {
        val result: AuthenticationResultType = authService.initiateAuth(request.username, request.password)
        val loginResponse = LoginResponse(result.accessToken(), result.idToken(), result.expiresIn())
        return ResponseEntity.ok(loginResponse)
    }
}