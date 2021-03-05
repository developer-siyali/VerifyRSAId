package com.example.validatersa_id

import org.junit.Assert.*
import org.junit.Test

class PresenterMainActivityTest {

    private val classUnderTest = PresenterMainActivity()

    @Test
    fun `verify if the input is correct`() {
        //GIVEN
        val mockIdNumber = "9310295450081"

        //WHEN
        val isIdNumberCorrect = classUnderTest.validateID(mockIdNumber)

        //THEN
        assertEquals(false, isIdNumberCorrect)
    }
}