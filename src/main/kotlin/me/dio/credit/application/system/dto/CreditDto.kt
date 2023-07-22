package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotEmpty
import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
        val creditValue: BigDecimal,
        @field:Future(message = "Data não pode ser retroativa ") val dayFirstOfInstallment: LocalDate,
        val numberOfInstallments: Int,
        val customerId: Long
) {
    fun toEntity(): Credit = Credit(
            creditValue = this.creditValue,
            dayFistInstallment = this.dayFirstOfInstallment,
            numberOfInstallments = this.numberOfInstallments,
            customer = Customer(id = this.customerId)
    )

}
