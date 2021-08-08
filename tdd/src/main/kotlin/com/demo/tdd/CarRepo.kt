package com.demo.tdd

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CarRepo: CrudRepository<Car, UUID>
