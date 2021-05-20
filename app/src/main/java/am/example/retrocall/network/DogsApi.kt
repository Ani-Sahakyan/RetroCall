package am.example.retrocall

import am.example.retrocall.models.DogsList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DogsApi {
    @GET("dogs")
     suspend fun getDogsData(): Response<DogsList>
}

object DogRetrofitService{
    val retrofit = Retrofit.Builder()
        .baseUrl("http://178.128.140.229:3002/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor()
                .apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }).build())
        .build()
}