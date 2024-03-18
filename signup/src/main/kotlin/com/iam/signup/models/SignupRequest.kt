package com.iam.signup.models

data class SignupRequest(
    @NotBlank val username: String,
    @NotBlank val password: String
)