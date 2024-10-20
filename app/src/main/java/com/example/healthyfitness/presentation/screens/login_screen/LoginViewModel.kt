package com.example.healthyfitness.presentation.screens.login_screen


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthyfitness.data.data_source.remote.retrofit.api.responses.LoginResponse
import com.example.healthyfitness.data.data_source.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {
    private val _loginResult = MutableLiveData<Result<LoginResponse>>()
    val loginResult: LiveData<Result<LoginResponse>> = _loginResult

    private val _validationErrors = MutableLiveData<Map<String, String>>(emptyMap())
    val validationErrors: LiveData<Map<String, String>> = _validationErrors

    fun login(email: String, password: String) {
        val errors = validateInput(email, password)
        if (errors.isNotEmpty()) {
            _validationErrors.value = errors
            return
        }

        viewModelScope.launch {
            try {
                _loginResult.value = repository.logIn(email, password)
            } catch (e: Exception) {
                _loginResult.value = Result.failure(e)
            }
        }
    }
    private fun validateInput(email: String, password: String): Map<String, String> {
        val errors = mutableMapOf<String, String>()

        if (!isValidEmail(email)) {
            errors["email"] = "Invalid email format"
        }

        if (password.isBlank()) {
            errors["password"] = "Password cannot be empty"
        }

        return errors
    }

    private fun isValidEmail(email: String): Boolean {
        return email.contains("@") && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun clearFieldErrorLogin(field: String) {
        _validationErrors.value = _validationErrors.value?.toMutableMap()?.apply { remove(field) }
    }
}
