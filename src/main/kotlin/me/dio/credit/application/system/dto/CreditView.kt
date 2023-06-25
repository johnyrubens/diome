package me.dio.credit.application.system.dto

import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.enummeration.Status
import java.math.BigDecimal
import java.util.UUID

data class CreditView(
        val creditCode: UUID,
        val creditValue: BigDecimal,
        val numerOfInstallment: Int,
        val status : Status,
        val emailCustomer: String?,
        val incomeCustomer: BigDecimal?

) {
  constructor(credit: Credit) : this(
          creditCode = credit.creditCode,
          creditValue = credit.creditValue,
          numerOfInstallment = credit.numberOfInstallments,
          status = credit.status,
          emailCustomer = credit.customer?.email,
          incomeCustomer = credit.customer?.income
  )
}
