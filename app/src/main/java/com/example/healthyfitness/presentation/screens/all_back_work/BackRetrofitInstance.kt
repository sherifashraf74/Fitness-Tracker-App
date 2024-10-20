import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BackRetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BackExerciseApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: BackExerciseApiService by lazy {
        retrofit.create(BackExerciseApiService::class.java)
    }
}
