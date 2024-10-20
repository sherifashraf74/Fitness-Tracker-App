package com.example.healthyfitness.presentation.screens.home_page1_screen

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthyfitness.presentation.screens.home_page1_screen.components.SensorUtils
import com.example.healthyfitness.presentation.screens.home_page1_screen.model.ExerciseType

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ExerciseViewModel(application: Application) : AndroidViewModel(application) {
    private val sensorUtils = SensorUtils(application)

    var walkingSteps by mutableStateOf(0)
    var cyclingSteps by mutableStateOf(0)
    var swimmingTime by mutableStateOf(0L)

    var isWalkingActive by mutableStateOf(false)
    var isCyclingActive by mutableStateOf(false)
    var isSwimmingActive by mutableStateOf(false)

    private var timerJob: Job? = null

    fun startExercise(type: ExerciseType) {
        when (type) {
            ExerciseType.WALKING -> startWalking()
            ExerciseType.CYCLING -> startCycling()
            ExerciseType.SWIMMING -> startSwimming()
        }
    }

    fun stopExercise(type: ExerciseType) {
        when (type) {
            ExerciseType.WALKING -> stopWalking()
            ExerciseType.CYCLING -> stopCycling()
            ExerciseType.SWIMMING -> stopSwimming()
        }
    }

    fun retryExercise(type: ExerciseType) {
        when (type) {
            ExerciseType.WALKING -> walkingSteps = 0
            ExerciseType.CYCLING -> cyclingSteps = 0
            ExerciseType.SWIMMING -> swimmingTime = 0L
        }
    }

    private fun startWalking() {
        isWalkingActive = true
        walkingSteps = 0
        sensorUtils.startStepCounting { steps ->
            walkingSteps = steps
        }
    }

    private fun stopWalking() {
        isWalkingActive = false
        sensorUtils.stopStepCounting()
        // Save walking session data if needed
    }

    private fun startCycling() {
        isCyclingActive = true
        cyclingSteps = 0
        sensorUtils.startStepCounting { steps ->
            cyclingSteps = steps
        }
    }

    private fun stopCycling() {
        isCyclingActive = false
        sensorUtils.stopStepCounting()
        // Save cycling session data if needed
    }

    private fun startSwimming() {
        isSwimmingActive = true
        swimmingTime = 0L
        timerJob = viewModelScope.launch {
            while (isSwimmingActive) {
                delay(1000)
                swimmingTime++
            }
        }
    }

    private fun stopSwimming() {
        isSwimmingActive = false
        timerJob?.cancel()
        // Save swimming session data if needed
    }

    fun formatTime(seconds: Long): String {
        val minutes = seconds / 60
        val remainingSeconds = seconds % 60
        return String.format("%02d:%02d", minutes, remainingSeconds)
    }

    override fun onCleared() {
        super.onCleared()
        sensorUtils.unregisterAllListeners()
        timerJob?.cancel()
    }
}