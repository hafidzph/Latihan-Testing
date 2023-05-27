package com.hafidz.testapp

import org.junit.Assert.assertEquals
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun validUsernameAndCorrectlyRepeatedPassword_returnsTrue() {
        val result = RegistrationUtil.validateRegistrationInput(
            "hafidz",
            "hafidz123",
            "hafidz123"
        )
        assertEquals(true, result)
    }

    @Test
    fun validUsernameAndCorrectlyRepeatedPassword_returnsFalse() {
        val result = RegistrationUtil.validateRegistrationInput(
            "hafidz",
            "hafidz12",
            "hafidz123"
        )
        assertEquals(false, result)
    }

    @Test
    fun usernameEmpty() {
        val result = RegistrationUtil.validateRegistrationInput("", "1234", "1234")
        assertEquals("OK", result, false)
    }

    @Test
    fun passwordEmpty() {
        val result = RegistrationUtil.validateRegistrationInput("qwerty", "", "1234")
        assertEquals(result, false)
    }

    @Test
    fun confirmPasswordEmpty() {
        val result = RegistrationUtil.validateRegistrationInput("qwerty", "1234", "")
        assertEquals(result, false)
    }

    @Test
    fun usernameExists() {
        val result = RegistrationUtil.validateRegistrationInput("Tyrang", "1234", "1234")
        assertEquals(false, result)
    }

    @Test
    fun passwordMismatch_returnsFalse() {
        val result = RegistrationUtil.validateRegistrationInput("qwerty", "1234", "5678")
        assertEquals(false, result)
    }

    @Test
    fun passwordLengthLessThanTwo() {
        val result = RegistrationUtil.validateRegistrationInput("qwerty", "1", "1")
        assertEquals(false, result)
    }

    @Test
    fun passwordLengthMoreThanTwo() {
        val result = RegistrationUtil.validateRegistrationInput("qwerty", "1234", "1234")
        assertEquals(true, result)
    }
}
