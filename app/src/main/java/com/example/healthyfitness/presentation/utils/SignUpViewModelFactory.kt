import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.healthyfitness.data.data_source.repository.SignUpRepository
import com.example.healthyfitness.presentation.screens.viewmodels.SignUpViewModel

class SignUpViewModelFactory(
    private val repository: SignUpRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
            return SignUpViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


