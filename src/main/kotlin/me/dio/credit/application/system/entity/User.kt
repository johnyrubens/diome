package me.dio.credit.application.system.entity

import jakarta.persistence.*

@Entity
@Table(name = "User2")
data class User2(
  @Column(nullable = false, length = 30) var name: String = "",
  @Column(nullable = false, length = 30, unique = true) var userName: String = "",
  @Column(nullable = false, length = 32) var passWord: String = "",
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)
