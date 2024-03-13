package com.iam.login.models

import javax.validation.constraints.NotBlank

data class LoginResponse(
    val accessToken: String,
    val idToken: String,
    val expiresIn: Int
)