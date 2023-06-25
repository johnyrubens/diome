package me.dio.credit.application.system.entity

import jakarta.persistence.*

@Entity
@Table(name = "Roles")
data class Roles(
    @Column(nullable = false, length = 20) var name: String = "",
    //@ManyToOne var user: User? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)
