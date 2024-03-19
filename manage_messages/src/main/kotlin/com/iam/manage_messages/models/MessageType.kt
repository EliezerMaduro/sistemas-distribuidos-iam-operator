package com.iam.manage_messages.models

enum class MessageType(val queueName: String) {
    SIGN_UP("user.sign_up"),
    TYPE_B("cola_b"),
    TYPE_C("cola_c")
}