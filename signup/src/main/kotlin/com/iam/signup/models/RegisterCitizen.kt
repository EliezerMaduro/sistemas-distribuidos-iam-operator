package com.iam.signup.models

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import lombok.Getter
import lombok.Setter

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
data class RegisterCitizen(
    val id: Int,
    val name: String,
    val email: String,
    val address: String,
    val operatorName: String,
    val operatorId: String
)