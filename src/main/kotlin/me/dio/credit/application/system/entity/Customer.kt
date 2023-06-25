package me.dio.credit.application.system.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "Customer")
data class Customer(
        @Column(nullable = false, length = 30) var firstName: String = "",
        @Column(nullable = false, length = 30) var lastName: String = "",
        @Column(nullable = false, length = 11, unique = true) var cpf: String = "",
        @Column(nullable = false, unique = true) var email: String = "",
        @Column(nullable = false) var income: BigDecimal = BigDecimal.ZERO,
        @Column(nullable = false, length = 32) var password: String = "",
        @Column(nullable = false, length = 30) @Embedded var address: Address = Address(),
        @Column(nullable = false) @OneToMany(fetch = FetchType.LAZY,
                cascade = arrayOf(CascadeType.REMOVE, CascadeType.PERSIST),
                mappedBy = "customer"
        ) var credits: List<Credit> = mutableListOf(),
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)
