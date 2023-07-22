package me.dio.credit.application.system.dto

import jakarta.validation.constraints.NotEmpty
import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal

data class CustomerDto (
        @field:NotEmpty(message = "campo firtName não pode ser sem valor") val firstName: String,
        val lastName: String,
        @field:NotEmpty(message = "campo cpf não pode estar em branco") val cpf: String,
        val income: BigDecimal,
        val email: String,
        val password: String,
        val zipcode: String,
        val street: String
) {
    fun toEntity(): Customer = Customer(
            firstName = this.firstName,
            lastName = this.lastName,
            cpf = this.cpf,
            income = this.income,
            email = this.email,
            password = this.password,
            address = Address(
                    zipCode = this.zipcode,
                    street = this.street
            )
    )
}


