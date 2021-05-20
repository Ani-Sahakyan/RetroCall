package am.example.retrocall.network

import am.example.retrocall.models.FoodBowlsList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface FoodBowlApi {
    @GET("keri_aman")
    suspend fun getFoodBowlData(): Response<FoodBowlsList>
}

object FoodBowlRetrofitService{
    val retrofit = Retrofit.Builder()
        .baseUrl("http://178.128.140.229:3002/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                .apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }).build())
        .build()
}