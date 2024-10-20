package com.example.healthyfitness.presentation.screens.all_cardio_work

import com.example.healthyfitness.presentation.screens.common_components.Exercise
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.healthyfitness.MyApplication
import com.example.healthyfitness.data.data_source.local.FitnessDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext

class CardioExerciseViewModel : ViewModel() {
    private val _exercises = MutableStateFlow<List<Exercise>>(emptyList())
    val exercises: StateFlow<List<Exercise>> = _exercises

    private var cardioDao = FitnessDatabase.getDaoInstance(MyApplication.getApplicationContext())

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow("")
    val errorMessage: StateFlow<String> = _errorMessage

    fun fetchExercises() {
        _isLoading.value = true

        viewModelScope.launch {
            try {
                val response = getAllCardioExercise()
                _exercises.value = response
            } catch (e: Exception) {
                _errorMessage.value = e.message ?: "An error occurred"
            } finally {
                _isLoading.value = false
            }
        }
    }

    private suspend fun getAllCardioExercise() = withContext(Dispatchers.IO) {
        try {
            val response = CardioRetrofitInstance.api.getExercises()
            cardioDao.insertAllExercises(response)
            return@withContext response
        } catch (e: Exception) {
            val response = cardioDao.getAllPartExercises().filter { it.bodyPart == "cardio" }
            return@withContext response
        }

    }

    suspend fun getCardioExerciseById(id : String) = withContext(Dispatchers.IO) {
        try {
            val exercise = cardioDao.getExerciseById(id)
            return@withContext exercise
        }
        catch (e:Exception){
            throw (e)
        }
    }
}