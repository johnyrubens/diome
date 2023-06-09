package me.dio.credit.application.system.repository

import me.dio.credit.application.system.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.UUID

interface CreditRepository: JpaRepository<Credit, Long> {
    fun findByCreditCode(creditCode: UUID) : Credit?

    @Query(value = "select * from credit where custumer_id = ?1", nativeQuery = true)
    fun findAllByCredits(customerId: Long) : List<Credit>
}