package com.iam.signup.models

import javax.validation.constraints.NotBlank

data class SignupRequest(
    @NotBlank val username: String,
    @NotBlank val password: String
)