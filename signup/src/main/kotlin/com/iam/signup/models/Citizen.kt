package com.iam.signup.models

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@NoArgsConstructor
@AllArgsConstructor
data class Citizen(
    val idCitizen: String,
    val name: String,
    val email: String,
    val address: String,
    val phone_number: String
){
    // Constructor primario
    constructor() : this("", "", "", "", "")
}
