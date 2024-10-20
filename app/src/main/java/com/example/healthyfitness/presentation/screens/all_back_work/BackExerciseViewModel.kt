import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.healthyfitness.MyApplication
import com.example.healthyfitness.presentation.screens.common_components.Exercise
import com.example.healthyfitness.data.data_source.local.FitnessDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext

class BackExerciseViewModel : ViewModel() {
    private val _exercises = MutableStateFlow<List<Exercise>>(emptyList())
    val exercises: StateFlow<List<Exercise>> = _exercises

    private var backDao = FitnessDatabase.getDaoInstance(MyApplication.getApplicationContext())

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow("")
    val errorMessage: StateFlow<String> = _errorMessage

    fun fetchExercises() {
        _isLoading.value = true

        viewModelScope.launch {
            try {
                val response = getAllBackExercise()
                _exercises.value = response
            } catch (e: Exception) {
                _errorMessage.value = e.message ?: "An error occurred"
            } finally {
                _isLoading.value = false
            }
        }
    }

     suspend fun getAllBackExercise() = withContext(Dispatchers.IO) {
        try {
            val response = BackRetrofitInstance.api.getExercises()
            backDao.insertAllExercises(response)
            return@withContext response
        }
        catch (e:Exception){
            val response = backDao.getAllPartExercises().filter { it.bodyPart == "back" }
            return@withContext response
        }

    }

    suspend fun getBackExerciseById(id : String) = withContext(Dispatchers.IO) {
        try {
            val exercise = backDao.getExerciseById(id)
            return@withContext exercise
        }
        catch (e:Exception){
            throw (e)
        }
    }
}
