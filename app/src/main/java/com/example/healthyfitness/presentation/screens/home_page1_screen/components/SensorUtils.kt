package com.example.healthyfitness.presentation.screens.home_page1_screen.components

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class SensorUtils(context: Context) : SensorEventListener {
    private val sensorManager: SensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val stepSensor: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)

    private var stepCount = 0
    private var stepCallback: ((Int) -> Unit)? = null

    fun startStepCounting(callback: (Int) -> Unit) {
        stepCount = 0
        stepCallback = callback
        stepSensor?.let { sensor ->
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    fun stopStepCounting() {
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_STEP_DETECTOR) {
            stepCount++
            stepCallback?.invoke(stepCount)
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    fun unregisterAllListeners() {
        sensorManager.unregisterListener(this)
    }
}