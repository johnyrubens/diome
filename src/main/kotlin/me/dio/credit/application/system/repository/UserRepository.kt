package me.dio.credit.application.system.repository

import me.dio.credit.application.system.entity.User2
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository: JpaRepository<User2, Long> {
    @Query(value = "select e from User e where e.userName = ?1", nativeQuery = true)
    fun findByUserName(userName: String) : User2
}