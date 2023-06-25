package me.dio.credit.application.system.entity

import jakarta.persistence.*

@Entity
@Table(name = "User")
data class User(
  @Column(nullable = false, length = 30) var name: String = "",
  @Column(nullable = false, length = 30) var userName: String = "",
  @Column(nullable = false, length = 32) var passWord: String = "",
//  @Column(nullable = false) @OneToMany(fetch = FetchType.LAZY,
//          cascade = arrayOf(CascadeType.REMOVE, CascadeType.PERSIST),
//          mappedBy = "user"
//  ) var roles: List<Roles> = mutableListOf(),
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)
