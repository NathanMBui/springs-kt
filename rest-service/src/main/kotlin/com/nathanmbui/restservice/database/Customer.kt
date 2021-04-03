package com.nathanmbui.restservice.database

import javax.persistence.*

@Entity
class Customer(
        var firstName: String,
        var lastName: String,
        @Id @GeneratedValue var id: Long? = null)
