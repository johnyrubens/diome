package me.dio.credit.application.system.service.impl

import me.dio.credit.application.system.entity.Customer
import me.dio.credit.application.system.exception.BusinessException
import me.dio.credit.application.system.repository.CustomerRepository
import me.dio.credit.application.system.service.ICustomerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustomerService(private val customerRepository: CustomerRepository): ICustomerService {
    override fun save(custumer: Customer): Customer {
        val cpf = this.customerRepository.findByCpf(custumer.cpf)
        return this.customerRepository.save(custumer)
    }

    override fun findById(id: Long): Customer {
        return this.customerRepository.findById(id).orElseThrow{
            throw BusinessException("Id $id not found")
        }
    }

    override fun delete(id: Long) {
        this.customerRepository.deleteById(id)
    }
}
