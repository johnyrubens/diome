package me.dio.credit.application.system.service.impl

import me.dio.credit.application.system.entity.Customer
import me.dio.credit.application.system.repository.CustomerRepository
import me.dio.credit.application.system.service.ICustomerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustomerService(private val customerRepository: CustomerRepository): ICustomerService {
    override fun save(custmer: Customer): Customer {
        return this.customerRepository.save(custmer)
    }

    override fun findById(id: Long): Customer {
        return this.customerRepository.findById(id).orElseThrow{
            throw RuntimeException("Id $id not found")
        }
    }

    override fun delete(id: Long) {
        this.customerRepository.deleteById(id)
    }
}
