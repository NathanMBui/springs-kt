package com.nathanmbui.restservice.database.jpa

import com.nathanmbui.restservice.database.Customer
import org.springframework.data.repository.CrudRepository

interface CustomerRepository: CrudRepository<Customer, Long> {
    fun findByFirstName(firstName: String): Customer?
    fun findByLastName(lastName: String): Iterable<Customer>
}