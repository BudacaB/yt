package com.demo.tdd

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Car (
    @Id
    @GeneratedValue
    val id: UUID,
    var make: String,
    var model: String
    )
