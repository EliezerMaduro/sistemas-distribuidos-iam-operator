package com.iam.manage_messages.models
import javax.validation.constraints.NotBlank

data class Message(
    @NotBlank val messageType: String,
    @NotBlank val payload: Map<String,*>
)