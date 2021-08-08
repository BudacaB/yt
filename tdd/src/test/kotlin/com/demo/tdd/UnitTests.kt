package com.demo.tdd

import org.assertj.core.api.Assertions
import org.jeasy.random.EasyRandom
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.doReturn
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
class UnitTests {

    val generator = EasyRandom()

    val carRepo = Mockito.mock(CarRepo::class.java)

    @Autowired
    val stringUtilities: StringUtilities = StringUtilities()

    @Autowired
    val carService = CarService(carRepo)

    @Test
    fun `should join two strings`() {
        Assertions.assertThat(stringUtilities.joinTwoString("test", "string")).isEqualTo("teststring")
        Assertions.assertThat(stringUtilities.joinTwoString("test", "ohoh")).isEqualTo("testohoh")
    }

    @Test
    fun `should add a car`() {
        // Arrange
        var car = generator.nextObject(Car::class.java)
        doReturn(car).`when`(carRepo).save(car)

        // Act
        var result = carService.addCar(car)

        // Assert
        Assertions.assertThat(result).isEqualTo(car)
    }
}