package com.hafidz.testapp

object RegistrationUtil {
    private val existingUsers = listOf("Tyrang", "Sohram", "Sule", "Rima")

    fun validateRegistrationInput(
        username: String,
        password: String,
        confirmPassword: String
    ): Boolean{
        if(username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) return false
        if(username in existingUsers) return false
        if(password != confirmPassword) return false
        if(password.count() < 2) return false
        return true
    }
}